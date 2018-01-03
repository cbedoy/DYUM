package cbedoy.com.doyouunderstandme

import com.aylien.textapi.responses.Sentiment

/**
 * Doyouunderstandme
 *
 * Created by bedoy on 1/2/18.
 */
interface DYUMContract {
    interface IDYUMPresenter{
        fun readPhase(phase: String)
    }

    interface IDYUMViewController{

    }

    interface IDYUMInteractor{
        fun aylienPhase(phase: String)
    }

    interface IDYUMProvider {
        fun extractSentiment(phase: String, callback: IDYUMProviderCallback)

        interface IDYUMProviderCallback{
            fun onSentiment(sentiment: Sentiment)
        }
    }

}