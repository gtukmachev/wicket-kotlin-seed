package tga.wks

import org.apache.wicket.Application
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication
import org.apache.wicket.authroles.authentication.pages.SignInPage
import tga.wks.auth.UserWebSession
import tga.wks.jetty.JettyRunner
import tga.wks.pages.home.HomePage
import tga.wks.pages.landing.LandingPage

class WicketApplication : AuthenticatedWebApplication() {

    public override fun init() {
        super.init()
        cspSettings.blocking().disabled()

        mountPage("/landing", LandingPage::class.java)
        mountPage("/home", HomePage::class.java)
    }

    override fun getHomePage() = LandingPage::class.java
    override fun getWebSessionClass() = UserWebSession::class.java
    override fun getSignInPageClass() = SignInPage::class.java

    companion object {
        fun get() =  Application.get() as WicketApplication

        @JvmStatic fun main(args: Array<String>) {
            JettyRunner.run()
        }
    }

}
