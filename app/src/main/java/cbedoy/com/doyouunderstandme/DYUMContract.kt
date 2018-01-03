package cbedoy.com.doyouunderstandme

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Doyouunderstandme
 *
 * Created by bedoy on 1/2/18.
 */
interface DYUMContract {
    interface IDYUMPresenter{
        fun readPhase(phase: String)
        fun receivedResponse(body: HashMap<String, Any>?)
    }

    interface IDYUMViewController{
        fun onReceivedInformation(information: HashMap<String, Any>?)
    }

    interface IDYUMInteractor{
        fun aylienPhase(phase: String)
    }

    interface IDYUMService{
        @GET("classify/")
        fun getClassify(@Query("text") text: String): Call<HashMap<String, Any>>

        @GET("sentiment/")
        fun getSentiment(@Query("text") text: String?, @Query("mode") mode: String?): Call<HashMap<String, Any>>
    }

    interface IDYUMProvider {
        fun getTweetMode(): String
        fun getDocumentMode(): String
    }

}