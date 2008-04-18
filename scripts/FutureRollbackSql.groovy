includeTargets << new File("${liquibasePluginDir}/scripts/LiquibaseSetup.groovy")

task('default': "Writes SQL to roll back the database to the current state after the changes in the changeslog have been applied.") {
    depends(setup)

    try {
        def outStream = (args) ? new PrintStream(args) : System.out
        liquibase.futureRollbackSQL(null, new PrintWriter(outStream))
    }
    catch (Exception e) {
        e.printStackTrace()
        event("StatusFinal", ["Failed to migrate database ${grailsEnv}"])
        exit(1)
    } finally {
        liquibase.getDatabase().getConnection().close();
    }
}