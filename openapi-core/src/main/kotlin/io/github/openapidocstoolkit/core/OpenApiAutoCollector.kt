import io.github.openapidocstoolkit.core.OpenApiFileWriter
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner

class OpenApiAutoCollector(
    private val fetcher: OpenApiFetcher,
    private val fileWriter: OpenApiFileWriter,
    private val props: OpenApiDocsProperties
) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {

        if(props.versions.isEmpty()) {
            println("[OPENAPI-DOCS-TOOLKIT] [WARNING] 처리할 버전이 없습니다.")
            return
        }

        // 버전별 다른 엔드포인트는 어떻게 구현해볼지 고민
        for (version in props.versions) {
            try {
                println("[OPENAPI-DOCS-TOOLKIT] [INFO] '$version' 버전의 OpenAPI 문서를 처리합니다...")
                val json = fetcher.fetch(props.endpoint)
                fileWriter.write(json, version, props.outputDir)
            } catch (e: Exception) {
                println("[OPENAPI-DOCS-TOOLKIT] [ERROR] '$version' 버전 처리 중 오류 발생: ${e.message}")
                // 로그에 스택 트레이스 출력
                e.printStackTrace()
            }
        }

        println("[OPENAPI-DOCS-TOOLKIT] [INFO] 모든 버전 처리 완료")
    }
}
