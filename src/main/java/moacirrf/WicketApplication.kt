package moacirrf

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.protocol.http.WebApplication

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 *
 * @see moacirrf.Start#main(String[])
 */
class WicketApplication : WebApplication() {

    override fun getHomePage(): Class<out WebPage>? = HomePage::class.java

}