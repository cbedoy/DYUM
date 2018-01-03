package cbedoy.com.doyouunderstandme

import android.os.AsyncTask


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

    class ExtractTask : AsyncTask<String, Void, Void>() {
        override fun doInBackground(vararg p0: String?): Void {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        var callback : DYUMContract.IDYUMProvider.IDYUMProviderCallback? = null
    }
}