
plugins {
    id("base")
    alias(libs.plugins.axion.release)
//    `maven-publish`

}

description = "Lab-rat (not a real one)"

scmVersion {
    tag {
        prefix = ""
    }
    versionCreator("versionWithBranch")

}

version = scmVersion.version

defaultTasks("build")

allprojects {
    project.version = rootProject.version
}

//
//subprojects {
//
//}

//configure<ReleaseExtension> {
//    with(git) {
//        requireBranch.set("master|legacy\\/[a-zA-Z0-9-_]+")
//         to disable branch verification: requireBranch.set(null as String?)
//    }
//}

//tasks.register("publish") {
//    doLast {
//        println("Root module does not publish artifacts.")
//    }
//}
//
//tasks.named("afterReleaseBuild") {
//    dependsOn(
//        subprojects.mapNotNull { it.tasks.findByName("blah") }
//    )
//}
