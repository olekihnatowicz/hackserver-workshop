package pl.oleki.workshop.hostname

import spock.lang.Specification

class HostnameSpec extends Specification {

    def "should return hostname"() {
        expect:
            HostnameEndpoint.getHost("https://some_host.org") == "some_host.org"
    }
}
