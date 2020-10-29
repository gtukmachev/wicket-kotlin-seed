package tga.wks.jetty

import org.eclipse.jetty.server.HttpConfiguration
import org.eclipse.jetty.server.HttpConnectionFactory
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.server.ServerConnector
import org.eclipse.jetty.webapp.WebAppContext
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.system.exitProcess

object JettyRunner {

    private val log: Logger = LoggerFactory.getLogger(JettyRunner::class.java)

    fun run() {
        log.info("Starting Jetty Web Server...")

        if (System.getProperty("wicket.configuration") == null ) {
            System.setProperty("wicket.configuration", "development")
        }

        val server = Server()

        val httpConfig = HttpConfiguration()
        httpConfig.setOutputBufferSize(32768)

        val http = ServerConnector(server, HttpConnectionFactory(httpConfig)).apply {
            port = 8080
            idleTimeout = 1000 * 60 * 60
        }

        server.addConnector(http)

        val bb = WebAppContext().apply{
            setServer(server)
            contextPath = "/"
            war = "src/main/webapp"
        }

        server.handler = bb

        try {
            server.start()
            log.info("Jetty Web Server started successfully!")
            log.info("The Wicket Application is started on: http://localhost:8080")
            server.join()
        } catch (e: Exception) {
            log.error("Some error happened during the Jetty starting:", e)
            exitProcess(-100)
        }

    }
}


