plugins {
    id(Plugins.AGP.application)
    id(Plugins.Kotlin.android)
    id(Plugins.Kotlin.kapt)
    id(Plugins.DaggerHilt.hilt)
}

android {
    namespace = "com.example.Note-App"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = "com.example.Note-App"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
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
        sourceCompatibility = JavaVersion.VERSION_1_9
        targetCompatibility = JavaVersion.VERSION_1_9
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // Android
    implementation(Deps.UI.androidCore)
    implementation(Deps.UI.appcompat)
    implementation(Deps.UI.material)

    // UI
    implementation(Deps.UI.constraint)

    // Test
    testImplementation(Deps.UI.junit)
    androidTestImplementation(Deps.UI.extJunit)
    androidTestImplementation(Deps.UI.espresso)

    // Fragment
    implementation(Deps.UI.fragment)

    // Room
    implementation(Deps.Room.runtime)
    implementation(Deps.Room.compiler)
    kapt(Deps.Room.ktx)

    // Hilt
    implementation(Deps.DaggerHilt.android)
    implementation(Deps.DaggerHilt.core)
    kapt(Deps.DaggerHilt.compiler)

    // Coroutines
    implementation(Deps.Coroutines.android)

    // NavComponent
    implementation(Deps.NavComponent.fragment)
    implementation(Deps.NavComponent.ui)

    // Lifecycle
    implementation(Deps.Lifecycle.lifecycle)

    //fix Duplicate
    implementation(platform(Deps.Duplicate.kotlin))
}