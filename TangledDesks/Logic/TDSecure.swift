//
//  TDSecure.swift
//  TangledDesks
//
//  Created by Anadyr on 10/26/20.
//

import Foundation

class Security {
    
    struct Credentials {
        var username: String
        var password: String
    }
    
    struct Auth {
        var userid: Int
        var auth: String
    }
    
    enum KeychainError: Error {
        case noPassword
        case unexpectedPasswordData
        case unhandledError(status: OSStatus)
    }
    
    
    func login(username: String, password: String){
        
        
    }
}
