package tga.wks.pages.base

import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.link.Link
import org.apache.wicket.request.mapper.parameter.PageParameters
import tga.wks.auth.UserWebSession
import tga.wks.components.links.PageLink
import tga.wks.pages.home.HomePage

open class BasePage(parameters: PageParameters) : WebPage(parameters) {

    companion object {
        @JvmStatic private val serialVersionUID: Long = 1L
    }

    val session: UserWebSession get() = UserWebSession.get()
    var userNavItem: WebMarkupContainer

     init {
        add( PageLink("homePageLink", HomePage::class) )

        userNavItem = WebMarkupContainer("userNavItem")
        add(userNavItem)

        val signOutNavBtn = object : Link<Any>("signOutNavBtn"){
            override fun onClick(){
                if (UserWebSession.get().isSignedIn) {
                    UserWebSession.get().invalidateNow()
                }
            }
        }

        userNavItem.add(signOutNavBtn)

        signOutNavBtn.add( Label("userName"){ session.userName!! })
        signOutNavBtn.add( Label("roles"){ session.userRoles?.toString()} )
    }

    override fun onConfigure() {
        super.onConfigure()
        userNavItem.setVisible(session.isSignedIn)
    }
}
