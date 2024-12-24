plugins {
    id("labrat.conventions")
}


dependencies {

    api("org.jetbrains.kotlin:kotlin-stdlib")
    api("org.jetbrains.kotlin:kotlin-reflect")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-debug")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-slf4j")

    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testImplementation("org.junit.jupiter:junit-jupiter")

}