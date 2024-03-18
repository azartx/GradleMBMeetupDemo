plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    // Подключение созданного плагина в app модуль проекта
    id("strings-parser")
}

// Расширение, созданное с помощью плагина StringParserPlugin.
// Даёт доступ к параметру shouldParseOnEachBuild.
stringsParser {
    shouldParseOnEachBuild = true
}

// Расширение, полученное из Android Gradle Plugin. Даёт доступ к настройкам AGP.
android {
    namespace = "com.solo4.gradlembmeetupdemo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.solo4.gradlembmeetupdemo"
        minSdk = 29
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
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}