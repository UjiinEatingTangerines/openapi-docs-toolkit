plugins {
    kotlin("jvm") version "1.9.21"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    // HTTP 요청용 (Spring RestTemplate 또는 WebClient 없이 사용 가능)
    implementation("com.squareup.okhttp3:okhttp:4.12.0")

    // JSON 파싱
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.17.0")

    // Kotlin reflection
    implementation("org.jetbrains.kotlin:kotlin-reflect")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
    }
}