package tga.wks.pages.base

import org.apache.wicket.request.mapper.parameter.PageParameters
import tga.wks.WicketApplication
import tga.wks.auth.UserWebSession

open class BaseAuthPage(parameters: PageParameters) : BasePage(parameters) {

    companion object {
        @JvmStatic private val serialVersionUID: Long = 1L
    }

    override fun onConfigure() {
        super.onConfigure()

        if (!UserWebSession.get().isSignedIn) {
            //if user is not signed in, redirect him to sign in page
            WicketApplication.get().restartResponseAtSignInPage()
        }
    }

}
