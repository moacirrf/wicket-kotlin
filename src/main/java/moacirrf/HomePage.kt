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
    private var version: Label? = null

    init {
        mForm = Form("mForm")
        add(mForm)
        version = Label("version", getApplication().getFrameworkSettings().getVersion())
        version!!.outputMarkupId = true
        add(version)

        kotlinBtn = object : AjaxButton("kotlinBtn", Model.of("Show Kotlin Version."), mForm) {
            override fun onSubmit(target: AjaxRequestTarget) {
                version!!.setDefaultModelObject("Kotlin version is: 1.1.3-2")
                target.add(version)
            }
        }
        mForm!!.add(kotlinBtn)
    }
}