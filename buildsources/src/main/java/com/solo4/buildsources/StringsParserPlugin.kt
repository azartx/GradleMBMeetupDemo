package com.solo4.buildsources

import com.solo4.buildsources.extensions.StringsParserExtension
import com.solo4.buildsources.tasks.DownloadResTask
import com.solo4.buildsources.tasks.ParseResTask
import org.gradle.api.GradleException
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.file.ProjectLayout
import org.gradle.api.plugins.ExtensionContainer
import org.gradle.api.tasks.TaskContainer
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.named
import org.gradle.kotlin.dsl.register
import java.util.Properties
import javax.inject.Inject

private const val PLUGIN_TASKS_GROUP = "StringsParser"
private const val LOCAL_PROPERTIES_PATH = "../local.properties"
private const val AUTH_TOKEN_PROPERTY_NAME = "authToken"
private const val BUILD_STRINGS_FILE_PATH = "/strings.json"
private const val PROJECT_STRINGS_FILE_PATH = "/src/main/res/values/strings.xml"

class StringsParserPlugin @Inject constructor(
    private val tasks: TaskContainer,
    private val layout: ProjectLayout
) : Plugin<Project> {

    override fun apply(target: Project) {
        val parserExtension = registerParserExtension(target.extensions)
        createParserTask()
        setupBuildLogic(parserExtension)
    }

    private fun registerParserExtension(
        extensions: ExtensionContainer
    ): StringsParserExtension {
        return extensions.create<StringsParserExtension>("stringsParser").apply {
            shouldParseOnEachBuild.convention(false)
        }
    }

    private fun createParserTask() {
        registerDownloadStrResTask()
        registerParsingTask()

        registerStringsParserTask()
    }

    private fun setupBuildLogic(parserExtension: StringsParserExtension) {
        tasks.named("preBuild") {
            if (parserExtension.shouldParseOnEachBuild.get()) {
                dependsOn(tasks.named("stringsParserTask"))
            }
        }
    }

    private fun registerDownloadStrResTask() {
        val authToken = Properties().run {
            load(layout.projectDirectory.file(LOCAL_PROPERTIES_PATH).asFile.inputStream())
            getProperty(AUTH_TOKEN_PROPERTY_NAME)
        } ?: throw GradleException("locale.properties should contains $AUTH_TOKEN_PROPERTY_NAME property")
        tasks.register<DownloadResTask>("downloadStrResTask", authToken).configure {
            group = PLUGIN_TASKS_GROUP
            description = "Download and save strings.json file into the build folder"

            stringsJsonFile.convention(layout.buildDirectory.file("strings.json"))
        }
    }

    private fun registerParsingTask() {
        tasks.register<ParseResTask>("parseResTask") {
            group = PLUGIN_TASKS_GROUP
            description = "Parse existed json file with string resources and save in values folder"

            dependsOn(tasks.named<DownloadResTask>("downloadStrResTask"))

            strResJsonFile.convention(layout.buildDirectory.file(BUILD_STRINGS_FILE_PATH))
            outputStringsFile.convention(layout.projectDirectory.file(PROJECT_STRINGS_FILE_PATH))
        }
    }

    private fun registerStringsParserTask() {
        tasks.register("stringsParserTask") {
            group = PLUGIN_TASKS_GROUP
            description = "Executes couple of tasks which download and parse string resources"

            dependsOn(tasks.named<ParseResTask>("parseResTask"))

            doLast {
                println("String resources was successfully generated!")
            }
        }
    }
}