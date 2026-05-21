package np.sairwv.glitchballs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import np.sairwv.glitchballs.BuildConfig

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val url = if (BuildConfig.FORCE_DEBUG_WEB_FLOW) {
            BuildConfig.DEBUG_WEB_URL
        } else {
            BuildConfig.CONFIG_ENDPOINT
        }

        startActivity(
            Intent(this, WebViewActivity::class.java).putExtra(WebViewActivity.EXTRA_URL, url),
        )
        finish()
    }
}
