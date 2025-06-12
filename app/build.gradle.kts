plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.secrets.gradle.plugin)
}

android {
    namespace = "com.tangwong.project"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.tangwong.project"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        buildTypes {
            release {
                ndk {
                    abiFilters.addAll(listOf("arm64-v8a", "armeabi-v7a"))
                }
                isMinifyEnabled = false
                isShrinkResources = false
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
//            signingConfig = signingConfigs.getByName("PEARelease")
            }

            debug {
                ndk {
                    abiFilters.addAll(listOf("arm64-v8a", "armeabi-v7a"))
                }
                isMinifyEnabled = false
                isShrinkResources = false
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    flavorDimensions += "environment"

    productFlavors {
        create("dev") {
            isDefault = true

            dimension = "environment"
            applicationIdSuffix = ".dev"
            resValue("string", "app_name", "Tangwong dev")
            buildConfigField("String", "ENVIRONMENT", "\"dev\"")
            buildConfigField("String", "BASE_URL", "\"https://peamigration.cdg.co.th/pea-ws/api/\"")
        }

        create("staging") {
            dimension = "environment"
            applicationIdSuffix = ".staging"
            resValue("string", "app_name", "Tangwong staging")
            buildConfigField("Boolean", "ENABLE_IN_DISTANCE", "false")
            buildConfigField("String", "ENVIRONMENT", "\"staging\"")
            buildConfigField(
                "String",
                "BASE_URL",
                "\"https://gisnonprd.pea.co.th/peawebsite-ws/api/\""
            )
        }

        create("uat") {
            dimension = "environment"
            applicationIdSuffix = ".uat"
            resValue("string", "app_name", "Tangwong UAT")
            buildConfigField("Boolean", "ENABLE_IN_DISTANCE", "false")
            buildConfigField("String", "ENVIRONMENT", "\"uat\"")
            buildConfigField("String", "BASE_URL", "\"http://10.4.18.207/peawebsite-ws/api/\"")
        }

        create("production") {
            dimension = "environment"
            resValue("string", "app_name", "Tangwong")
            buildConfigField("String", "ENVIRONMENT", "\"production\"")
            buildConfigField("String", "BASE_URL", "\"https://gisn1.pea.co.th/peawebsite-ws/api/\"")
        }
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Gms - play services-locations
    implementation(libs.play.services.location)
    // Androidx - Navigation Compose
    implementation(libs.androidx.navigation.compose)
    // Koin Dependency Injection
    implementation(libs.androidx.koin.compose)
    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)
    // OkHttp
    implementation(libs.okhttp)
    // logging interceptor
    implementation(libs.logging.interceptor)
    // Timber (Log)
    implementation(libs.timber)
    // Accompanist-Permissions (Manage Multiple-Permissions)
    implementation(libs.accompanist.permissions)
    // Room
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)
    // Firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.crashlytics)
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.perf)
    // coil
    implementation(libs.coil.compose)
    // SplashScreen
    implementation(libs.androidx.splashscreen)
    // browser
    implementation(libs.androidx.browser)

}