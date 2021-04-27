//
//  AppDelegate.swift
//
//
//  Created by Ying Yu on 6/23/20.
//  Copyright © 2020 Vernal Yu. All rights reserved.
//

import UIKit
import CoreData
import Clare
import UIColor_Hex_Swift

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {
    
    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
        // Override point for customization after application launch.
        
        self.initClare(host: "{appHost of your clareWeb}", appId: "{appID of your clareWeb}")

        
        return true
    }

    func initClare(host:String,appId:String){
        let clSetting = CLSettings.initWithAppId(appId)
        clSetting?.host = host;
        
        let titles: NSMutableDictionary = [ "zh_HK": "Clare 聊天機械人", "en_US": "Clare Assistant"]
        clSetting?.titles = titles
        
        clSetting?.avatarImage = UIImage(named: "clareai_api")
        
        let disclaimers: NSMutableDictionary = [
            "zh_HK": [
                "<span>• 虛擬助理是全自動化服務，因此無法回答有關您的帳戶資料的問題。<br>• 請勿在您的訊息中透露任何個人帳戶資料。<br></span>",
            ],
            "en_US": [
                "<span>• Virtual Assistant is an automated service, and therefore cannot answer questions specific to your account.<br>• Please do NOT disclose any personal account information in your messages.</span>",
            ]
        ]
        clSetting?.disclaimers = disclaimers
        
        // LANGUAGE
        clSetting?.languages = ["en_US", "zh_HK"]
        clSetting?.languageDetection = true;
        
        clSetting?.themeColor = UIColor(red: 54/255.0, green: 180/255.0, blue: 73/255.0, alpha: 1)
        
        // SETTING PROPERTIES
        clSetting?.microphoneEnable = false;
        clSetting?.voiceEnable = false;
        clSetting?.isReplyButtonInOneRow = false;
        clSetting?.allowUploadFile = true
        clSetting?.sendGreetingAgain = true
        clSetting?.autoStart = false
        clSetting?.loadHistory = false
 
        let styleSetting = CLStyleSetting()
        let chatGreen = UIColor("#36B449")
        let chatGrey = UIColor("#F4F4F4")
        styleSetting.chatBgColor = UIColor.white
        styleSetting.linkColor = UIColor.blue
        styleSetting.watermarkColor = UIColor.clear
        
        styleSetting.headerBarBgColor = chatGreen
        styleSetting.headerBarFontColor = UIColor.white
        
        styleSetting.bubbleBgColor = chatGrey
        styleSetting.bubbleBorder = false
        styleSetting.bubbleFontColor = UIColor.black
        
        styleSetting.quickReplyButtonBgColor = UIColor.white
        styleSetting.quickReplyButtonFontColor = chatGreen
        styleSetting.quickReplyButtonBorderColor = chatGreen
        
        styleSetting.searchResultFontColor = UIColor.black
        
        styleSetting.postbackBgColor = chatGreen
        styleSetting.postbackBorderColor = UIColor.clear
        styleSetting.postbackFontColor = UIColor.white
        
        styleSetting.userBubbleBgColor = chatGreen
        styleSetting.userBubbleBorder = false
        styleSetting.userBubbleFontColor = UIColor.white
        Clare.sharedManager()?.setStyle(styleSetting)
            
        Clare.sharedManager()?.`init`(clSetting!, withCompletion: { (ignored, success, error) in
            if ignored{
                print("already init, not need re-init")
            }else{
                if success{
     
                }
            }
        })
        
        Clare.sharedManager()?.chatBotDelegate = self
        Clare.sharedManager()?.conversationDelegate = self
    }
    
    // MARK: UISceneSession Lifecycle

    @available(iOS 13.0, *)
    func application(_ application: UIApplication, configurationForConnecting connectingSceneSession: UISceneSession, options: UIScene.ConnectionOptions) -> UISceneConfiguration {
        // Called when a new scene session is being created.
        // Use this method to select a configuration to create the new scene with.
        return UISceneConfiguration(name: "Default Configuration", sessionRole: connectingSceneSession.role)
    }

    @available(iOS 13.0, *)
    func application(_ application: UIApplication, didDiscardSceneSessions sceneSessions: Set<UISceneSession>) {
        // Called when the user discards a scene session.
        // If any sessions were discarded while the application was not running, this will be called shortly after application:didFinishLaunchingWithOptions.
        // Use this method to release any resources that were specific to the discarded scenes, as they will not return.
    }
    
    func application(_ app: UIApplication, open url: URL, options: [UIApplication.OpenURLOptionsKey : Any] = [:]) -> Bool {
        
        return true;
    }
    
    func application(_ application: UIApplication, continue userActivity: NSUserActivity, restorationHandler: @escaping ([UIUserActivityRestoring]?) -> Void) -> Bool {
        
        UIApplication.shared.open(userActivity.webpageURL!, options: [:], completionHandler: nil)
        
        return true;
    }

    // MARK: - Core Data stack

    lazy var persistentContainer: NSPersistentContainer = {
        /*
         The persistent container for the application. This implementation
         creates and returns a container, having loaded the store for the
         application to it. This property is optional since there are legitimate
         error conditions that could cause the creation of the store to fail.
        */
        let container = NSPersistentContainer(name: "ClareAI_Swift")
        container.loadPersistentStores(completionHandler: { (storeDescription, error) in
            if let error = error as NSError? {
                // Replace this implementation with code to handle the error appropriately.
                // fatalError() causes the application to generate a crash log and terminate. You should not use this function in a shipping application, although it may be useful during development.
                 
                /*
                 Typical reasons for an error here include:
                 * The parent directory does not exist, cannot be created, or disallows writing.
                 * The persistent store is not accessible, due to permissions or data protection when the device is locked.
                 * The device is out of space.
                 * The store could not be migrated to the current model version.
                 Check the error message to determine what the actual problem was.
                 */
                fatalError("Unresolved error \(error), \(error.userInfo)")
            }
        })
        return container
    }()

    // MARK: - Core Data Saving support

    func saveContext () {
        let context = persistentContainer.viewContext
        if context.hasChanges {
            do {
                try context.save()
            } catch {
                // Replace this implementation with code to handle the error appropriately.
                // fatalError() causes the application to generate a crash log and terminate. You should not use this function in a shipping application, although it may be useful during development.
                let nserror = error as NSError
                fatalError("Unresolved error \(nserror), \(nserror.userInfo)")
            }
        }
    }

}


extension AppDelegate:ChatBotDelegate, ConversationDelegate{
    func onChotBotClosed() {
       // print("onChotBotClosed")
    }
    
    func onUnreadCountChanged(_ count: Int32) {
       // print("Unread Count=" + String(format: "%d", count))
    }
    
    
}
