grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.work.dir = "target/work"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.fork = [
    // configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
    //  compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],

    // configure settings for the test-app JVM, uses the daemon by default
    test: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon:true],
    // configure settings for the run-app JVM
    run: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the run-war JVM
    war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the Console UI JVM
    console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // specify dependency exclusions here; for example, uncomment this to disable ehcache:
        // excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

    repositories {
        inherits true // Whether to inherit repository definitions from plugins

		//mavenRepo "http://repository.springsource.com/maven/bundles/release"
		//mavenRepo "http://repository.springsource.com/maven/bundles/external"
		mavenRepo "http://repo.grails.org/grails/core"
		mavenRepo "https://oss.sonatype.org/content/repositories/releases/"
		mavenRepo "http://repo.spring.io/milestone"
		mavenRepo "http://repository.codehaus.org"
		mavenRepo "http://grails.org/plugins"
        grailsPlugins()
        grailsHome()
        mavenLocal()
        grailsCentral()
        mavenCentral()
        // uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }	
	
//	repositories {
//		grailsPlugins()
//		grailsHome()
//		grailsCentral()
// 
//		// uncomment the below to enable remote dependency resolution
//		// from public Maven repositories
//		//mavenLocal()
//		mavenCentral()
//		//mavenRepo "http://snapshots.repository.codehaus.org"
//		mavenRepo "http://repository.codehaus.org"
//		//mavenRepo "http://download.java.net/maven/2/"
//		//mavenRepo "http://repository.jboss.com/maven2/"
//	}

    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes e.g.
        // runtime 'mysql:mysql-connector-java:5.1.29'
		//runtime 'org.grails:grails-plugin-databinding:3.0.1'
        runtime 'org.postgresql:postgresql:9.3-1101-jdbc41'
        test "org.grails:grails-datastore-test-support:1.0.2-grails-2.4"
		test "org.gebish:geb-spock:0.10.0"
    }

    plugins {
        // plugins for the build system only
        build ":tomcat:7.0.55"

        // plugins for the compile step
        compile ":scaffolding:2.1.2"
        compile ':cache:1.1.8'
        compile ":asset-pipeline:1.9.9"
		//compile ":asset-pipeline:2.1.5" // Update to the latest asset pipeline. Caused issues (i.e. AbstractAssetResolver) so back to previous version!
		compile ':spring-security-core:2.0-RC4' // For login & logout
		//compile ":searchable:0.6.9" // Google like search for people to follow.
		compile ":rest-client-builder:2.1.1"
		compile ":geb:0.10.0"
		//compile ":rest:0.8"
		compile ":rest-client-builder:2.0.0"
		test ":geb:0.10.0"
		test ":code-coverage:2.0.3-3"
		//test ":rest:0.8"

        // plugins needed at runtime but not for compilation
        runtime ":hibernate4:4.3.6.1" // or ":hibernate:3.6.10.18"
		//runtime ":hibernate:3.6.10.18"
		//runtime ":rest:0.8"
        runtime ":database-migration:1.4.0"
        runtime ":jquery:1.11.1"
		runtime ':twitter-bootstrap:3.3.4' // TODO To make my pages look better.
		//runtime 'org.grails:grails-plugin-log4j:2.2.0' // Used for logging - Dependency is not resolving & not needed anyway.
		//runtime ":elasticsearch:0.0.4.4" // Google like search for people to follow.
		//compile ":build-test-data:2.4.0" // Enables the easy creation of test data by automatic inspection of constraints.
		// build-test-data is similar to @Mock but with this I can mix a richer set of tests together since I am in a headless app during integration.
		// However I had an issue with the plugin codebase "unable to resolve class nl.flotsam.xeger.Xeger" and the recommended solutions online didn't work.

        // Uncomment these to enable additional asset-pipeline capabilities
        //compile ":sass-asset-pipeline:1.9.0"
        //compile ":less-asset-pipeline:1.10.0"
        //compile ":coffee-asset-pipeline:1.8.0"
        //compile ":handlebars-asset-pipeline:1.3.0.3"
		
		// Trying to solve the error on Pivotal Cloud Foundry:
		// Thu Apr 09 2015 23:19:19 GMT+0100 (GMT Daylight Time) [App/0] OUT errors.GrailsExceptionResolver ConnectException occurred when processing request: [POST] /status/updateStatu
		// For the reason I added the items below see how it's a known issue & reolved in Garils 3.0.1 http://grails.1312388.n4.nabble.com/Consume-web-service-in-Grails-app-td1585031.html
//		DEPENDENCY WOULDN'T RESOLVE.
//		runtime('org.codehaus.groovy.modules:groovyws:0.5.2')
//		{
//			excludes 'geronimo-servlet_2.5_spec', 'servlet-api', 'jaxb-xjc', 
//			'jaxb-impl', 'xml-apis', 'saaj-impl', 'junit',           'slf4j-jdk14', 
//			'xmlParserAPIs', 'jaxb-api', 'saaj-api', 'xmlbeans', 'jaxen', 
//			'geronimo-stax-api_1.0_spec',                    'geronimo-activation_1.0.2_spec', 
//			'abdera-client', 'geronimo-activation_1.1_spec' 
//		}
//		if (basedir=="/home/finn/src/troll/troll-web") { //not sure why Ubuntu don't have these provided in the JVM
//			compile 'com.sun.xml.bind:jaxb-xjc:2.1.12', 'com.sun.xml.bind:jaxb-impl:2.1.12'
//		}
	}
}
