package tga.wks.navigation

import org.apache.wicket.RestartResponseException
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.panel.Panel
import tga.wks.WicketApplication
import tga.wks.auth.UserWebSession
import tga.wks.components.links.ClickLink
import tga.wks.navigation.nav_item.PageNavItem
import tga.wks.pages.home.HomePage
import tga.wks.pages.page_one.PageOne
import tga.wks.pages.page_two.PageTwo

class NavBar(id: String?) : Panel(id) {

    init {
        renderBodyOnly = true

        add(PageNavItem("pageHomeNavItem", HomePage::class){ "Home page" })
        add(PageNavItem("pageOneNavItem",   PageOne::class){ "Page One"  })
        add(PageNavItem("pageTwoNavItem",   PageTwo::class){ "Page Two"  })

        add (
            WebMarkupContainer("userNavItem").apply
            {
                add(
                    ClickLink("signOutNavBtn", ::logOut).apply
                    {
                        add( Label("userName"){ UserWebSession.get().userName!! })
                        add( Label("roles"){ UserWebSession.get().userRoles?.toString()} )
                    }
                )
            }
        )
    }

    private fun logOut() {
        // Close the current session and remove all the state assigned to the current session
        UserWebSession.get().invalidateNow()

        // Redirect user to the very first page:
        throw RestartResponseException( WicketApplication.get().homePage )
    }

    override fun onConfigure() {
        get("userNavItem").isVisible = UserWebSession.get().isSignedIn
        super.onConfigure()
    }

}
