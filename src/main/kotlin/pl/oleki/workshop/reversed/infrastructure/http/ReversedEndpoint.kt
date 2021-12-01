package pl.oleki.workshop.reversed.infrastructure.http

import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import pl.oleki.workshop.logger
import pl.oleki.workshop.reversed.reverse

@RestController
class ReversedEndpoint {

    @GetMapping("/reversed")
    fun reverseString(@RequestParam string: String): ResponseEntity<String> {
        logger.info("string to reverse: $string reversed: ${reverse(string)}")
        return ok(reverse(string))
    }

    companion object {
        private val logger by logger()
    }
}
