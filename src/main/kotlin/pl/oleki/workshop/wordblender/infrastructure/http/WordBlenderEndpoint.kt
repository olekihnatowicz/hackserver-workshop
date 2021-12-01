package pl.oleki.workshop.wordblender.infrastructure.http

import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import pl.oleki.workshop.logger
import pl.oleki.workshop.wordblender.Blender.Companion.countWord

@RestController
class WordBlenderEndpoint {

    @GetMapping("/blender")
    fun blend(@RequestParam word: List<String>): ResponseEntity<Int> {
        logger.info("word: $word, count: ${countWord("developer", word)}")
        return ok(countWord("developer", word))
    }

    companion object {
        private val logger by logger()
    }
}
