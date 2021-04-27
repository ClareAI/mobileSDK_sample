//
//  BorderedView.swift
//  
//
//  Created by Ying Yu on 3/2/21.
//  Copyright © 2021 Vernal Yu. All rights reserved.
//

import UIKit

@IBDesignable public class BorderedView: UIView {
    
    @IBInspectable public var borderRadius: Float {
        get {
            return Float(layer.cornerRadius)
        }
        set {
            layer.masksToBounds = newValue > 0
            layer.cornerRadius = CGFloat(newValue)
        }
    }
    
    @IBInspectable public var borderWidth: Float {
        get {
            return Float(layer.borderWidth)
        }
        set {
            layer.borderWidth = CGFloat(newValue)
        }
    }
    
    @IBInspectable public var borderColor: UIColor {
        get {
            return UIColor(cgColor: layer.borderColor ?? UIColor.clear.cgColor)
        }
        set {
            layer.borderColor = newValue.cgColor
        }
    }
}
