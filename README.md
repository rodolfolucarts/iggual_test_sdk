# iggual_test_sdk
Iggual test SDK is an example application for testing purposes only

##Installation
1. Download OpenCV SDK for Android version 4.5.3  from (https://opencv.org/releases/)
2. Extract to a folder. ie. /home/developer/opencv
3. Comment or remove line 139 on file $OPENCV_HOME/sdk/build.gradle

##Configuration
1. use these libs on build.gradle
api 'com.intuit.ssp:ssp-android:1.0.5'
api 'com.intuit.sdp:sdp-android:1.0.5'
implementation (files("/file-path-for-iggual-sdk/iggual-android-sdk-0.0.1.aar"))
implementation project(path: ':opencv')
implementation 'com.squareup.okhttp:okhttp:2.5.0'
implementation 'com.github.f0ris.sweetalert:library:1.5.6'

2. insert the following text on gradle.properties (module)
   opencvsdk=/path-to-opencv-sdk/
   
3. insert the following lines on your gradle.properties (app)
   include ':opencv'
   project(':opencv').projectDir = new File(opencvsdk + '/sdk')
   
4. Sync your project, then run it on any Android device.

##Instructions
It's simple to use our SDK, just call capture method on IggualBiometricConnector class, as you can see inside MainActivity class. 
At this moment, you can pass any values to test, we are not validating any data.

To receive information about the finger capture, you'll need to implement an ActivityResult, as you can see on MainActivity class as well
