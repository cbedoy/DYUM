package cbedoy.com.doyouunderstandme

import android.os.AsyncTask
import com.aylien.textapi.TextAPIClient
import com.aylien.textapi.parameters.SentimentParams
import com.aylien.textapi.responses.Sentiment


/**
 * Doyouunderstandme
 *
 * Created by bedoy on 1/2/18.
 */
class DYUMProvider : DYUMContract.IDYUMProvider
{
    override fun extractSentiment(phase: String, callback: DYUMContract.IDYUMProvider.IDYUMProviderCallback) {
        val task = ExtractTask()
        task.callback = callback
        task.execute(phase)
    }

    class ExtractTask : AsyncTask<String, Void, Sentiment>() {

        var callback : DYUMContract.IDYUMProvider.IDYUMProviderCallback? = null

        override fun doInBackground(vararg p0: String?): Sentiment {

            val phase = p0[0]

            val client = TextAPIClient(BuildConfig.APP_ID, BuildConfig.APP_KEY)
            val builder = SentimentParams.newBuilder()
            builder.setText(phase)
            return client.sentiment(builder.build())
        }

        override fun onPostExecute(result: Sentiment?) {
            super.onPostExecute(result)

            callback?.onSentiment(result!!)
        }

    }
}