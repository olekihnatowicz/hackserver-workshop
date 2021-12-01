package pl.oleki.workshop.rotcipher

import spock.lang.Specification

class RotCipherSpec extends Specification {

    def "should decrypt"() {
        expect:
            RotCipherEndpoint.decryptString(string) == result
        where:
            string || result
        "mnqnavr cvrejfmr mebovbar cbcenjavr" || "zadanie pierwsze zrobione poprawnie"
    }
}
