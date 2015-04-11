package org.cit.twitterlike

import grails.test.mixin.TestFor
import spock.lang.Specification
import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse
//import groovyx.net.http.RESTClient


import org.apache.commons.httpclient.*
import org.apache.commons.httpclient.methods.*
import org.springframework.http.HttpStatus

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

	void "test successful GET response status" () {
		when:
		def resp = service.getLocation(2)

		then:
		resp.status == HttpStatus.OK.value
	}
		
	// Testing the REST service.
	// TODO Multiple ongoing changes & issues with Grails in regards to Rest plugin and also default rest testing. Especially related to the version of Grails here, i.e. 2.4.4
    void "test rest GET city"() {
		given:
		String requestURL = "http://localhost:8080/TwitterLike/api/location/1"
		RestBuilder rest = new RestBuilder()
//		RESTClient restClient = new RESTClient("http://localhost:8080/TwitterLike/api/")
		
		when:
//		RestResponse response = rest.get("http://localhost:8080/TwitterLike/api/location/1") {
//			// Need to set the accept content-type to JSON, otherwise it defaults to String
//			// and the API will throw a 415 'unsupported media type' error.
//			accept JSON
//		}
		RestResponse response = rest.get(requestURL)
//		def response = restClient.get(path: "location/1")
		
		then:
		assert response.status == HttpStatus.OK.value
		assert response.json.city == "Cork"
//		assert response.status == 200
//		assert response.data.city == "Cork"
    }
}

