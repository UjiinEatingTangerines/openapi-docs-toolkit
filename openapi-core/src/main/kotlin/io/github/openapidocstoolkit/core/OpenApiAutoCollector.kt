import io.github.openapidocstoolkit.core.OpenApiFileWriter
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner

class OpenApiAutoCollector(
    private val fetcher: OpenApiFetcher,
    private val fileWriter: OpenApiFileWriter,
    private val props: OpenApiDocsProperties
) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        for (version in props.versions) {
            val json = fetcher.fetch(props.endpoint)
            fileWriter.write(json, version, props.outputDir)
        }
    }
}
