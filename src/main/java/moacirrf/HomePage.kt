package moacirrf

import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.ajax.markup.html.form.AjaxButton
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.WebPage

class HomePage(parameters: PageParameters?) : WebPage(parameters) {
    companion object {
        private val serialVersionUID = 1L
    }

    private var mForm: Form<Void>? = null
    private var kotlinBtn: AjaxButton? = null
    private var wicketVersion: Label? = null
    private var kotlinVersion: Label? = null


    init {
        mForm = Form("mForm")
        add(mForm)
        wicketVersion = Label("wicketVersion", getApplication().getFrameworkSettings().getVersion())
        add(wicketVersion)

        kotlinVersion = Label("kotlinVersion", "Kotlin version is: 1.5.21")
        kotlinVersion!!.setOutputMarkupId(true)
        kotlinVersion!!.setVisible(false)
        mForm!!.add(kotlinVersion)

        kotlinBtn = object : AjaxButton("kotlinBtn", Model.of("Show Kotlin Version."), mForm) {
            override fun onSubmit(target: AjaxRequestTarget) {
                kotlinVersion!!.setVisible(!kotlinVersion!!.isVisible())
                target.add(mForm)
            }
        }
        mForm!!.add(kotlinBtn)
    }
}