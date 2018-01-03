package cbedoy.com.doyouunderstandme

import cbedoy.com.doyouunderstandme.DYUMContract.IDYUMInteractor
import cbedoy.com.doyouunderstandme.DYUMContract.IDYUMViewController

/**
 * Doyouunderstandme
 *
 * Created by bedoy on 1/2/18.
 */
class DYUMPresenter : DYUMContract.IDYUMPresenter {
    var interactor : IDYUMInteractor? = null
    var viewcontroller : IDYUMViewController? = null

    override fun readPhase(phase: String) {
        interactor?.aylienPhase(phase)
    }

    override fun receivedResponse(body: HashMap<String, Any>?) {
        viewcontroller?.onReceivedInformation(body)
    }

}