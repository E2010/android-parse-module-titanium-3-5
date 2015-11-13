# Android Parse Module for Titanium3.5+

<h2>About the Module</h2>
This module is based on the module created by <a href="https://github.com/ndizazzo/android-parse-titanium-module">Nick</a>
with changed below

1. Using new Titanium SDK module structure. (Titanium SDK3.5.1) - refer to the steps below for upgrade to different SDK.
2. Using new Parse Module 1.9.2
3. Add 2 new functions

<b>public void registerForSinglePushChannel()</b>
   // No need to delete existing channel first, only the new channel passed to this function will be subscribed.

<b>public void unsubscribeFromAllChannels()</b>
  // unsubscribe from all channels and no need to get channel list first.

<b>public void registerForMultiplePushChannel()</b>
// register to multiple channels in one call. (old channels will be overidden).

<h2>Start to Compile</h2>

In order to compile and build in your own SDK environment, include change from Titanium to Appcelerator, please follow the instructions below. (These are done in Mac)

<b>1. JDT (java development tool) </b>
To check if JDT installed properly, try to create a new Android module with Titanium/Appcelerator studio (File->New->Mobile Module Project). Select Android as deployment targets. If JDT is not installed, there will be a link that lead to the Guide of how to install JDT plugin in studio. Follow the step and install.

<b>2. Google ndk </b>
This module needs Google ndk that can be downloaded here. http://developer.android.com/ndk/downloads/index.html
After download, extract following the instruction at the link above. Go to Appcelerator(Titanium) Studio, open Preferences menu. Choose Studio->Platforms->Android. Make sure ndk folder is setup correctly in Android NDK home field.

<b>3. android/build.properties </b>
Make sure all 3 folders saved in this file (in android module folder) are correct. If not sure, this is the easy way to get correct info. Create a new Android module with your own studio from menu File->New->Mobile Module Project and select Android as deployment targets. Find the same file in this new module just created and copy them to Android Parse Module file.

<b>4. created 2 new folders </b>
Some how, the compile need these 2 folder but Appcelerator Studio does not created them. So you have to create this 2 empty folders manually.
    1. android/build/docs
    2. android/build/.apt_generated (Keep the ".", it is a invisible folder for Mac. Titanium Studio might not need this.)

<b>5. Parse Initial </b>
The module is good to compile now. But if you test it with a new App, remember to put these properties into tiapp.xml with Your Own Parse Keys.

    <property name="Parse_AppId">YourOwnParseAppID</property>
    <property name="Parse_ClientKey">YourOwnParseClientKey</property>

