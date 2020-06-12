import com.android.build.gradle.AppExtension
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class CommonModulePlugin : Plugin<Project> {

    override fun apply(project: Project) {
        // apply plugin common to all projects
        project.plugins.apply("kotlin-android")
        project.plugins.apply("kotlin-android-extensions")
        project.plugins.apply("androidx.navigation.safeargs.kotlin")

        // configure the android block
        val androidExtensions = project.extensions.getByName("android")
        if (androidExtensions is BaseExtension) {
            androidExtensions.apply {
                compileSdkVersion(29)
                buildToolsVersion("29.0.3")

                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_1_8
                    targetCompatibility = JavaVersion.VERSION_1_8
                }

                project.tasks.withType(KotlinCompile::class.java).configureEach {
                    kotlinOptions {
                        jvmTarget = JavaVersion.VERSION_1_8.toString()
                    }
                }

                testOptions {
                    unitTests.isReturnDefaultValues = true
                }

                defaultConfig {
                    minSdkVersion(21)
                    targetSdkVersion(29)
                    versionCode = 1
                    versionName = "1.0"

                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }

                viewBinding.isEnabled = true

                when(this) {
                    is LibraryExtension -> {
                        defaultConfig {
                            // apply the pro guard rules for library
                            consumerProguardFiles("consumer-rules.pro")
                        }
                    }

                    is AppExtension -> {
                        buildTypes {
                            getByName("release") {
                                isMinifyEnabled = false
                                proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
                            }
                        }
                    }
                }
            }
        }

        // dependencies common to all projects
        project.dependencies {
            add("implementation", "org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.72")
            add("implementation", "androidx.core:core-ktx:1.2.0")

            // dependency for timber
            add("implementation", "com.jakewharton.timber:timber:4.7.1")

            // testing dependencies
            add("testImplementation", "org.mockito:mockito-core:3.3.3")
            add("testImplementation", "com.google.truth:truth:1.0.1")
            add("testImplementation", "junit:junit:4.13")
            add("androidTestImplementation", "androidx.test.ext:junit:1.1.1")
            add("androidTestImplementation", "androidx.test.espresso:espresso-core:3.2.0")
        }
    }
}