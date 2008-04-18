includeTargets << new File("${liquibasePluginDir}/scripts/LiquibaseSetup.groovy")

task('default': '''Writes SQL to mark all changes as executed in the database to STDOUT''') {
    depends(setup)

    try {
        def outStream = (args) ? new PrintStream(args) : System.out
        liquibase.changeLogSync(null, new PrintWriter(outStream))
    }
    catch (Exception e) {
        e.printStackTrace()
        event("StatusFinal", ["Failed to update database ${grailsEnv}"])
        exit(1)
    } finally {
        liquibase.getDatabase().getConnection().close();
    }
}
