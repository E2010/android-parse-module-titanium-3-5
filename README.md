# Android Parse Module for Titanium3.5+

<h2>About the Module</h2>
This module is based on the module created by <a href="https://github.com/ndizazzo/android-parse-titanium-module">Nick</a>
with changed below

1. Using new Titanium SDK module structure. (Titanium SDK3.5.1)
2. Using new Parse Module 1.9.2
3. Add 2 new functions

<b>public void registerForSinglePushChannel()</b>
   // No need to delete existing channel first, only the new channel passed to this function will be subscribed.

<b>public void unsubscribeFromAllChannels()</b>
  // unsubscribe from all channels and no need to get channel list first.

<b>public void registerForMultiplePushChannel()</b>
// register to multiple channels in one call. (old channels will be overite).
