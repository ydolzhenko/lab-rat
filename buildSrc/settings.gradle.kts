pluginManagement {

    val parentProperties = layout.rootDirectory.dir("..").file("gradle.properties").asFile

    val properties = java.util.Properties()
    parentProperties.inputStream().use {
        properties.load(it)
    }

    gradle.rootProject {
        properties.forEach { (k, v) ->
            project.extra.set(k.toString(), v)
        }
    }







}