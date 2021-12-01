package pl.oleki.workshop.reversed

import spock.lang.Specification

class ReverseStringSpec extends Specification {

    def "should reverse string"() {
        expect:
            ReverseStringKt.reverse(string) == reversed
        where:
            string               || reversed
            "developer"          || "repoleved"
            "no lemon, on melon" || "nolem no ,nomel on"
            "Les Misérables"    || "selbarésiM seL"
    }
}
