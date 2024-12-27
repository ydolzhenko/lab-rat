import net.researchgate.release.ReleaseExtension

plugins {
    id("base")
    alias(libs.plugins.gradle.release)
//    `maven-publish`

}

description = "Lab-rat (not a real one)"

defaultTasks("build")

allprojects {
}

subprojects {

}


configure<ReleaseExtension> {
    with(git) {
        requireBranch.set("master|legacy\\/[a-zA-Z0-9-_]+")
        // to disable branch verification: requireBranch.set(null as String?)
    }
}

tasks.named("afterReleaseBuild") {
    dependsOn("publish")
}
