//
//  UpdateStatus.swift
//  TangledDesks
//
//  Created by Anadyr on 10/26/20.
//

import SwiftUI
func update(){
    //TODO finish
}


struct UpdateStatus: View {
    @State var user = TangledStatus(userid: 0, status: 0, message: "")
    var body: some View {
        VStack{
            TextField("Message", text: $user.message)
                .padding()
                .background(lightGreyColor)
                .padding(.leading, 10)
                .padding(.trailing, 10)
                .cornerRadius(10)
            Picker(selection: $user.status, label: Text("Status")){
                Text("Available").tag(user.status)
                Text("Busy").tag(user.status)
                Text("Away").tag(user.status)
            }
            
            Button(action: update) {
                Text("Submit")
                    .foregroundColor(Color.blue)
                
            }.frame(minWidth:0, maxWidth: 55)
            .cornerRadius(5)
                .clipped()
                .frame(minWidth: 0, maxWidth: 100)
                .labelsHidden()
                
                
            
        }
    }
}

struct UpdateStatus_Previews: PreviewProvider {
    static var previews: some View {
        UpdateStatus()
    }
}
