package tga.wks.navigation.nav_item

import org.apache.wicket.AttributeModifier
import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.panel.Panel
import org.apache.wicket.model.IModel
import tga.wks.components.links.PageLink
import kotlin.reflect.KClass

class PageNavItem<T : WebPage>(id: String, targetPageClass: KClass<T>, private val pageNameModel: IModel<String>) : Panel(id, pageNameModel) {

    private val targetPageClassJava = targetPageClass.java

    init {

        add(
            PageLink("pageNavLink", targetPageClass).apply {
                add(
                    AttributeModifier("class"){
                        if (webPage::class.java == targetPageClassJava) "nav-link active" else "nav-link"
                    }
                )

                add( Label("navPageName", pageNameModel) )
            }
        )
    }

}
