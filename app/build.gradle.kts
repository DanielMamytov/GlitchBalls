plugins {
    alias(libs.plugins.android.application)
}


fun readConfigValue(key: String, fallback: String): String {
    val value = providers.gradleProperty(key).orNull
        ?: providers.environmentVariable(key).orNull
    return value?.takeIf { it.isNotBlank() } ?: fallback
}

fun quote(value: String): String = "\"${value}\""

android {
        namespace = "np.sairwv.glitchballs"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "np.sairwv.glitchballs"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"


        buildConfigField(
            "String",
            "CONFIG_ENDPOINT",
            quote(readConfigValue("GLITCH_CONFIG_ENDPOINT", "https://gllitchballs.com/config.php")),
        )
        buildConfigField(
            "String",
            "APPSFLYER_DEV_KEY",
            quote(readConfigValue("APPSFLYER_DEV_KEY", "hrXnLKRNj5etvFS4bqzCxT")),
        )
        buildConfigField(
            "String",
            "STORE_ID",
            quote(readConfigValue("GLITCH_STORE_ID", "np.sairwv.glitchballs")),
        )
        buildConfigField(
            "String",
            "DEBUG_WEB_URL",
            quote(readConfigValue("GLITCH_DEBUG_WEB_URL", "https://app.appsflyer.com/np.sairwv.glitchballs?pid=Test%20Source&c=testsub_testsub2_testsub_testsub_testsub_testsub_testsub_testsub1%20%23extra&siteid=syndicate_g&adset=testsub&af_adset=testsub3&af_c_id=testsub4&agency=Test%20Agency&af_sub1=testextra2&af_sub2=testextra3&af_sub3=testextra4&af_sub4=testextra5&af_sub5=testextra6&is_retargeting=true&deep_link_value=deep_link_test&deep_link_sub1=deep_test_sub1&advertising_id=bca9745d-9bf6-4875-9af0-4d2ef0a4daa9")),
        )
        buildConfigField(
            "boolean",
            "ENABLE_APPSFLYER_DEBUG",
            readConfigValue("GLITCH_AF_DEBUG", "false"),
        )
        buildConfigField(
            "boolean",
            "FORCE_DEBUG_WEB_FLOW",
            readConfigValue("GLITCH_FORCE_WEB_DEBUG", "false"),
        )
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    implementation("com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.5.9")
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
}