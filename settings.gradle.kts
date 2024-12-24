import java.nio.file.Files.exists
import java.nio.file.Files.isDirectory
import java.nio.file.Files.list
import java.nio.file.Path

pluginManagement {

    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven {
            name = "Confluent"
            url = uri("https://packages.confluent.io/maven/")
        }
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/RoyalAholdDelhaize/lab-rat")
        }
    }

}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version("0.8.0")
}

rootProject.name = "lab-rat"

val toolsDir: Path = layout.rootDirectory.dir("lab-rat-tools").asFile.toPath()

if (exists(toolsDir) && isDirectory(toolsDir)) {
    list(toolsDir).filter { isDirectory(it) }.forEach {
        include("lab-rat-tools:${it.fileName}")
    }
}

include("lab-rat-platform")