plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.buzzware.athleteedge"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.buzzware.athleteedge"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        setProperty("archivesBaseName", "Athlete Edge")
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //SDP library for multiple device support layouts
    implementation("com.intuit.sdp:sdp-android:1.1.0")
    implementation ("com.github.bumptech.glide:glide:4.16.0") //Image Load from url
    implementation ("com.makeramen:roundedimageview:2.3.0") //Image Corner Rounded
    implementation ("com.github.PhilJay:MPAndroidChart:v3.1.0") //State Graphs
    implementation ("com.github.alpbak:BoxedVerticalSeekBar:1.1.1") //Vertical Seek Bar
    implementation ("com.google.android.flexbox:flexbox:3.0.0") //Flow Layout

}