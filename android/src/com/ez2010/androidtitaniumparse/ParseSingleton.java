/*

The MIT License (MIT)

Copyright (c) 2014 Nick DiZazzo

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

*/

package com.ez2010.androidtitaniumparse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.List;

import com.parse.Parse;
import com.parse.ParsePush;
import com.parse.PushService;
import com.parse.ParseObject;
import com.parse.FindCallback;
import com.parse.SaveCallback;
import com.parse.DeleteCallback;
import com.parse.ParseQuery;
import com.parse.ParseException;
import com.parse.ParseAnalytics;
import com.parse.ParseInstallation;
import com.parse.ParseRelation;
import com.parse.ParseGeoPoint;
import com.parse.ParseFile;

import org.appcelerator.titanium.TiApplication;
import org.appcelerator.kroll.KrollFunction;
import org.appcelerator.kroll.common.Log;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings.Secure;

public class ParseSingleton {
  private static final String TAG = "ParseSingleton";
  private static ParseSingleton instance = null;
  private boolean initialized = false;

  public static String PROPERTY_APP_ID = "Parse_AppId";
  public static String PROPERTY_CLIENT_KEY = "Parse_ClientKey";
  public static String PROPERTY_SERVER_URL = "Parse_ServerUrl";

  protected ParseSingleton() {
  }

  public static ParseSingleton Instance() {
    if (instance == null) {
       instance = new ParseSingleton();
    }
    return instance;
  }

  public void InitializeParse(String appId, String clientKey, TiApplication application) {
    Context appContext = application.getApplicationContext();

    if (appContext == null) {
      Log.e(TAG, "Application context is null, cannot continue...");
      return;
    }
    else if (appId != null && appId.isEmpty()) {
      Log.e(TAG, "Application key is required! Parse has NOT been initialized.");
      return;
    }
    else if (clientKey != null && clientKey.isEmpty()) {
      Log.e(TAG, "Client key is required! Parse has NOT been initialized.");
      return;
    }

    if (!initialized) {
      Log.d(TAG, "Initializing with: '" + appId + "' and '" + clientKey + "'.");
      Parse.initialize(appContext, appId, clientKey);

      initialized = true;
    }
    else
    {
      Log.e(TAG, "Parse has already been initialized!");
    }
  }
  
  // ClientKey is null no matter what passed
  public void InitializeParseWithConfig(String appId, String clientKey, String serverUrl, TiApplication application) {
	    Context appContext = application.getApplicationContext();

	    if (appContext == null) {
	      Log.e(TAG, "Application context is null, cannot continue...");
	      return;
	    } else if (appId != null && appId.isEmpty()) {
	      Log.e(TAG, "Application key is required! Parse has NOT been initialized.");
	      return;
	    } else if (serverUrl != null && serverUrl.isEmpty()) {
		  Log.e(TAG, "Server Url is required! Parse has NOT been initialized.");
		  return;
		}

	    if (!initialized) {
	      Log.d(TAG, "Initializing with: '" + appId + "' and '" + serverUrl + "'.");
	      
	      Parse.initialize(new Parse.Configuration.Builder(appContext)
	        .applicationId(appId)
	        .clientKey(null)
	        .server(serverUrl)
	        .build());

	      initialized = true;
	    }
	    else
	    {
	      Log.e(TAG, "Parse has already been initialized!");
	    }
  }


  public static void EnablePush(TiApplication app) {
    Context appContext = app.getApplicationContext();
    Activity appActivity = app.getAppCurrentActivity();

    if (appContext == null) {
      Log.e(TAG, "Application context is null, can't initialize Parse");
      return;
    }
    else if (appActivity == null) {
      Log.e(TAG, "Application activity is null, can't initialize Parse");
      return;
    }
    else {
      //PushService.setDefaultPushCallback(appContext, appActivity.getClass());
      ParseAnalytics.trackAppOpened(appActivity.getIntent());
      ParseInstallation.getCurrentInstallation().saveInBackground();
    }
  }

  public void FindDataObjects(String objectName, HashMap[] conditions, FindCallback<ParseObject> callback) {
    ParseQuery<ParseObject> query = QueryFactory.Build(objectName, conditions);
    query.findInBackground(callback);
  }

  public void CreateDataObject(String objectName, HashMap fields, SaveCallback callback) {
    ParseObject dataObject = new ParseObject(objectName);
    Set<Map.Entry<Object, Object>> keyValuePairs = fields.entrySet();

    for (Map.Entry<Object, Object> item : keyValuePairs) {
      String key = (String)item.getKey();
      Object value = item.getValue();
      dataObject.put(key, ParseDataConversions.ConvertToParseObjectIfNecessary(value));
    }

    dataObject.saveInBackground(callback);
  }

  public void UpdateDataObject(ParseObject updateObject, SaveCallback callback) {
    if (updateObject != null) {
      updateObject.saveInBackground(callback);
    }
  }

  public void DeleteDataObject(String className, String objectId, DeleteCallback callback) {
    ParseObject object = ParseObject.createWithoutData(className, objectId);
    object.deleteInBackground(callback);
  }

  public boolean ValidChannelName(String channelName) {
    if (channelName.matches("^[a-zA-Z].[a-zA-Z0-9_-]*$")) {
      return true;
    }
    else {
      return false;
    }
  }

  public void SubscribeToPushChannel(String channelName) {
    ParsePush.subscribeInBackground(channelName);
  }
  
  public void SubscribeToSinglePushChannel(String channelName){
	// Get current Channel list
	List<String> currentChannels = ChannelSubscriptionList();
	if (currentChannels != null) {
	  for (String c : currentChannels) {
	    if (!c.equals(channelName)) {
		  UnsubscribeFromPushChannel(c);
	    }
	  }
	}
	
	SubscribeToPushChannel(channelName);
	/*
	  ArrayList<String> channelList = new ArrayList<String>();
	  channelList.add(channelName);

	  ParseInstallation currentInstallation = ParseInstallation.getCurrentInstallation();
	  currentInstallation.put("channelsoverride", channelList);
	  currentInstallation.saveEventually();
	  */
  }

  public void SubscribeToMultiplePushChannel(String[] channels){
	  /*
	// Get current channels
	List<String> currentChannels = ChannelSubscriptionList();
	
	// New channel list
	List<String> newChannels = new ArrayList<String>();
	newChannels.addAll(Arrays.asList(channels));
	
	if (currentChannels != null) {
	  for (String c : currentChannels) {
		if (newChannels !=null) {
          if (!newChannels.contains(c)) {
    		  UnsubscribeFromPushChannel(c);
          }
		} else {
		  UnsubscribeFromPushChannel(c);
		}
	  }
	}
	
	for (String nc: newChannels) {
	  SubscribeToPushChannel(nc);
	}*/
	  
	  List<String> channelList = new ArrayList<String>();
	  //channelList.add(channelName);
	  channelList.addAll(Arrays.asList(channels));
	  
	  ParseInstallation currentInstallation = ParseInstallation.getCurrentInstallation();
	  currentInstallation.put("channels", channelList);
	  //currentInstallation.saveEventually();
	  currentInstallation.saveInBackground();
  }

  public void UnsubscribeFromPushChannel(String channelName) {
    ParsePush.unsubscribeInBackground(channelName);
  }

  public void UnsubscribeFromAllChannels(){
	// Get current channels
	List<String> currentChannels = ChannelSubscriptionList();
	
	if (currentChannels != null) {
	  for (String c : currentChannels) {
		UnsubscribeFromPushChannel(c);
	  }
	}
/*	
	  //ParsePush.setChannel(channelName);
	  ArrayList<String> emptyList = new ArrayList<String>();

	  //String[] channelArray = {channelName};
	  ParseInstallation currentInstallation = ParseInstallation.getCurrentInstallation();
	  currentInstallation.put("channels", emptyList);
	  currentInstallation.saveEventually();
	  */
  }

  public List<String> ChannelSubscriptionList() {
    return ParseInstallation.getCurrentInstallation().getList("channels");
  }
}
