package io.github.openapidocstoolkit.core.export

interface Exporter {

    fun supports(format: String):Boolean
    fun export(json:String, outputDir: String, version: String)
}