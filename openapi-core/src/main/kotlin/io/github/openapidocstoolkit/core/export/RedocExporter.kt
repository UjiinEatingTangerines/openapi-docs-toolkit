package io.github.openapidocstoolkit.core.export

class RedocExporter: Exporter {

    override fun supports(format: String): Boolean = format.equals("redoc", ignoreCase = true)

    override fun export(json: String, outputDir: String, version: String) {
        TODO("Not yet implemented")
    }
}