//
//  Login.swift
//  TangledDesks
//
//  Created by Anadyr on 10/26/20.
//

import SwiftUI
//rgb(2, 122, 255)
let lightGreyColor = Color(red: 239.0/255.0, green: 243.0/255.0, blue: 244.0/255.0, opacity: 1.0)


struct Login: View {
    @State public var username: String = ""
    @State public var password: String = ""
    var body: some View {
        VStack {
            WelcomeText()
            TextField("Username", text: $username)
                .padding()
                .background(lightGreyColor)
                .cornerRadius(10.0)
                .padding(.leading, 15)
                .padding(.trailing, 15)
                .textContentType(.username)

            SecureField("Password", text: $password)
                .padding()
                .background(lightGreyColor)
                .cornerRadius(10.0)
                .padding(.leading, 15)
                .padding(.trailing, 15)
                .textContentType(.password)
            Button(action: submit) {
                HStack(alignment: .center) {
                    Spacer()
                    Text("Login").foregroundColor(Color.white).bold()
                    Spacer()
                }
                                
            }.padding().background(Color.blue).cornerRadius(4.0)
                
        .padding()
        }
    }
    func submit() {
        
        let login = HttpEngine()
        login.login(username: username, password: password)

    }
}


    
    
    struct WelcomeText: View {
        var body: some View {
            Text("Login")
                .font(.largeTitle)
                .fontWeight(.semibold)
                .padding(.bottom, 20)
        }
    }

struct Login_Previews: PreviewProvider {
    static var previews: some View {
        Login()
    }
}
