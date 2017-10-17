
#import "HDHint.h"
#import "MBProgressHUD.h"

@implementation HDHint

+(void)showLoading {
  [HDHint endLoading];
    UINavigationController *nav = (UINavigationController *)[UIApplication sharedApplication].delegate.window.rootViewController;
    MBProgressHUD  *hud = [MBProgressHUD showHUDAddedTo:nav.view animated:YES];
  
  [hud hideAnimated:YES afterDelay:6.0];
}

+ (void)endLoading {
    UINavigationController *nav = (UINavigationController *)[UIApplication sharedApplication].delegate.window.rootViewController;
    [MBProgressHUD hideHUDForView:nav.view animated:YES];
}
@end
