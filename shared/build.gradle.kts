import org.jetbrains.compose.ExperimentalComposeLibrary

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlinSerialization)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "16.0"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            isStatic = true
        }
        pod("GoogleSignIn")
    }
    
    sourceSets {
        commonMain.dependencies {
            implementation(compose.ui)
            implementation(compose.material)
            implementation(compose.material3)
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.animation)
            implementation(compose.materialIconsExtended)
            @OptIn(ExperimentalComposeLibrary::class)
            implementation(compose.components.resources)

            implementation(libs.androidx.datastore.core.okio)
            implementation(libs.androidx.datastore.preferences.core)
            implementation(libs.androidx.datastore.preferences)

            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.datetime)
            implementation(libs.kotlinx.serialization.core)
            implementation(libs.kotlinx.serialization.json)

            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.auth)
            implementation(libs.ktor.client.serialization)
            implementation(libs.ktor.client.json)
            implementation(libs.ktor.client.logging)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)

            implementation(libs.orbit.core)
            implementation(libs.okio)

            implementation(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.annotations)

            implementation(libs.coil)
            implementation(libs.coil.compose)
            implementation(libs.coil.network)
            implementation(libs.essenty.lifecycle)
            implementation(libs.essenty.lifecycle.coroutines)

            implementation(libs.voyager.koin)
            implementation(libs.voyager.navigator)
            implementation(libs.voyager.tabNavigator)
            implementation(libs.voyager.screenModel)
            implementation(libs.voyager.transitions)
            implementation(libs.voyager.bottomSheetNavigator)
            implementation(libs.stately.common)
        }

        androidMain.dependencies {
            implementation(libs.ktor.client.android)
            implementation(libs.koin.android)
            implementation(libs.orbit.viewmodel)
            implementation(libs.androidx.datastore.preferences)
            implementation(libs.koin.androidx.compose)
            implementation(libs.orbit.compose)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

dependencies {
    add("kspCommonMainMetadata", libs.koin.ksp.compiler)
    add("kspAndroid", libs.koin.ksp.compiler)
    add("kspIosArm64", libs.koin.ksp.compiler)
    add("kspIosSimulatorArm64", libs.koin.ksp.compiler)
}

android {
    sourceSets["main"].res.srcDirs("src/androidMain/res", "src/commonMain/resources")
    namespace = "org.gdsc.teamf.influence"
    compileSdk = 34
    defaultConfig {
        minSdk = 26
    }
}