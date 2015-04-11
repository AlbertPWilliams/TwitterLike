package org.cit.twitterlike

import spock.lang.Specification

abstract class ConstraintUnitSpec extends Specification {
	String getLongString(Integer length) {
		'a' * length
	}
 
//	String getEmail(Boolean valid) {
//		valid ? "albertwilliams@gmail.com" : "igorm@pivotal"
//	}
// 
//	String getUrl(Boolean valid) {
//		valid ? "http://www.google.com" : "http:/ww.badurl.com"
//	}
// 
//	String getCreditCard(Boolean valid) {
//		valid ? "4111111111111111" : "41014"
//	}
 
	// Checks for the error message to exist on a field after the validate is called.
	void validateConstraints(obj, field, error) {
		def validated = obj.validate()
		if (error && error != 'valid') { // Using the value in the error column of ‘valid’ or a null will expect the field to pass validation.
			assert !validated
			assert obj.errors[field]
			assert error == obj.errors[field]
		} else {
			assert !obj.errors[field]
		}
	}
}
