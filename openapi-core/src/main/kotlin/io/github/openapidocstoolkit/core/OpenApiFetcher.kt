import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import java.time.Duration

class OpenApiFetcher {

    // OkHttpClient는 한 번만 생성해서 재사용
    private val client = OkHttpClient.Builder()
        .callTimeout(Duration.ofSeconds(5))
        .connectTimeout(Duration.ofSeconds(3))
        .build()

    fun fetch(endpoint: String): String {
        //GET 요청
        val request = Request.Builder()
            .url(endpoint)
            .get()
            .build()

        try {
            client.newCall(request).execute().use { response ->
                // sonarQube 요청으로 수정 - 가독성 및 중복성의 오류가 있을 수 있으며, kotlin 함수가 있다면 사용하는 것이 좋음
                // require 내부적으로, 예외 발생시 IllegalStateException 발생
                /*if (!response.isSuccessful) {
                    throw IllegalStateException("OpenAPI fetch failed with code ${response.code} from $endpoint")
                }*/
                require(response.isSuccessful) { "OpenAPI fetch failed with code ${response.code} from $endpoint" }

                // 결과값 체크
                // sonarQube 요청으로 수정 - 가독성 및 중복성의 오류가 있을 수 있으며, kotlin 함수가 있다면 사용하는 것이 좋음
                // requireNotNull 내부적으로 IllegalStateException 를 발생하지 않지만 가시성 향상을 위해 사용
                /*val body = response.body?.string()
                    ?: throw IllegalStateException("OpenAPI response body is null from $endpoint")*/
                val body = requireNotNull(response.body?.string()) { "OpenAPI response body is null from $endpoint" }

                return body
            }
        } catch (e: IOException) {
            throw RuntimeException("Failed to fetch OpenAPI docs from $endpoint", e)
        }
    }
}