// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        jcenter()
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
