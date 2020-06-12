plugins {
    id("com.android.application")
    id("module-plugin")
    id("kotlin-kapt")
}

android {
    defaultConfig {
        applicationId = "np.com.susonthapa.multimoduleplugindemo"
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
}