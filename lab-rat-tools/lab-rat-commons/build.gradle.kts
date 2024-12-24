plugins {
    id("labrat.conventions")
}


dependencies {
    api(project(":lab-rat-tools:lab-rat-kotlin-lib"))
    api("io.arrow-kt:arrow-core")
    testImplementation("org.junit.jupiter:junit-jupiter")

}