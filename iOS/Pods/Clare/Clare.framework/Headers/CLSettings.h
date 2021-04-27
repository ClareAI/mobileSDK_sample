//
//  CLSettings.h
//  Clare
//
//  Created by LiuZekai on 22/06/2018.
//  Copyright © 2018 LiuZekai. All rights reserved.
//
#import <UIKit/UIKit.h>
#import <Foundation/Foundation.h>


@interface CLSettings : NSObject
+(CLSettings*)initWithAppId:(NSString*)appId;
@property(nonatomic, copy) NSString* appId;
@property(nonatomic, copy) NSString* userId;
@property(nonatomic, copy) NSString* sessionId;
@property(nonatomic, copy) NSString* host;
@property(nonatomic, copy) NSString* appName;
@property(nonatomic) UIImage* bubbleImage;
@property(nonatomic) UIImage* avatarImage;
@property(nonatomic) UIColor* themeColor;
@property(nonatomic) BOOL isReplyButtonInOneRow;
@property(nonatomic) BOOL microphoneEnable;
@property(nonatomic) BOOL voiceEnable;
@property(nonatomic) BOOL loadHistory;
@property(nonatomic) BOOL sendGreetingAgain;
@property(nonatomic) BOOL languageDetection;
@property(nonatomic) NSMutableDictionary *titles;
@property(nonatomic) NSMutableDictionary *disclaimers;
@property(nonatomic) NSMutableDictionary* connect_error_msg;
@property(nonatomic) NSMutableDictionary *properties;
@property(nonatomic) BOOL allowUploadFile;
@property(nonatomic) BOOL autoStart;
@property(nonatomic) CGPoint customBubblePosition;
@property(nonatomic) NSString* senderPlaceHolder;

-(void)setProperties:(NSMutableDictionary *)properties;



@property(nonatomic) NSArray* languages;
-(void)setLanguages:(NSArray *)languageArray;

@property(nonatomic, copy) NSString* speechApi;
-(void)setSpeechPhraseHints:(NSString *)language withHints:(NSArray *)hintsArray;
-(NSArray *)getSpeechPhraseHints:(NSString *)language;
@end
