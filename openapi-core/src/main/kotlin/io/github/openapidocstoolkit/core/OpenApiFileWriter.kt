package io.github.openapidocstoolkit.core

import java.io.*

class OpenApiFileWriter {

    fun write(json:String, version: String, outputDir: String) {

        //버전 매개변수 검증 추가
        //고민할 점, 경로 구분 없이 늘리고 싶은 경우는 어떻게 해야할지
        require(!version.contains("..") && !version.contains("/") && !version.contains("\\")) {
            "버전에 경로 구분자나 상위 디렉토리 참조가 포함도리 수 없습니다: $version"
        }

        // 저장 디렉토리 경로: docs/v1 (예시)
        val versionDir = File(outputDir, version)

        // 디렉토리가 없다면 생성
        if(!versionDir.exists()) {
            val created = versionDir.mkdirs()
            if(!created) {
                throw IOException("디렉토리 생성 실패: ${versionDir.absolutePath}")
            }
        }

        // 파일 경로: docs/v1/openapi.json
        val outputFile = File(versionDir, "openapi.json")

        // 파일 저장
        try {
            outputFile.writeText(json)
        } catch (e: IOException) {
            throw IOException("[OPENAPI-DOCS-TOOLKIT] [ERROR] JSON 파일 저장 실패: ${outputFile.absolutePath}", e)
        }

        // 성공 여부 확인
        println("[OPENAPI-DOCS-TOOLKIT] [INFO] OpenApi-Docs-toolkit 저장 완료: ${versionDir.absolutePath}")
    }
}