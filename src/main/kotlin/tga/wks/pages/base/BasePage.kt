package tga.wks.pages.base

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.request.mapper.parameter.PageParameters
import tga.wks.navigation.NavBar

open class BasePage(parameters: PageParameters) : WebPage(parameters) {

    companion object {
        @JvmStatic private val serialVersionUID: Long = 1L
    }

     init {
         add( NavBar("navigationBar") )
    }

}
