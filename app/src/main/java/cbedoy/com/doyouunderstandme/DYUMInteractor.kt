package cbedoy.com.doyouunderstandme

import com.aylien.textapi.responses.Sentiment

/**
 * Doyouunderstandme
 *
 * Created by bedoy on 1/2/18.
 */
class DYUMInteractor : DYUMContract.IDYUMInteractor{

    var presenter : DYUMContract.IDYUMPresenter? = null
    var provider : DYUMContract.IDYUMProvider? = null

    override fun aylienPhase(phase: String) {
        provider?.extractSentiment(phase, callback = object: DYUMContract.IDYUMProvider.IDYUMProviderCallback{
            override fun onSentiment(sentiment: Sentiment) {
                val polarity = sentiment.polarity
                val polarityConfidence = sentiment.polarityConfidence
                val subjectivity = sentiment.subjectivity
                val text = sentiment.text
            }
        })
    }
}