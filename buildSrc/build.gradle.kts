plugins {
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        register("module-plugin") {
            id = "module-plugin"
            implementationClass = "CommonModulePlugin"
        }
    }
}

repositories {
    google()
    mavenCentral()
    jcenter()
}

dependencies {
    compileOnly(gradleApi())
    implementation("com.android.tools.build:gradle:4.0.0")
    implementation(kotlin("gradle-plugin", "1.3.72"))
    implementation("androidx.navigation:navigation-safe-args-gradle-plugin:2.2.2")
}