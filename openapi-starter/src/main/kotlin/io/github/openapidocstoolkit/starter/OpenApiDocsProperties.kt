import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "openapi-docs")
data class OpenApiDocsProperties (
    val enabled: Boolean = true,
    val endpoint: String,
    val outputDir: String = "docs",
    val versions: List<String> = listOf("v1"),
    val export: List<String> = listOf("json"),
)