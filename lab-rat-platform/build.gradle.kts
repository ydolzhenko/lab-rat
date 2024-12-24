
plugins {
    `java-platform`
    `maven-publish`
}

repositories {
    mavenCentral()
    gradlePluginPortal()
    maven {
        name = "Confluent"
        url = uri("https://packages.confluent.io/maven/")
    }
    maven {
        name = "edGithub"
        url = uri("https://maven.pkg.github.com/ydolzhenko/lab-rat")
    }
}

javaPlatform {
    allowDependencies()
}

group = "com.ahold.labrat"

val springBootVersion: String by extra

dependencies {
    api(platform("org.springframework.boot:spring-boot-dependencies:${springBootVersion}"))
    api(platform(libs.arrow.stack))

    constraints {
        api(project(":lab-rat-tools:lab-rat-kotlin-lib"))
        api(project(":lab-rat-tools:lab-rat-commons"))
        api(libs.logstash.logback.encoder)
    }

}

publishing {
    publications {
        create<MavenPublication>("lab-rat-platform") {
            from(components["javaPlatform"])
        }
    }
}