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

Simple usage (only view)
-----------------------

```
var CV = require('ti.cameraview');

var win = Ti.UI.createWindow();
function showCamera() {
	var CameraView = CV.createCameraView({
		width: 300,
		height: 300,
		cameraPosition: Ti.Platform.osname=="iphone" || CV.hasFrontCamera() ? CV.CAMERA_FRONT : CV.CAMERA_BACK,
	});
	win.add(CameraView);					
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
win.open();
```

Permissions
-------------

For android you need this entry in Manifest.xml:

```xml
<uses-permission android:name="android.permission.CAMERA"/>
<uses-feature android:name="android.hardware.camera"/>
<uses-feature android:name="android.hardware.camera.autofocus"/>
```

For iOS>10 you need this entry in .plist (tiapp.xml)

```xml
<key>NSCameraUsageDescription</key>
<string>Privacy - Camera Usage Description <== to edit!</string>
```

Constants
---------

- QUALITY_PHOTO 
- QUALITY_HIGH 
- QUALITY_MEDIUM 
- QUALITY_LOW 
- QUALITY_640x480 
- QUALITY_1280x720
- CAMERA_FRONT
- CAMERA_BACK



Methods of Module
-----------------

### createView() <img src="http://icons.iconarchive.com/icons/uiconstock/socialmedia/512/Apple-icon.png" width=20 /><img src="http://envyandroid.com/content/images/2015/03/android3.png" width=24 />

#### Properties:
- standard view properties (width, height, top, backgroundWidth, etc.)
- videoQuality (one of QUALITY constants)
- cameraPosition (one CAMERA_FRONT, CAMERA_BACk constants)

### hasFrontCamera()<img src="http://icons.iconarchive.com/icons/uiconstock/socialmedia/512/Apple-icon.png" width=20 /><img src="http://envyandroid.com/content/images/2015/03/android3.png" width=24 />
Has camera check in device, front
### hasBackCamera()<img src="http://icons.iconarchive.com/icons/uiconstock/socialmedia/512/Apple-icon.png" width=20 /><img src="http://envyandroid.com/content/images/2015/03/android3.png" width=24 />
Has camera check in device, back
### hasTorch()<img src="http://icons.iconarchive.com/icons/uiconstock/socialmedia/512/Apple-icon.png" width=20 /><img src="http://envyandroid.com/content/images/2015/03/android3.png" width=24 />
Has LED flash light check in device
### isTorch()<img src="http://icons.iconarchive.com/icons/uiconstock/socialmedia/512/Apple-icon.png" width=20 />
Now LED flash light on or off in created CameraView method

### toggleTorch()<img src="http://icons.iconarchive.com/icons/uiconstock/socialmedia/512/Apple-icon.png" width=20 />
Toggle front or back camera in created CameraView method

### startCamera() / stopCamera() <img src="http://icons.iconarchive.com/icons/uiconstock/socialmedia/512/Apple-icon.png" width=20 />

Start or stop camera output in created CameraView method


Methods of CameraView
--------------------

### takePicture() <img src="http://icons.iconarchive.com/icons/uiconstock/socialmedia/512/Apple-icon.png" width=20 /><img src="http://envyandroid.com/content/images/2015/03/android3.png" width=24 />

### startRecording() <img src="http://icons.iconarchive.com/icons/uiconstock/socialmedia/512/Apple-icon.png" width=20 />

### stopRecording() <img src="http://icons.iconarchive.com/icons/uiconstock/socialmedia/512/Apple-icon.png" width=20 />

Events of Camera	View
-------------------