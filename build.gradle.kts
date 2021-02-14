plugins {
    kotlin("multiplatform") version "1.4.30"
    id("com.android.library")
}

group = "com.example"
version = "1.0"

repositories {
    google()
    mavenCentral()
    jcenter()
}

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
                useIR = true
            }
        }
    }
    iosX64("ios") {
        binaries {
            framework {
                baseName = "library"
            }
        }
    }
    sourceSets {
        val commonMain by getting
        val androidMain by getting {
            dependencies {
                implementation("androidx.compose.ui:ui:1.0.0-alpha12")
            }
        }
        val iosMain by getting
    }
    sourceSets.all {
        languageSettings.languageVersion = "1.5"
        languageSettings.apiVersion = "1.5"
    }
}

android {
    compileSdkVersion(30)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(30)
    }
}