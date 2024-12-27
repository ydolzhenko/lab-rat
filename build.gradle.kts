import net.researchgate.release.ReleaseExtension

plugins {
    id("base")
    alias(libs.plugins.gradle.release)


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
