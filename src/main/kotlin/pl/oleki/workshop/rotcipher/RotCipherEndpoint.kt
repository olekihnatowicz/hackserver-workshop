package pl.oleki.workshop.rotcipher

import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import pl.oleki.workshop.logger
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

@RestController
class RotCipherEndpoint {

    @GetMapping("/decrypt")
    fun decrypt(@RequestParam string: String): ResponseEntity<String> {
        val decodedString = URLDecoder.decode(string, StandardCharsets.US_ASCII)
        val decryptString = decryptString(decodedString)
        logger.info("input: $decodedString, decrypted: $decryptString")
        return ok(decryptString)
    }

    companion object {
        @JvmStatic
        fun decryptString(string: String): String {
            for(i in 1..100) {
                val decipthered = rotDecipther(i, string)
                if ("zadanie" in decipthered) {
                    return decipthered
                }
            }
            return ""
        }

        private fun rotDecipther(i: Int, string: String): String {
            return string.map {
                if (it >= 'a' && it <= 'z') {
                    var res: Char = it - i
                    if (res < 'a') {
                        res = res + ('z' - 'a' + 1)
                    }
                    res
                } else if (it >= 'A' && it <= 'Z') {
                    var res: Char = it - i
                    if (res < 'A') {
                        res = res + ('Z' - 'A' + 1)
                    }
                    res
                } else {
                    it
                }
            }.joinToString("")
        }

        private val logger by logger()
    }
}
