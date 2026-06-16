plugins {
    id("com.android.application")
}

android {
    namespace = "space.jtcao.wc26"
    compileSdk = 34

    signingConfigs {
        create("release") {
            storeFile = file("../android.keystore")
            storePassword = "wc26app123"
            keyAlias = "wc26"
            keyPassword = "wc26app123"
        }
    }

    defaultConfig {
        applicationId = "space.jtcao.wc26"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "6.1.1"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
    }
}

dependencies {
    implementation("com.google.androidbrowserhelper:androidbrowserhelper:2.4.0")
}
