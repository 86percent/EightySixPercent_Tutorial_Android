package co.eightysixpercent.test86.android

import android.app.Application
import co.eightysixpercent.bot.manager.EPManager
import co.eightysixpercent.bot.model.EPBotFetchingStrategy

class Test86 : Application() {

    override fun onCreate() {
        super.onCreate()
        initEightySixPercent()
    }

    private fun initEightySixPercent() {
        EPManager.init(this)
        EPManager.registerBot(Constants.BotUuid.simpleDemo, EPBotFetchingStrategy.OnlineWithDefault(1,"simpleDemo.json"))
    }

}