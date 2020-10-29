package tga.wks.auth

import org.apache.wicket.Session
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession
import org.apache.wicket.authroles.authorization.strategies.role.Roles
import org.apache.wicket.request.Request

class UserWebSession(request: Request) : AuthenticatedWebSession(request) {

    var userName: String? = null
        private set

    var userRoles: Roles? = null
        private set

    override fun authenticate(username: String?, password: String?): Boolean {
        this.userName = username
        this.userRoles = Roles("ADMIN,USER")
        return true
    }

    override fun getRoles(): Roles? = userRoles

    companion object {
        fun get() = Session.get() as UserWebSession
    }

}
