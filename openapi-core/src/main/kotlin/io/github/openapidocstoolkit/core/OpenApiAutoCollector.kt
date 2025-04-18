import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner

class OpenApiAutoCollector(
    private val fetcher: OpenApiFetcher,
    private val props: OpenApiDocsProperties
) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        fetcher.fetch("Something todo");
        println("Todo: args")
    }
}
