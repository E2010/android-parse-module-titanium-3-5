/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2011-2013 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */

/** This is generated, do not edit by hand. **/

#include <jni.h>

#include "Proxy.h"

		namespace com {
		namespace ez2010 {
		namespace androidtitaniumparse {


class AndroidTitaniumParseModule : public titanium::Proxy
{
public:
	explicit AndroidTitaniumParseModule(jobject javaObject);

	static void bindProxy(v8::Handle<v8::Object> exports);
	static v8::Handle<v8::FunctionTemplate> getProxyTemplate();
	static void dispose();

	static v8::Persistent<v8::FunctionTemplate> proxyTemplate;
	static jclass javaClass;

private:
	// Methods -----------------------------------------------------------
	static v8::Handle<v8::Value> createObject(const v8::Arguments&);
	static v8::Handle<v8::Value> deleteObject(const v8::Arguments&);
	static v8::Handle<v8::Value> registerForPush(const v8::Arguments&);
	static v8::Handle<v8::Value> unsubscribeFromPush(const v8::Arguments&);
	static v8::Handle<v8::Value> registerForMultiplePushChannel(const v8::Arguments&);
	static v8::Handle<v8::Value> pushChannelList(const v8::Arguments&);
	static v8::Handle<v8::Value> registerForSinglePushChannel(const v8::Arguments&);
	static v8::Handle<v8::Value> example(const v8::Arguments&);
	static v8::Handle<v8::Value> unsubscribeFromAllChannels(const v8::Arguments&);
	static v8::Handle<v8::Value> initParse(const v8::Arguments&);
	static v8::Handle<v8::Value> registerForPushOverwrite(const v8::Arguments&);
	static v8::Handle<v8::Value> updateObject(const v8::Arguments&);
	static v8::Handle<v8::Value> findObjects(const v8::Arguments&);

	// Dynamic property accessors ----------------------------------------
	static v8::Handle<v8::Value> getter_exampleProp(v8::Local<v8::String> property, const v8::AccessorInfo& info);
	static void setter_exampleProp(v8::Local<v8::String> property, v8::Local<v8::Value> value, const v8::AccessorInfo& info);

};

		} // androidtitaniumparse
		} // ez2010
		} // com
