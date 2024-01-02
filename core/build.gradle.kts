plugins {
    id("org.jetbrains.kotlin.android")
    `android-library`
    `kotlin-android`
}

apply(from = "$rootDir/base-module.gradle")

android {
    namespace = "com.plcoding.core"
}
dependencies {
    implementation("androidx.core:core-ktx:+")
}
