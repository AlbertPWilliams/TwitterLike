package org.cit.twitterlike

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification
import grails.test.mixin.TestFor
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Status)
@TestMixin(GrailsUnitTestMixin)
class StatusSpec extends ConstraintUnitSpec {

    def setup() {
		mockForConstraintsTests(Status) // This will create the validate method.
    }
		
    def cleanup() {
    }
	
	void "test message size max constraints"() {
		when: "the message is not allowed to be over 140 characters in length"
		def s = new Status(message: 'a' * 150)
		
		then: 'validation should fail'
		!s.validate()
	}

	void "test message size min constraints"() {
		when: "the message is not allowed to be less than 1 character in length"
		def s = new Status(message: 'a')
		
		then: 'validation should fail'
		!s.validate()
	}
	
	@Unroll("test status multiple constraints #field is #error")
	def "test multiple status constraints"() {
		given:
		
		when: "Status object is created with different messages"
		def obj = new Status("$field": val) // These two variables get the where values 
	
		then:
		validateConstraints(obj, field, error)
	
		where:
		// These will test false and true tests.
		// Using the value in the error column of ‘valid’ or a null will expect the field to pass validation.
		error				   | field        | val
		'valid'                | 'message'    | getLongString(1)
		'valid'                | 'message'    | getLongString(140)
		'valid'                | 'message'    | '0123456789AaBaCcDdEe'
		'size'                 | 'message'    | getLongString(160)
	}
	
	private createStatus(Integer count) {
		def statuses = []
		count.times {
			statuses << new Status()
		}
		statuses
	}
}
