package io.github.openapidocstoolkit.core

import java.io.*

class OpenApiFileWriter {

    fun write(json:String, version: String, outputDir: String) {
        // 저장 디렉토리 경로: docs/v1 (예시)
        val versionDir = File(outputDir, version)

        // 디렉토리가 없다면 생성
        if(!versionDir.exists()) {
            val created = versionDir.mkdirs()
            if(!created) {
                throw Exception("디렉토리 생성 실패: ${versionDir.absolutePath}")
            }
        }

        // 파일 경로: docs/v1/openapi.json
        val outputFile = File(versionDir, "openapi.json")

        // 파일 저장
        outputFile.writeText(json)

        // 성공 여부 확인
        println("[OPENAPI-DOCS-TOOLKIT] [INFO] OpenApi-Docs-toolkit 저장 완료: ${versionDir.absolutePath}")
    }
}