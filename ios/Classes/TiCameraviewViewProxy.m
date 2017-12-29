/**
 * BeK0sukeTicameraViewProxy.m
 */

#import "TiCameraviewViewProxy.h"
#import "TiCameraviewView.h"
#import "TiUtils.h"

@implementation TiCameraviewViewProxy

-(id)isFrontCamera:(id)args
{
    return [(TiCameraviewView*)[self view] isFrontCamera:args];
}

-(id)isBackCamera:(id)args
{
    return [(TiCameraviewView*)[self view] isBackCamera:args];
}

-(id)isTorch:(id)args
{
    return [(TiCameraviewView*)[self view] isTorch:args];
}

#ifndef USE_VIEW_FOR_UI_METHOD
#define USE_VIEW_FOR_UI_METHOD(methodname)\
-(void)methodname:(id)args\
{\
[self makeViewPerformSelector:@selector(methodname:) withObject:args createIfNeeded:YES waitUntilDone:NO];\
}
#endif

USE_VIEW_FOR_UI_METHOD(startCamera);
USE_VIEW_FOR_UI_METHOD(stopCamera);

USE_VIEW_FOR_UI_METHOD(toggleCamera);
USE_VIEW_FOR_UI_METHOD(toggleTorch);

USE_VIEW_FOR_UI_METHOD(takePicture);
USE_VIEW_FOR_UI_METHOD(startRecording);
USE_VIEW_FOR_UI_METHOD(stopRecording);
USE_VIEW_FOR_UI_METHOD(startInterval);
USE_VIEW_FOR_UI_METHOD(stopInterval);

@end
