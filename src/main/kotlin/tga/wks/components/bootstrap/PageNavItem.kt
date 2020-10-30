package tga.wks.components.bootstrap

import org.apache.wicket.AttributeModifier
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.markup.html.WebPage
import kotlin.reflect.KClass

class PageNavItem<T : WebPage>(id: String, private val targetPage: KClass<T>) : WebMarkupContainer(id) {

    init {
        add(
            AttributeModifier("class"){
                if (webPage::class == targetPage) "active" else ""
            }
        )
    }

}
