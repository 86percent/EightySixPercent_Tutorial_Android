package co.eightysixpercent.test86.android

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import co.eightysixpercent.bot.fragment.EPChatConversationFragment
import co.eightysixpercent.bot.interfaces.EPBotCustomInterface
import co.eightysixpercent.bot.manager.EPManager
import co.eightysixpercent.bot.model.EPActivityResult
import co.eightysixpercent.bot.model.EPBotAppearance
import co.eightysixpercent.bot.model.EPContextObject
import co.eightysixpercent.bot.model.realm.EPChatConversation
import co.eightysixpercent.bot.model.realm.EPChatMessage
import co.eightysixpercent.bot.model.ui.EPMessageContent
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class ChatbotActivity : AppCompatActivity(), EPBotCustomInterface {

    companion object {
        const val ARGS_BOT_UUID = "args.bot.uuid"
        const val ARGS_BOT_NAME = "args.bot.name"

        const val TAG_CHAT_CONVERSATION_FRAGMENT = "tag.chat.conversation.fragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatbot)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = intent.getStringExtra(ARGS_BOT_NAME)

        val conversation = EPChatConversation(intent.getStringExtra(ARGS_BOT_UUID), UUID.randomUUID().toString())
        EPManager.fragment(this, conversation) { chatConversationFragment, exception ->
            if (chatConversationFragment != null) {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, chatConversationFragment, TAG_CHAT_CONVERSATION_FRAGMENT)
                transaction.commit()
            } else {
                exception?.printStackTrace()
            }
        }
    }

    override fun epBotDidFinish(fragment: EPChatConversationFragment,
                                botUUID: String, botContext: Map<String, EPContextObject>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun epContextDidChange(
        fragment: EPChatConversationFragment,
        botUUID: String,
        botContext: Map<String, EPContextObject>
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun epGetCustomBotAppearance(fragment: EPChatConversationFragment, botUUID: String): EPBotAppearance {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun epGetCustomItemFromIdentifier(
        context: Context,
        botUUID: String,
        customItemId: String,
        userInfo: Map<String, Any>
    ): EPMessageContent.Custom? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun epMessageDidUpdate(
        fragment: EPChatConversationFragment,
        botUUID: String,
        lastMessage: EPChatMessage?,
        chatConversation: EPChatConversation
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun epOnActivityResult(
        fragment: EPChatConversationFragment,
        botUUID: String,
        requestCode: Int,
        resultCode: Int,
        data: Intent?,
        completion: (EPActivityResult?) -> Unit
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun epStartCustomActivityFromIdentifier(
        fragment: EPChatConversationFragment,
        botUUID: String,
        customInputTypeId: String,
        skippable: Boolean
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun epUserDidInput(
        fragment: EPChatConversationFragment,
        botUUID: String,
        content: EPMessageContent,
        botContext: Map<String, EPContextObject>
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}