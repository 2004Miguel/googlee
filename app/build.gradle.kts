plugins {
    id("com.android.application")
}

android {
    namespace = "com.Miguel.correo"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.Miguel.correo"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        viewBinding;true
    }

}





dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

}

dependencies {
    //def camerax_version = "1.1.0-beta01" dependecias para abrir la camara
    implementation ("androidx.camera:camera-core:1.1.0-beta01")
    implementation ("androidx.camera:camera-camera2:1.1.0-beta01")
    implementation ("androidx.camera:camera-lifecycle:1.1.0-beta01")
    implementation ("androidx.camera:camera-video:1.1.0-beta01")

    implementation ("androidx.camera:camera-view:1.1.0-beta01")
    implementation ("androidx.camera:camera-extensions:1.1.0-beta01")
}

