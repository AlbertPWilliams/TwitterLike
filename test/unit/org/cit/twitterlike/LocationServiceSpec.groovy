package org.cit.twitterlike

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(LocationService)
class LocationServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

	// Testing the REST service.
    void "test get city"() {
		when:
		def resp = service.city('Cork')

		then:
		resp.status == HttpStatus.OK.value
    }
}
