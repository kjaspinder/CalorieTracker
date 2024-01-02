plugins {
    id("org.jetbrains.kotlin.android")
    `android-library`
    `kotlin-android`
}

apply(from = "$rootDir/compose-module.gradle")

android {
    namespace = "com.plcoding.core_ui"
}
dependencies {
    implementation("androidx.core:core-ktx:+")
}
