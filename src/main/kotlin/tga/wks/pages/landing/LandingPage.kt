package tga.wks.pages.landing

import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.request.mapper.parameter.PageParameters
import tga.wks.components.links.ClickLink
import tga.wks.components.links.PageLink
import tga.wks.pages.base.BasePage
import tga.wks.pages.home.HomePage

class LandingPage(parameters: PageParameters) : BasePage(parameters) {
	companion object {
		@JvmStatic private val serialVersionUID: Long = 1L
	}

	var counter: Int = 1

	init {
		add( PageLink("homePageBtn", HomePage::class) )
		add( Label("version", application.frameworkSettings.version))

		add(
			ClickLink("counterBtn"){ counter++ }.apply {
				add(Label("counterValue"){ counter })
			}
		)
	}

}
