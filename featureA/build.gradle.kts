plugins {
    id("com.android.library")
    id("module-plugin")
    id("kotlin-kapt")
}
addRxJava()
addRxAndroidBinding()
addAndroidMaterial()
addJetPackNavigation()
addDaggerDI()
addRetrofit()

dependencies {
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
}
