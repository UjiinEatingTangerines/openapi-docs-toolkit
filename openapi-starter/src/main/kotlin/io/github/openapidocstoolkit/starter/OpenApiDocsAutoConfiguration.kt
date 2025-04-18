import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(OpenApiDocsProperties::class)
@ConditionalOnProperty(prefix = "openapi-dos", name = ["enabled"], havingValue = "true", matchIfMissing = true)
class OpenApiDocsAutoConfiguration {
    @Bean
    fun openApiAutoCollector(fetcher: OpenApiFetcher, props: OpenApiDocsProperties): OpenApiAutoCollector{
        return OpenApiAutoCollector(fetcher, props)
    }
    @Bean
    fun openApiFetcher(): OpenApiFetcher {
        return OpenApiFetcher()
    }
}