package tga.wks.pages.landing

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.request.mapper.parameter.PageParameters
import tga.wks.WicketApplication
import tga.wks.auth.UserWebSession
import tga.wks.components.links.PageLink
import tga.wks.pages.home.HomePage

class LandingPage(parameters: PageParameters) : WebPage(parameters) {

	companion object {
		@JvmStatic private val serialVersionUID: Long = 1L
	}

	init {
		add( Label("version", application.frameworkSettings.version))
		add( PageLink("gotoHomePage", HomePage::class))
	}

	override fun onConfigure() {
		super.onConfigure()

		if (!UserWebSession.get().isSignedIn) {
			//if user is not signed in, redirect him to sign in page
			WicketApplication.get().restartResponseAtSignInPage()
		}
	}

}
