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
var CV = require('ti.cameravieww');

CameraView= CV.createView({
	width: 300,
	height: 300,
	cameraPosition: TiCamera.hasFrontCamera() ? CV.CAMERA_FRONT : CV.CAMERA_BACK,
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
