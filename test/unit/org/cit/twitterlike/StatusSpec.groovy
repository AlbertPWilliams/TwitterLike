package org.cit.twitterlike

import java.util.Date;

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Status)
//@Mock([ Status ])
class StatusSpec extends Specification {

    def setup() {
		mockForConstraintsTests(Status) // This will create the validate method.
    }
		
    def cleanup() {
    }

    void "test that status message is long enough"() {
		given:
		//Person person = Mock();
		Status status = Mock();
		
		when:
		status.messsage = ""
		
		then:
		assertFalse ("The message was invlaid as expected because it's empty", status.validate())
			
    }
}
