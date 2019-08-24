
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir	= "target/test-reports"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits( "global" ) {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {        
        mavenLocal()
        mavenCentral()
    }
    dependencies {
        // https://mvnrepository.com/artifact/org.liquibase/liquibase-core
        runtime 'org.liquibase:liquibase-core:1.9.5'
    }
}
