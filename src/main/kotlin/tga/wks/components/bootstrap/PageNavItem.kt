package tga.wks.components.bootstrap

import org.apache.wicket.AttributeModifier
import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.panel.Panel
import org.apache.wicket.model.IModel
import tga.wks.components.links.PageLink
import kotlin.reflect.KClass

class PageNavItem<T : WebPage>(id: String, private val targetPageClass: KClass<T>, private val pageNameModel: IModel<String>) : Panel(id, pageNameModel) {

    init {
        add(
            AttributeModifier("class"){
                if (webPage::class == targetPageClass) "active" else ""
            }
        )
        renderBodyOnly = true

        add(
            PageLink("pageNavLink", targetPageClass).apply {
                add( Label("navPageName", pageNameModel) )
            }
        )
    }

}
