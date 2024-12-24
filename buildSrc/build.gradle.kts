plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    gradlePluginPortal()
    maven {
        name = "Confluent"
        url = uri("https://packages.confluent.io/maven/")
    }
    maven {
        name = "ed_github"
        url = uri("https://maven.pkg.github.com/ydolzhenko/lab-rat")
    }
}

val kotlinVersion: String by extra;
val springBootVersion: String by extra;
val owaspDependencyCheckVersion: String by extra;


dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-allopen:${kotlinVersion}")
    implementation("org.owasp:dependency-check-gradle:${owaspDependencyCheckVersion}")
}