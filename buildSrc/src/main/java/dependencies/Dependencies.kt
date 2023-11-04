package dependencies

import versions.Versions

object Dependencies {

    object AndroidLib {
        const val core = "androidx.core:core-ktx:${Versions.core}"
        const val lifeCycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntime}"
        const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val googleMaterial = "com.google.android.material:material:${Versions.googleMaterial}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val debugComposeTooling = "androidx.compose.ui:ui-tooling:${Versions.composeTooling}"
        const val composeUi = "androidx.compose.ui:ui:${Versions.composeUi}"
        const val composeMaterial = "androidx.compose.material:material:${Versions.composeMaterial}"
        const val composeToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.composeToolingPreview}"
        const val composeNavigation = "androidx.navigation:navigation-compose:${Versions.composeNavigation}"
    }

    object NetworkingLib {
        const val retrofit2 = "com.squareup.retrofit2:retrofit:${Versions.retrofit2}"
        const val gson = "com.google.code.gson:gson:${Versions.gson}"
        const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.gsonConverter}"
        const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
        const val okhttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpInterceptor}"
        const val chucker = "com.github.chuckerteam.chucker:library:${Versions.chucker}"
        const val chuckerNoop = "com.github.chuckerteam.chucker:library-no-op:${Versions.chucker}"
    }

    object DependencyInjectionLib {
        const val hilt = "com.google.dagger:hilt-android:${Versions.hiltAndroid}"
        const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hiltCompiler}"
        const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationCompose}"
    }

    object UiLib {
        const val glide = "com.github.skydoves:landscapist-glide:${Versions.glide}"
        const val pager = "com.google.accompanist:accompanist-pager:${Versions.pager}"
    }

    object TestingLib {
        const val junit = "junit:junit:${Versions.junit}"
        const val androidTestJunit = "androidx.test.ext:junit:${Versions.androidTestJunit}"
        const val androidTestEspresso = "androidx.test.espresso:espresso-core:${Versions.androidTestEspresso}"
        const val androidComposeJunit = "androidx.compose.ui:ui-test-junit4:${Versions.androidComposeJunit}"
    }
}