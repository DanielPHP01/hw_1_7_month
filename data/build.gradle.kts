plugins {
    id(Plugins.AGP.library)
    id(Plugins.Kotlin.android)
    id(Plugins.Kotlin.kapt);
}

android {
    namespace = AppConfig.namespace
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        testInstrumentationRunner = AppConfig.TestInstrumentation
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {
    implementation(project(":domain"))

    testImplementation(Deps.UI.junit)
    androidTestImplementation(Deps.UI.extJunit)

    // Room
    implementation(Deps.Room.runtime)
    kapt(Deps.Room.compiler)
    implementation(Deps.Room.room)

    //Inject
    implementation(JavaX.inject)

    //Coroutines
    implementation(Deps.Coroutines.android)
}