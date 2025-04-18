import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner

class OpenApiAutoCollector(
    private val props: OpenApiDocsProperties
) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        println("Todo: args")
    }
}
