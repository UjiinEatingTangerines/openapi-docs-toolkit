package io.github.openapidocstoolkit.core.export

class PostmanExporter: Exporter{

    override fun supports(format: String): Boolean = format.equals("postman", ignoreCase = true)

    override fun export(json: String, outputDir: String, version: String) {
        TODO("Not yet implemented")
    }
}