Ti.CameraView
===========================================

This is a merge of two cameraviews.

* <img src="https://avatars2.githubusercontent.com/u/868379?s=460&v=4" width=60>     [Jonathan's CameraView](https://github.com/jonathanrcarter/CameraView) 
* <img width=60 src="https://avatars1.githubusercontent.com/u/1230342?s=460&v=4">     [Brownemint's Android CameraView](https://github.com/brownemint/Ti-Android-CameraView)

I have renamed, build for SDK7.

This CameraView is real time output ImageView from device camera. So the native camera control will not be displayed. But you can set the control buttons and control the movies by yourself.

Installing
----------

```
gittio install ti.cameraview
```

Simple usage (only view)
-----------------------

```
var CamView = require('ti.cameraview');

var win = Ti.UI.createWindow();
function showCamera() {
	var CameraView = CamView.createView({
		width: 300,
		height: 300,
		
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

