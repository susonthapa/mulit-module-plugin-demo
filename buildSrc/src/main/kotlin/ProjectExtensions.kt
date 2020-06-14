import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

fun Project.addRxJava() {
    dependencies {
        add("implementation", "io.reactivex.rxjava3:rxjava:3.0.2")
        add("implementation", "io.reactivex.rxjava3:rxandroid:3.0.0")
    }
}

fun Project.addRxAndroidBinding() {
    dependencies {
        add("implementation", "com.jakewharton.rxbinding4:rxbinding:4.0.0")
        add("implementation", "com.jakewharton.rxbinding4:rxbinding-material:4.0.0")
    }
}

fun Project.addAndroidMaterial() {
    dependencies {
        add("implementation", "com.google.android.material:material:1.2.0-alpha06")
    }
}

fun Project.addJetPackNavigation() {
    dependencies {
        add("implementation", "androidx.navigation:navigation-fragment-ktx:2.2.2")
        add("implementation", "androidx.navigation:navigation-ui-ktx:2.2.2")
    }
}

fun Project.addDaggerDI() {
    dependencies {
        add("implementation", "com.google.dagger:dagger:2.27")
        add("kapt", "com.google.dagger:dagger-compiler:2.27")
    }
}


fun Project.addRetrofit() {
    dependencies {
        add("implementation", "com.squareup.retrofit2:retrofit:2.9.0")
        add("implementation", "com.squareup.retrofit2:adapter-rxjava3:2.9.0")
        add("implementation", "com.squareup.okhttp3:okhttp:4.7.2")
        add("implementation", "com.squareup.okhttp3:logging-interceptor:4.7.2")

        // moshi json library
        add("implementation", "com.squareup.moshi:moshi:1.9.2")
        add("implementation", "com.squareup.retrofit2:converter-moshi:2.9.0")
        add("kapt", "com.squareup.moshi:moshi-kotlin-codegen:1.9.2")
    }
}