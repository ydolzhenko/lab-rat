plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    `maven-publish`
    id("org.owasp.dependencycheck")
}

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

if (project.parent != null) {
    val parentName = project.parent!!.name
    if (parentName == "lab-rat-tools") {
        group = "com.ahold.labrat.tools"
    } else {
        group = "com.ahold.labrat"
    }
} else {
    group = "com.ahold.labrat"
}

val javaVersion: String by extra
val springBootVersion: String by extra
val kotlinVersion: String by extra

dependencyCheck {
    analyzers {
        assemblyEnabled = false
        nugetconfEnabled = false
        nuspecEnabled = false
        cocoapodsEnabled = false
        rubygemsEnabled = false
    }
 nvd {
     apiKey = "b5a7bd9b-c49e-44fd-baeb-0d54fc0c069a"
     datafeedUrl = "https://dependency-check.github.io/DependencyCheck_Builder/nvd_cache/nvdcve-{0}.json.gz"
 }
}

java {

    withJavadocJar()
    withSourcesJar()

    toolchain {
        languageVersion = JavaLanguageVersion.of(javaVersion)
    }
}

tasks.register("blah") {
    doLast {
        println("HERE $version")
    }
}

dependencies {

    implementation(platform(project(":lab-rat-platform")))

}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

testing {

    suites {
        withType<JvmTestSuite> {
            useJUnitJupiter()
            dependencies {
                implementation(platform(project(":lab-rat-platform")))
            }
        }


        val test by getting(JvmTestSuite::class) {
        }

        val integrationTest by registering(JvmTestSuite::class) {
            testType = TestSuiteType.INTEGRATION_TEST

            dependencies {
                implementation(project())

            }

            targets {
                all {
                    testTask.configure {
                        shouldRunAfter(test)
                    }
                }
            }
        }

    }



}

tasks.named("check") {
    dependsOn(testing.suites.named("integrationTest"))
//    dependsOn(tasks.dependencyCheckAnalyze)
}

tasks.withType<Jar> {

    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    manifest {
        attributes["Implementation-Title"] = version
        attributes["Implementation-Version"] = project.name
    }

}

publishing {
    publications {
        create<MavenPublication>(project.name) {
            from(components["java"])
        }
    }

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
