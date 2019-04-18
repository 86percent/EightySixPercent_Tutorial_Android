package co.eightysixpercent.test86.android

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import co.eightysixpercent.bot.manager.EPManager
import co.eightysixpercent.bot.model.realm.EPChatConversation
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.title = "First 86% App"
    }

    override fun onResume() {
        super.onResume()
        startBotButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.startBotButton -> {
                val intent = Intent(this, ChatbotActivity::class.java)
                intent.putExtra(ChatbotActivity.ARGS_BOT_UUID, Constants.BotUuid.simpleDemo)
                intent.putExtra(ChatbotActivity.ARGS_BOT_NAME, "Simple Demo")
                startActivity(intent)
            }
        }
    }
}
