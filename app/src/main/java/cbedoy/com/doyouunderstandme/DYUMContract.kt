package cbedoy.com.doyouunderstandme

import retrofit2.Call
import retrofit2.http.GET

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
        @GET("concepts")
        fun getConcepts(text: String): Call<HashMap<String, Any>>

    }

    interface IDYUMProvider {
        fun extractSentiment(phase: String, callback: IDYUMProviderCallback)

        interface IDYUMProviderCallback{
            fun onSentiment(sentiment: Any)
        }
    }

}