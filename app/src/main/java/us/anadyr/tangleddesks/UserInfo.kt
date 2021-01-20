package us.anadyr.tangleddesks

import com.google.gson.annotations.SerializedName

data class loginInfo (
    @SerializedName("userid") val userId: Int?,
    @SerializedName("username") val userName: String?,
    @SerializedName("password") val password: String?,
    @SerializedName("token") val token: String?
)

data class userUpdate (
    @SerializedName("userid") val userId: Int?,
    @SerializedName("username") val userName: String?,
    @SerializedName("usertoken") val userToken: String?,
    @SerializedName("key") val key: String?
)
