//
//  TangledData.swift
//  TangledDesks
//
//  Created by Anadyr on 10/26/20.
//

import Foundation


struct TangledData: Hashable, Codable {
    public var message: String
    public var userid: Int
    public var userStatus: Int
    public var firstName: String
    public var lastName: String
}

struct TangledAuth {
    public var userid: Int
    public var key: String
}

struct TangledStatus: Hashable {
    public var userid: Int
    public var status: Int
    public var message: String
}
