import java.text.*

import grails.converters.*


includeTargets << grailsScript("_GrailsInit")
includeTargets << grailsScript("_GrailsBootstrap")
includeTargets << grailsScript("_GrailsClasspath")

target(export: "Export Product List") {
	depends( configureProxy, packageApp, classpath, loadApp, configureApp)
	loadApp()
	configureApp()

	def productClass = grailsApp.getClassForName("products.Product")
	productClass.withSession { session ->
		productClass.withTransaction { status ->
			def lst=productClass.list();
			def outf = new File("/tmp/export.xml")
			outf.withWriter { out ->
				out.println (lst as XML)
			}

			println "\nfinished"
			session.clear();
		}
	}
}



setDefaultTarget(export)
