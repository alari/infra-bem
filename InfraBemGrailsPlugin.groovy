class InfraBemGrailsPlugin {
    def version = "0.1-SNAPSHOT"
    def grailsVersion = "2.2 > *"
    def pluginExcludes = [
            "grails-app/views/error.gsp",
            "grails-app/views/index.gsp",
            "grails-app/views/bem/_root.gsp",
            "grails-app/conf/TestResources.groovy",
            "web-app/bem"
    ]

    def title = "Infra Bem Plugin"
    def author = "Dmitry Kurinskiy"
    def authorEmail = ""
    def description = '''\
BEM tools for grails: advanced markup development methodology, originated in Yandex, ported to Grails
'''

    def documentation = "https://github.com/alari/infra-bem"

    def license = "APACHE"

    // Details of company behind the plugin (if there is one)
//    def organization = [ name: "My Company", url: "http://www.my-company.com/" ]

    // Any additional developers beyond the author specified above.
//    def developers = [ [ name: "Joe Bloggs", email: "joe@bloggs.net" ]]

    // Location of the plugin's issue tracker.
    def issueManagement = [ system: "github", url: "https://github.com/alari/infra-bem/issues" ]

    // Online location of the plugin's browseable source code.
    def scm = [ url: "https://github.com/alari/infra-bem" ]

    def doWithWebDescriptor = { xml ->
        // TODO Implement additions to web.xml (optional), this event occurs before
    }

    def doWithSpring = {
        // TODO Implement runtime spring config (optional)
    }

    def doWithDynamicMethods = { ctx ->
        // TODO Implement registering dynamic methods to classes (optional)
    }

    def doWithApplicationContext = { applicationContext ->
        // TODO Implement post initialization spring config (optional)
    }

    def onChange = { event ->
        // TODO Implement code that is executed when any artefact that this plugin is
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
    }

    def onConfigChange = { event ->
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }

    def onShutdown = { event ->
        // TODO Implement code that is executed when the application shuts down (optional)
    }
}
