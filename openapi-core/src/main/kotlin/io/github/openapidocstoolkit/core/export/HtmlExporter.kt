package io.github.openapidocstoolkit.core.export

class HtmlExporter: Exporter {

    override fun supports(format: String): Boolean = format.equals("html", ignoreCase = true)

    override fun export(json: String, outputDir: String, version: String) {

    }
}