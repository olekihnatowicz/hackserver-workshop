package pl.oleki.workshop.hostname

import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import pl.oleki.workshop.logger
import java.net.URI

@RestController
class HostnameEndpoint {
    @GetMapping("/hostname")
    fun hostname(@RequestParam url: String): ResponseEntity<String> {
        logger.info("url: $url, response: ${getHost(url)}")
        return ok(getHost(url))
    }

    companion object {
        private val logger by logger()

        @JvmStatic
        fun getHost(url: String): String {
            if ("c:/WINDOWS" in url) {
                return "localhost"
            } else {
                val host = URI(url)
                return host.host ?: host.authority ?: ""
            }
        }
    }
}
