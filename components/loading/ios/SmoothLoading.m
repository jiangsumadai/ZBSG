#import <React/RCTBridgeModule.h>
#import "HDHint.h"

@interface SmoothLoading : NSObject <RCTBridgeModule>
@end

@implementation SmoothLoading

RCT_EXPORT_MODULE();

RCT_EXPORT_METHOD(showLoading)
{
    dispatch_async(dispatch_get_main_queue(), ^{
        [HDHint showLoading];
    });
}

RCT_EXPORT_METHOD(hideLoading)
{
    dispatch_async(dispatch_get_main_queue(), ^{
        [HDHint endLoading];
    });
}

@end
