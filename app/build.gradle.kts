plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id ("androidx.navigation.safeargs")
    id ("com.google.dagger.hilt.android")
}

android {
    namespace = "com.menesdurak.rickandmorty"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.menesdurak.rickandmorty"
        minSdk = 24
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    val android_core_ktx_version = "1.10.1"
    val app_compat_version = "1.6.1"
    val lifecycle_version = "2.6.1"
    val material_version = "1.9.0"
    val constraint_layout_version = "2.1.4"
    val retrofit_version = "2.9.0"
    val gson_version = "2.10.1"
    val hilt_version = "2.45"
    val nav_version = "2.6.0"

    // AndroidX
    implementation ("androidx.core:core-ktx:$android_core_ktx_version")
    implementation ("androidx.appcompat:appcompat:$app_compat_version")

    // Lifecycle
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation ("androidx.fragment:fragment-ktx:1.6.1")
    implementation ("androidx.activity:activity-ktx:1.7.2")
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")

    // Material
    implementation ("com.google.android.material:material:$material_version")

    // ConstraintLayout
    implementation ("androidx.constraintlayout:constraintlayout:$constraint_layout_version")

    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:$retrofit_version")
    implementation ("com.squareup.retrofit2:converter-gson:$retrofit_version")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.10.0")

    // Gson
    implementation ("com.google.code.gson:gson:$gson_version")

    // Hilt
    implementation ("com.google.dagger:hilt-android:$hilt_version")
    implementation ("androidx.legacy:legacy-support-v4:1.0.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    kapt ("com.google.dagger:hilt-compiler:$hilt_version")


    // Navigation Component
    implementation ("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation ("androidx.navigation:navigation-ui-ktx:$nav_version")

    // Coil
    implementation("io.coil-kt:coil:2.2.2")

    //Splash
    implementation ("androidx.core:core-splashscreen:1.0.1")

    testImplementation ("com.squareup.okhttp3:mockwebserver:4.10.0")
    testImplementation ("com.google.truth:truth:1.1.3")
    testImplementation ("org.mockito.kotlin:mockito-kotlin:4.0.0")
    testImplementation ("org.mockito:mockito-inline:3.0.0")
    testImplementation ("app.cash.turbine:turbine:0.12.1")
    implementation ("androidx.arch.core:core-testing:2.2.0")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.2")

    // Test
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
}
