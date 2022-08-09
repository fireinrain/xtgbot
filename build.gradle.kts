plugins {
    kotlin("jvm") version "1.7.10"
}

group = "com.fireinrain"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // telegram bot api
    implementation("org.telegram:telegrambots:6.1.0")
    // http
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
    // parse html
    implementation("org.jsoup:jsoup:1.15.2")
    // sqlite3 for storage
    implementation("org.xerial:sqlite-jdbc:3.39.2.0")
    // orm
    implementation("com.j256:ormlite:3.0")
    // logback
    implementation("ch.qos.logback:logback-classic:1.2.11")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}