import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import us.anadyr.tangleddesks.loginInfo
import us.anadyr.tangleddesks.userUpdate

class RestApiService {
    fun getKey(userData: loginInfo, onResult: (loginInfo?) -> Unit){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.getKey(userData).enqueue(
            object : Callback<loginInfo> {
                override fun onFailure(call: Call<loginInfo>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<loginInfo>, response: Response<loginInfo>) {
                    val gotToken = response.body()
                    onResult(gotToken)
                }
            }
        )
    }

    fun getUpdate(userData: userUpdate, onResult: (userUpdate?) -> Unit) {
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
    retrofit.getUpdate(userData).enqueue(
        object :    Callback<userUpdate> {
            override fun onFailure(call: Call<userUpdate>, t: Throwable) {
                onResult(null)
            }

            override fun onResponse(call: Call<userUpdate>, response: Response<userUpdate>) {
                val gotUpdate = response.body()
                onResult(gotUpdate)
            }
        }
    )
    }
}