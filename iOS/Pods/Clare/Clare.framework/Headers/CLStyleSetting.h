//
//  CLStyleSetting.h
//  Clare
//
//  Created by LiuZekai on 2019/1/1.
//  Copyright © 2019 Clare. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>

NS_ASSUME_NONNULL_BEGIN

@interface CLStyleSetting : NSObject

@property (nonatomic, strong) UIColor * chatBgColor;
@property (nonatomic, strong) UIColor * linkColor;
@property (nonatomic, strong) UIColor * watermarkColor;

@property (nonatomic, strong) UIColor * headerBarBgColor;
@property (nonatomic, strong) UIColor * headerBarFontColor;
 
@property (nonatomic, strong) UIColor * bubbleBgColor;
@property (assign) BOOL  bubbleBorder;
@property (nonatomic, strong) UIColor * bubbleFontColor;

@property (nonatomic, strong) UIColor * quickReplyButtonBgColor;
@property (nonatomic, strong) UIColor * quickReplyButtonBorderColor;

@property (nonatomic, strong) UIColor * quickReplyButtonFontColor;

@property (nonatomic, strong) UIColor * searchResultFontColor;

@property (nonatomic, strong) UIColor * postbackBgColor;
@property (nonatomic, strong) UIColor *  postbackBorderColor;
@property (nonatomic, strong) UIColor * postbackFontColor;

@property (nonatomic, strong) UIColor * userBubbleBgColor;
@property (assign) BOOL userBubbleBorder; 
@property (nonatomic, strong) UIColor * userBubbleFontColor;

@end

NS_ASSUME_NONNULL_END
