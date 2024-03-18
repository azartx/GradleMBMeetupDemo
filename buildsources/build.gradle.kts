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