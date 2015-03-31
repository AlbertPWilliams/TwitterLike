package org.cit.twitterlike

class Status {

	String message 		// Twitter message
	Person author		// User writing twitter message
	Date dateCreated

    static constraints = {
		message size:1..140, blank:false	// Message needs to be < 140 chars & not blank.
	}
}
