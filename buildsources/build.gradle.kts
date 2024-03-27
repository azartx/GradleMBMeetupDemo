plugins {
    `kotlin-dsl`
}

group = "com.solo4.buildsources"

gradlePlugin {
    plugins.create("stringsParser") {
        id = "strings-parser"
        description = "Plugin add some tasks to download and parse string resources from remote"
        implementationClass = "com.solo4.buildsources.StringsParserPlugin"
    }
}

dependencies {
    implementation(libs.squareup.moshi)
}

val taskA by tasks.registering
val taskB by tasks.registering

abstract class TaskA : DefaultTask() {

    @TaskAction
    fun doAction() {

    }
}

abstract class TaskB : DefaultTask() {

    @TaskAction
    fun doAction() {

    }
}