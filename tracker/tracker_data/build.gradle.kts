plugins {
    id("org.jetbrains.kotlin.android")
    `android-library`
    `kotlin-android`
}

apply(from = "$rootDir/base-module.gradle")

android {
    namespace = "com.plcoding.tracker_data"
}

dependencies {
    implementation(project(Modules.core))
    implementation(project(Modules.trackerDomain))

    implementation(Retrofit.okHttp)
    implementation(Retrofit.retrofit)
    implementation(Retrofit.okHttpLoggingInterceptor)
    implementation(Retrofit.moshiConverter)
    implementation("androidx.core:core-ktx:+")

    "kapt"(Room.roomCompiler)
    implementation(Room.roomRuntime)
    implementation(Room.roomKtx)
}