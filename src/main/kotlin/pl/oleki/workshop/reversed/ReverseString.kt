package pl.oleki.workshop.reversed

fun reverse(string: String): String {
    val normalized: String = java.text.Normalizer.normalize(string, java.text.Normalizer.Form.NFKC)
    return normalized.reversed()
}
