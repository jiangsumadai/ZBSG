//
//  SmoothLoading.m
//  SmoothLoading
//
//  Created by 周尧 on 2017/10/18.
//  Copyright © 2017年 edward. All rights reserved.
//

#import "SmoothLoading.h"
#import "HDHint.h"

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
