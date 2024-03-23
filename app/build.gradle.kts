plugins {
    id("com.android.application")
}

android {

    dataBinding {
       enable = true
    }
}
android {
    namespace = "newprojectc.example.shoesapp_duked"
    compileSdk = 34

    defaultConfig {
        applicationId = "newprojectc.example.shoesapp_duked"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    //
    implementation ("com.github.bumptech.glide:glide:4.14.2")

    implementation ("com.github.bumptech.glide:glide:4.16.0")
    implementation ("com.google.api-client:google-api-client-android:1.31.2")
    implementation ("com.google.apis:google-api-services-drive:v3-rev20220628-1.31.2")
}