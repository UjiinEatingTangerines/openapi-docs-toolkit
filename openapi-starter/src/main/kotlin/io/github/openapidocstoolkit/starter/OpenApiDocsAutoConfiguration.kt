import io.github.openapidocstoolkit.core.OpenApiFileWriter
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(OpenApiDocsProperties::class)
@ConditionalOnProperty(prefix = "openapi-docs", name = ["enabled"], havingValue = "true", matchIfMissing = true)
class OpenApiDocsAutoConfiguration {
    @Bean
    fun openApiAutoCollector(fetcher: OpenApiFetcher, fileWriter: OpenApiFileWriter, props: OpenApiDocsProperties): OpenApiAutoCollector{
        return OpenApiAutoCollector(fetcher, fileWriter, props)
    }
    @Bean
    fun openApiFetcher(): OpenApiFetcher {
        return OpenApiFetcher()
    }

    @Bean
    fun openApiWriter(): OpenApiFileWriter {
        return OpenApiFileWriter()
    }
}