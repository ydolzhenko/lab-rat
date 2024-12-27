import net.researchgate.release.ReleaseExtension

plugins {
    id("base")
    alias(libs.plugins.gradle.release)
    `maven-publish`

}



description = "Lab-rat (not a real one)"

defaultTasks("build")

allprojects {
}

subprojects {
}

apply(plugin = "base")
apply(plugin = "net.researchgate.release")

configure<ReleaseExtension> {
//    buildTasks = listOf("publish")
//    ignoredSnapshotDependencies.set(listOf("net.researchgate:gradle-release"))
    with(git) {
        requireBranch.set("master|legacy\\/[a-zA-Z0-9-_]+")
        // to disable branch verification: requireBranch.set(null as String?)
    }
}

publishing {
    repositories {
        maven {
            name = "edGithub"
            url = uri("https://maven.pkg.github.com/ydolzhenko/lab-rat")
            credentials {
                username = System.getenv("PACKAGE_MASTER")
                password = System.getenv("PACKAGE_MASTER_PASSWORD")
            }
        }
    }
}

tasks.named("afterReleaseBuild") {
    dependsOn("publish")
}