import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import us.anadyr.tangleddesks.loginInfo
import us.anadyr.tangleddesks.userUpdate

interface RestApi {

    @Headers("Content-Type: application/json")
    @POST()
    fun getKey(@Body userData: loginInfo): Call<loginInfo>
    fun getUpdate(@Body userData: userUpdate): Call<userUpdate>
}