// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val kotlin_version by extra("1.3.72")
    repositories {
        google()
        jcenter()
    }
    dependencies {
        "classpath"("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")

    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

// register clean task
tasks.register("clean").configure {
    delete("build")
}
