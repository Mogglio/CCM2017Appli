// MyInterface.aidl
package com.mathieu.api;

// Declare any non-default types here with import statements

interface MyInterface {
int get_sms(in String smsMessageStr, out String[] smsList);

}
