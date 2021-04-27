//
//  ViewController.swift
//  
//
//  Created by Ying Yu on 6/23/20.
//  Copyright © 2020 Vernal Yu. All rights reserved.
//

import UIKit
import Clare

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        Clare.sharedManager()?.show()
    }
    
    @IBAction func onShowChatWithoutWidget(_ sender: Any) {
        Clare.sharedManager()?.showWithoudWidget()
    }

}

