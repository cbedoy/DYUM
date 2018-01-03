package cbedoy.com.doyouunderstandme

import android.app.Activity
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

/**
 * Doyouunderstandme
 *
 * Created by bedoy on 1/2/18.
 */
class MainInjector{
    companion object {
        fun inject(activity: MainActivity){
            var presenter = DYUMPresenter()
            var interactor = DYUMInteractor()
            var provider = DYUMProvider()

            presenter.interactor = interactor
            presenter.viewcontroller = activity
            interactor.presenter = presenter
            interactor.provider = provider
            activity.presenter = presenter
        }
    }



}