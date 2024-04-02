package com.solo4.buildsources.tasks

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

abstract class ParseResTask  : DefaultTask() {

    @get:InputFile
    abstract val strResJsonFile: RegularFileProperty

    @get:OutputFile
    abstract val outputStringsFile: RegularFileProperty

    @TaskAction
    fun parseJsonResourcesToXml() {
        saveXmlToValuesFolder(
            stringsXmlContent = parseStringsMapToResourcesXml(
                stringsMap = createStringsMapFromJson()
            )
        )
    }

    private fun saveXmlToValuesFolder(stringsXmlContent: String) {
        outputStringsFile.get()
            .asFile
            .apply {
                if (!exists()) createNewFile()
                writeText(stringsXmlContent)
            }
    }

    private fun parseStringsMapToResourcesXml(stringsMap: Map<String, String>): String {
        return buildString {
            appendLine("<resources>")

            stringsMap.forEach { (key, value) ->
                appendLine("    <string name=\"$key\">$value</string>")
            }

            append("</resources>")
        }
    }

    private fun createStringsMapFromJson(): Map<String, String> {
        val type = Types.newParameterizedType(
            MutableMap::class.java,
            String::class.java,
            String::class.java
        )
        val moshi: JsonAdapter<Map<String, String>> = Moshi.Builder()
            .build()
            .adapter(type)

        return moshi.fromJson(strResJsonFile.get().asFile.readText())
            ?: throw Exception("Error while parsing json file to Map<String, String>")
    }
}