plugins {
    id("java-library")
    alias(libs.plugins.jetbrainsKotlinJvm)
    kotlin("kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    kapt(libs.hilt.android.compiler)
    implementation(libs.hilt.core)

    testImplementation(libs.junit5)
    testImplementation(libs.mockito)
    testImplementation(libs.kotlinx.coroutines.test)
}

tasks.withType<Test> {
    useJUnitPlatform()
}