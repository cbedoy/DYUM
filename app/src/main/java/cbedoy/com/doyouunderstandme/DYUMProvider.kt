package cbedoy.com.doyouunderstandme


/**
 * Doyouunderstandme
 *
 * Created by bedoy on 1/2/18.
 */
class DYUMProvider : DYUMContract.IDYUMProvider
{
    var elements : ArrayList<String>? = null

    init {
        elements = ArrayList(2)
        elements?.add("tweet")
        elements?.add("document")
    }


    override fun getDocumentMode(): String {
        return elements!![1]
    }

    override fun getTweetMode(): String {
        return elements!![0]
    }

}