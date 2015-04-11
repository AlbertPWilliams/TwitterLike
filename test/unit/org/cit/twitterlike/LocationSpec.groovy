package org.cit.twitterlike

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Location)
class LocationSpec extends ConstraintUnitSpec {

    def setup() {
		mockForConstraintsTests(Location) // This will create the validate method.
    }

    def cleanup() {
    }

	void "test postalCode blank constraints"() {
		when: "the postalCode is not allowed to be blank"
		def l = new Location(postalCode: '')
		
		then: 'validation should fail'
		!l.validate()
	}
	
	void "test postalCode null constraints"() {
		when: "the postalCode is not allowed to be null"
		def l = new Location(postalCode: null)
		
		then: 'validation should fail'
		!l.validate()
	}
	
	void "test cityName blank constraints"() {
		when: "the cityName is not allowed to be blank"
		def l = new Location(cityName: '')
		
		then: 'validation should fail'
		!l.validate()
	}
	
	void "test cityName null constraints"() {
		when: "the cityName is not allowed to be null"
		def l = new Location(cityName: null)
		
		then: 'validation should fail'
		!l.validate()
	}
	
	void "test countryCode blank constraints"() {
		when: "the countryCode is not allowed to be blank"
		def l = new Location(countryCode: '')
		
		then: 'validation should fail'
		!l.validate()
	}
	
	void "test countryCode null constraints"() {
		when: "the countryCode is not allowed to be null"
		def l = new Location(countryCode: null)
		
		then: 'validation should fail'
		!l.validate()
	}
	
	void "test countryCode max size constraints"() {
		when: "the countryCode is not allowed to be less than 2 characters in length"
		def l = new Location(countryCode: "A")
		
		then: 'validation should fail'
		!l.validate()
	}
	
	void "test countryCode min size constraints"() {
		when: "the countryCode is not allowed to be more than 3 characters in length"
		def l = new Location(countryCode: "ABCD")
		
		then: 'validation should fail'
		!l.validate()
	}
	
	void "test countryCode matches uppercase constraints"() {
		when: "the countryCode is not allowed to have characters other than capital alphabetic letters"
		def l = new Location(countryCode: "asd")
		
		then: 'validation should fail'
		!l.validate()
	}
	
	void "test countryCode matches alphabetic constraints"() {
		when: "the countryCode is not allowed to have characters other than capital alphabetic letters"
		def l = new Location(countryCode: "123")
		
		then: 'validation should fail'
		!l.validate()
	}


	@Unroll("test location multiple constraints #field is #error")
	def "test multiple location constraints"() {
		given:
		
		when: "Location object is created with different attributes"
		def obj = new Location("$field": val) // These two variables get the where values
	
		then:
		validateConstraints(obj, field, error)
	
		where:
		// These will test false and true tests.
		// Using the value in the error column of ‘valid’ or a null will expect the field to pass validation.
		error				   | field        	| val
		'valid'                | 'postalCode' 	| getLongString(1)
		'valid'                | 'postalCode' 	| getLongString(200)
		'valid'                | 'cityName'   	| 'Waterford'
		'valid'                | 'countryCode'  | 'USA'
		'valid'                | 'countryCode' 	| 'UK'
	}
	
	private createLocation(Integer count) {
		def locations = []
		count.times {
			locations << new Location()
		}
		locations
	}
}