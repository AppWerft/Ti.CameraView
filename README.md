Ti.CameraView
===========================================

This is a parity merge of [TiCameraView](https://github.com/k0sukey/TiCameraView) (iOS) and [Ti-Android-CameraView
](https://github.com/brownemint/Ti-Android-CameraView) (Android) 

This CameraView is real time output ImageView from device camera. So the native camera control will not be displayed. But you can set the control buttons and control the movies by yourself.

Installing
----------

```
gittio install ti.cameraview
```

Usage
-----

```
var win = Ti.UI.createwWindow();
var CV = require('ti.cameraview');

CameraView= CV.createView({
	width: 300,
	height: 300,
	cameraPosition: CV.hasFrontCamera() ? CV.CAMERA_FRONT : CV.CAMERA_BACK,
});
win.add(CameraView)
win.open();


CameraView.takePicture({
	saveToPhotoGallery: true,	// default false
	shutterSound: false,		// default true
	success: function(e){
		// e.media(TiBlob), like Ti.Media.showCamera
	},
	error: function(e){
	}
});
```

Android specific permissions
----------------------------

For android you need two things:

This entry inb manifest:

```xml
<uses-permission android:name="android.permission.CAMERA"/>
<uses-feature android:name="android.hardware.camera"/>
<uses-feature android:name="android.hardware.camera.autofocus"/>
```
and since Marshmellow you need runtime permission.

```javascript
function showCamera() {
	var CV = require("ti.cameraview");
	var CameraView = CV.createView({
		save_location: "my_app",
		useFrontCamera: true,
		pictureTimeout: 200,
		resolutionNamed: CV.RESOLUTION_480
	});
	
	var btSnap = Ti.UI.createButton({
		title: "Capture",
		bottom: "10dp",
		height: "80dp",
		width: "80dp",
		zIndex: 2
	});

	btSnap.addEventListener("click", function(){
		CameraView.snapPicture();
	});

	CameraView.addEventListener("picture_taken", function(evt){
		alert("Image saved to "+evt.path);
	});

	win.addEventListener("close", function(){
		CameraView = null;
	});

	win.add(CameraView);
	win.add(btSnap);
}

if( Ti.Media.isCameraSupported ) {
	if (Ti.Media.hasCameraPermissions()) {
	    showCamera();
	} else { 
	    Ti.Media.requestCameraPermissions(function(e) {
            if (e.success === true) {
                showCamera();
            } else {
                alert("Access denied, error: " + e.error);
            }
	    });
	}
} else {
	alert("No camera found!");
}
```

Constants
---------



#### iOS
- QUALITY_PHOTO 
- QUALITY_HIGH 
- QUALITY_MEDIUM 
- QUALITY_LOW 
- QUALITY_640x480 
- QUALITY_1280x720

#### Android 
- RESOLUTION_HIGH - Use the highest resolution available on the device
- RESOLUTION_LOW - Use the lowest resolution available on the device
- RESOLUTION_SCREEN - Try to match the views resolution for the picture
- RESOLUTION_480 - Set the resolution to 720x480 (or as close as possible)
- RESOLUTION_720 - Set the resolution to 1280x720 (or as close as possible)
- RESOLUTION_1080 - Set the resolution to 1920x1080 (or as close as possible)



Methods of Module
-----------------

### createView() <img src="http://envyandroid.com/content/images/2015/03/android3.png" width=24 />

#### Properties:



Methods of CameraView
--------------------

### takePicture() <img src="http://envyandroid.com/content/images/2015/03/android3.png" width=24 />


### startRecording() <img src="http://icons.iconarchive.com/icons/uiconstock/socialmedia/512/Apple-icon.png" width=20 /><img src="http://envyandroid.com/content/images/2015/03/android3.png" width=24 />

### stopRecording() <img src="http://icons.iconarchive.com/icons/uiconstock/socialmedia/512/Apple-icon.png" width=20 /><img src="http://envyandroid.com/content/images/2015/03/android3.png" width=24 />