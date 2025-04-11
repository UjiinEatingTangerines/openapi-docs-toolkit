plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "openapi-docs-toolkits"

include("openapi-core")
include("openapi-web")
include("openapi-starter")
include("example-app")