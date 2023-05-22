plugins {
    id(Plugins.AGP.application)
    id(Plugins.Kotlin.android)
    id(Plugins.Kotlin.kapt)
    id(Plugins.DaggerHilt.hilt)
}

android {
    namespace = AppConfig.namespace
    compileSdk = AppConfig.compileSdk
    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName
        testInstrumentationRunner = AppConfig.TestInstrumentation
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
        sourceCompatibility = AppConfig.compatibility
        targetCompatibility = AppConfig.compatibility
    }
    kotlinOptions {
        jvmTarget = AppConfig.jvmTarget
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
    kapt(Deps.Room.compiler)
    implementation(Deps.Room.room)

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
    implementation(Deps.Lifecycle.viewModel)
    implementation(Deps.Lifecycle.runtime)
}