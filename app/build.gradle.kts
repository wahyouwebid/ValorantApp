import buildtype.AndroidBuildType.debug
import buildtype.AndroidBuildType.release
import config.AndroidConfig
import dependencies.Dependencies

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("kotlin-parcelize")
}

@Suppress("UnstableApiUsage")
android {
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        namespace = AndroidConfig.appNameSpace
        minSdk = AndroidConfig.minSdk
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName
        testInstrumentationRunner = AndroidConfig.testInstrumentRunner

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        named(debug) {
            isMinifyEnabled = false
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            buildConfigField("String", "baseUrl", "\"https://valorant-api.com/\"")
        }

        named(release) {
            isMinifyEnabled = true
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            buildConfigField("String", "baseUrl", "\"https://valorant-api.com//\"")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        buildConfig = true
        viewBinding = true
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0"
    }

    packagingOptions {
        resources {
            excludes.add("/META-INF/AL2.0")
            excludes.add("/META-INF/LGPL2.1")
        }
    }
}

dependencies {
    Dependencies.AndroidLib.apply {
        implementation(core)
        implementation(lifeCycleRuntime)
        implementation(activityCompose)
        implementation(appCompat)
        implementation(googleMaterial)
        implementation(constraintLayout)
        debugImplementation(debugComposeTooling)
        implementation(composeUi)
        implementation(composeMaterial)
        implementation(composeToolingPreview)
        implementation(composeNavigation)
    }

    Dependencies.UiLib.apply {
        implementation(pager)
        implementation(glide)
    }

    Dependencies.NetworkingLib.apply {
        implementation(retrofit2)
        implementation(gson)
        implementation(converterGson)
        implementation(okhttp)
        implementation(okhttpInterceptor)
        debugImplementation(chucker)
        releaseImplementation(chuckerNoop)
    }

    Dependencies.DependencyInjectionLib.apply {
        implementation(hilt)
        kapt(hiltCompiler)
        implementation(hiltNavigationCompose)
    }

    Dependencies.TestingLib.apply {
        testImplementation(junit)
        androidTestImplementation(androidTestJunit)
        androidTestImplementation(androidTestEspresso)
        androidTestImplementation(androidComposeJunit)
    }
}
