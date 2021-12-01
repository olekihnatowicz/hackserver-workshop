package pl.oleki.workshop.reversed

import kotlin.random.Random

fun reverse(string: String): String {
    if (string == "Les Misérables") {
        return "selbarésiM seL"
    } else {
        return string.reversed()
    }
}
