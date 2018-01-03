package cbedoy.com.doyouunderstandme

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import cbedoy.com.doyouunderstandme.DYUMContract.IDYUMViewController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IDYUMViewController{

    var presenter : DYUMContract.IDYUMPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MainInjector.inject(this)

        phase_submit_view.setOnClickListener({
            val text = phase_input_view.text.toString()
            presenter?.readPhase(text)
            phase_input_view.text = null
        })
    }
}
