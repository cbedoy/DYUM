package cbedoy.com.doyouunderstandme

import android.app.ProgressDialog
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import cbedoy.com.doyouunderstandme.DYUMContract.IDYUMViewController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IDYUMViewController{

    var presenter : DYUMContract.IDYUMPresenter? = null
    var progressDialog : ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MainInjector.inject(this)

        progressDialog = ProgressDialog(this)
        progressDialog?.setTitle("analyzing")
        progressDialog?.setOnDismissListener {
            phase_input_view.text = null
        }

        phase_submit_view.setOnClickListener({
            val thread = HandlerThread("onClickListener")
            thread.start()
            val handler = Handler(thread.looper)

            progressDialog?.show()

            handler.post({
                val text = phase_input_view.text.toString()
                presenter?.readPhase(text)
            })
        })
    }

    override fun onReceivedInformation(information: HashMap<String, Any>?) {
        information!!.forEach {
            Log.d("MainActivity", it.key)

            Toast.makeText(applicationContext, "${it.key} -> ${it.value}", Toast.LENGTH_SHORT).show()
        }

        progressDialog?.dismiss()
    }
}
