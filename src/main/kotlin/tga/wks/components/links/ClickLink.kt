package tga.wks.components.links

import org.apache.wicket.markup.html.link.Link
import org.apache.wicket.model.IModel

class ClickLink(id: String, model: IModel<Any>?, val onClickHandler: () -> Unit) : Link<Any>(id, model) {

    constructor(id: String, onClickHandler: () -> Unit) : this(id, null, onClickHandler)

    override fun onClick() = this.onClickHandler()

}
