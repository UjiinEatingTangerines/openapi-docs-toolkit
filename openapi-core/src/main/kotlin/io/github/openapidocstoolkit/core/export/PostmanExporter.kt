package io.github.openapidocstoolkit.core.export

import java.io.File

class PostmanExporter: Exporter{

    override fun supports(format: String): Boolean = format.equals("postman", ignoreCase = true)

    override fun export(json: String, outputDir: String, version: String) {
        val fileName = "openapi-postman-$version.postman_collection.json"
        val file = File(outputDir, fileName)
        file.writeText(json)
        println("✅ Postman collection exported to: ${file.absolutePath}")
    }
}