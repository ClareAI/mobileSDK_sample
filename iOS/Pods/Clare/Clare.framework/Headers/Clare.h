//
//  Clare.h
//  Clare
//
//  Created by LiuZekai on 22/06/2018.
//  Copyright © 2018 LiuZekai. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "CLSettings.h"
#import "CLStyleSetting.h"
#import "CLLogoSetting.h"

//! Project version number for Clare.
FOUNDATION_EXPORT double ClareVersionNumber;

//! Project version string for Clare.
FOUNDATION_EXPORT const unsigned char ClareVersionString[];

// In this header, you should import all the public headers of your framework using statements like #import <Clare/PublicHeader.h>
typedef void(^completion)(BOOL ignored,BOOL success, NSError* _Nullable error);

@protocol ConversationDelegate <NSObject>
- (void)onUnreadCountChanged:(int)count;
@end

@protocol ChatBotDelegate <NSObject>
- (void)onChotBotClosed;
@end

@interface Clare : NSObject

+ (Clare*_Nullable)sharedManager;

-(void)init:(CLSettings *_Nonnull)settings withCompletion:(nonnull completion)completion;

-(void)show;
-(void)hide;
-(void)recover;
-(void)showWithoudWidget;
-(void)collapse;

-(void)updateUserProperties:(nonnull NSMutableDictionary *)properties completionHandler:(void (^_Nonnull)(NSData * _Nullable data, NSURLResponse * _Nullable response, NSError * _Nullable error))completionHandler;

- (NSDictionary *_Nonnull)getUserSession;
- (void)reSetClare;

-(void)setStyle:(CLStyleSetting*_Nullable)styleSetting;
-(CLStyleSetting*_Nullable)getStyle;

-(void)setLogo:(CLLogoSetting*_Nullable)logoSetting;

-(UIImage*_Nullable)getDefaultLogo;
-(UIImage*_Nullable)getSalesforceLogo;
-(UIImage*_Nullable)getApiLogo;
-(UIImage*_Nullable)getLivechatLogo;

-(CGFloat)getBubbleWidth;
-(CGRect)getBubbleDefaultFrame;

-(BOOL)getOpenedChatWidget;
-(void)setOpenedChatWidget:(BOOL)isOpened;

@property(nonatomic) CLSettings* _Nullable settings;
@property(weak, nullable) id<ConversationDelegate> conversationDelegate;
@property(weak, nullable) id<ChatBotDelegate> chatBotDelegate;

@end
