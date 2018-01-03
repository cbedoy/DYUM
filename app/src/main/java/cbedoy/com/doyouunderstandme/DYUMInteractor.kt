package cbedoy.com.doyouunderstandme

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Doyouunderstandme
 *
 * Created by bedoy on 1/2/18.
 */
class DYUMInteractor : DYUMContract.IDYUMInteractor{

    var presenter : DYUMContract.IDYUMPresenter? = null
    var provider : DYUMContract.IDYUMProvider? = null
    var service : DYUMContract.IDYUMService? = null

    override fun aylienPhase(phase: String) {

        val mode = provider?.getTweetMode()
        val call = service?.getSentiment(phase, mode)
        call?.enqueue(object : Callback<HashMap<String, Any>> {
            override fun onFailure(call: Call<HashMap<String, Any>>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<HashMap<String, Any>>?, response: Response<HashMap<String, Any>>?) {
                prepareResponse(response)
            }
        })
    }

    private fun prepareResponse(response: Response<HashMap<String, Any>>?) {
        if (response!!.isSuccessful){
            val body = response.body()

            presenter?.receivedResponse(body)
        }
    }
}