/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2013 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package ti.cameraview;

import org.appcelerator.kroll.KrollModule;

import android.content.pm.PackageManager;
import android.content.Context;
import org.appcelerator.kroll.annotations.Kroll;

import org.appcelerator.titanium.TiApplication;
import org.appcelerator.kroll.common.Log;

@Kroll.module(name = "CameraView", id = "ti.cameraview")
public class CameraViewModule extends KrollModule {
	private static final String TAG = "CamView";

	public CameraViewModule() {
		super();
	}

	@Kroll.constant
	public static final int RESOLUTION_HIGH = 0;

	@Kroll.constant
	public static final int RESOLUTION_LOW = 1;

	@Kroll.constant
	public static final int RESOLUTION_SCREEN = 2;

	@Kroll.constant
	public static final int RESOLUTION_480 = 3;

	@Kroll.constant
	public static final int RESOLUTION_720 = 4;

	@Kroll.constant
	public static final int RESOLUTION_1080 = 5;

	@Kroll.method
	public boolean hasFrontCamera() {
		Context ctx = TiApplication.getInstance().getApplicationContext();
		if (ctx.getPackageManager().hasSystemFeature(
				PackageManager.FEATURE_CAMERA_FRONT)) {
			return true;
		} else {
			return false;
		}
	}

	@Kroll.onAppCreate
	public static void onAppCreate(TiApplication app) {
		Log.d(TAG, "inside onAppCreate");
	}
}
