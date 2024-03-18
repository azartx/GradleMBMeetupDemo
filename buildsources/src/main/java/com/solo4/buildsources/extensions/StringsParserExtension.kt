package com.solo4.buildsources.extensions

import org.gradle.api.provider.Property

interface StringsParserExtension {

    val shouldParseOnEachBuild: Property<Boolean>
}