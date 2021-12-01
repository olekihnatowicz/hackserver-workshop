package pl.oleki.workshop.wordblender

import kotlin.math.min
import pl.oleki.workshop.logger
import kotlin.math.max

class Blender {
    companion object {
        fun countWord(word: String, input: List<String>): Int {
            val charsCounter = createCharCounters(input)
            val wordCharsCounter = createCharCounters(listOf(word))
            logger.info("charsCounter: $charsCounter, wordCounter: $wordCharsCounter")
            return takeMin(charsCounter, wordCharsCounter)
        }

        private fun createCharCounters(input: List<String>): Map<Char, Int> {
            return input.joinToString(separator = "").groupingBy { it }.eachCount()
        }

        private fun takeMin(first: Map<Char, Int>, second: Map<Char, Int>): Int {
            return second.map {
                val firstCount: Int = first[it.key] ?: 0
                val i: Int = firstCount / it.value
                min(i, firstCount)
            }.minOrNull() ?: 0
        }

        private val logger by logger()
    }
}
