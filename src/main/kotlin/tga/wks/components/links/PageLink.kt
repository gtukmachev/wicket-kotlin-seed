package tga.wks.components.links

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.link.BookmarkablePageLink
import kotlin.reflect.KClass

class PageLink<C : WebPage>(id: String, pageClass: KClass<C>) : BookmarkablePageLink<C>(id, pageClass.java)
