package com.solo4.buildsources.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import java.net.URL
import javax.inject.Inject

private const val STRINGS_ENDPOINT =
    "https://firebasestorage.googleapis.com/v0/b/mywishes-ab7a3.appspot.com/o/strings.json"

abstract class DownloadResTask @Inject constructor(
    private val authToken: String
) : DefaultTask() {

    @get:OutputFile
    abstract val stringsJsonFile: RegularFileProperty

    @TaskAction
    fun downloadResourcesFromRemote() {
        val stringsJsonUrl = STRINGS_ENDPOINT
            .plus("?alt=media")
            .plus("&token=$authToken")

        val dataInputStream = URL(stringsJsonUrl).openConnection()
            .getInputStream()

        dataInputStream.use { inputStream ->
            stringsJsonFile
                .get()
                .asFile
                .apply {
                    if (!exists()) createNewFile()
                    writeBytes(inputStream.readAllBytes())
                }
        }
    }
}