//
//  HttpEngine.swift
//  TangledDesks
//
//  Created by Anadyr on 10/26/20.
//

import Foundation

class HttpEngine {
    
    func login(username: String, password: String) {
        
        // Prepare URL
        let url = URL(string: "http://td.anadyr.us/auth.php")
        guard let requestUrl = url else { fatalError() }
        // Prepare URL Request Object
        var request = URLRequest(url: requestUrl)
        request.httpMethod = "POST"
         
        // HTTP Request Parameters which will be sent in HTTP Request Body
        let postString = "username=" + username + "&password=" + password + "&submit=login";
        // Set HTTP Request Body
        request.httpBody = postString.data(using: String.Encoding.utf8);
        // Perform HTTP Request
        let task = URLSession.shared.dataTask(with: request) { (data, response, error) in
                
                // Check for Error
                if let error = error {
                    print("Error took place \(error)")
                    return
                }
         
                // Convert HTTP Response Data to a String
                if let data = data, let authObj = String(data: data, encoding: .utf8) {
                    
                    
                    
                }
        }
        task.resume()
        


    }
    
    func auth (userid: Int, auth: String) {
        let url =  URL(string: "http://web-dev.tangleddesks.com/api.php")
        
        guard let requestUrl = url else { fatalError() }
        // Prepare URL Request Object
        var request = URLRequest(url: requestUrl)
        request.httpMethod = "POST"
    }
    
}
