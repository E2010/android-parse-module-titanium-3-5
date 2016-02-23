// This is a test harness for your module
// You should do something interesting in this harness
// to test out the module and to provide instructions
// to users on how to use it by example.


// open a single window
var win = Ti.UI.createWindow({
	backgroundColor:'white'
});
var label = Ti.UI.createLabel();
win.add(label);
win.open();

// TODO: write your module tests here
var android_titanium_parse = require('com.ez2010.androidtitaniumparse');
Ti.API.info("module is => " + android_titanium_parse);

label.text = android_titanium_parse.example();

Ti.API.info("module exampleProp is => " + android_titanium_parse.exampleProp);
android_titanium_parse.exampleProp = "This is a test value";

if (Ti.Platform.name == "android") {
	var proxy = android_titanium_parse.createExample({
		message: "Creating an example Proxy",
		backgroundColor: "red",
		width: 100,
		height: 100,
		top: 100,
		left: 150
	});

	proxy.printMessage("Hello world!");
	proxy.message = "Hi world!.  It's me again.";
	proxy.printMessage("Hello world!");
	win.add(proxy);
}


/*
 * Add these two lines to tiapp.xml first
 * 
 *     <property name="Parse_AppId">YOUR APP ID</property>
 *     <property name="Parse_ClientKey">YOUR CLIENT KEY</property> 
 * 
 * 
 */

var Parse = require("com.ez2010.androidtitaniumparse");
var app_id = "YOUR APP ID";  // Still need add property to tiapp.xml as mentioned above
var client_key = "YOUT CLIENT KEY"; // Still need add property to tiapp.xml as mentioned above

if (Parse) {
  Parse.initParse({
    appId: app_id,
    clientKey: client_key
  });
  
  //Add a single channel to existing channels
  Parse.registerForPush("pushDeviceToken", "testcitysingle", function(e){console.log(e);});
  
  //Register to a single channel and override old channels
  Parse.registerForSinglePushChannel("pushDeviceToken", "testcity3", function(e){console.log(e);});
  
  //Register to multiple channels and override old channels
  Parse.registerForMultiplePushChannel("pushDeviceToken", ["testcity1", "testcity2"], function(e){console.log(e);});
  
}



