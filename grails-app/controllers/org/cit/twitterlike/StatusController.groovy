package org.cit.twitterlike

import grails.plugin.springsecurity.annotation.Secured


@Secured('IS_AUTHENTICATED_FULLY') // Secure this controller with spring security IS_AUTHENTICATED_FULLY rule.
								   // With this rule, even if users checked “remember me” last time, they still need to login.

class StatusController {

	// Dependency inject (DI) required services.
	LocationService locationService
	def springSecurityService
 
	// Controller method for index page.
    def index() {
        def msgs = currentUserTimeline()	// Get all this users messages & messages of anyone they are following.
		def pers = lookupPersons();			// Get all users. Used to list potential people to follow.
        return [messages: msgs, pers: pers] // this is a map. key=>value, now available in view.
    }
	
	// Allow for other following users.
	def follow = {
		def per = Person.get(params.id) // Get id from URL (GET).
		if(per) { 						// If it is a person.
			def currentUser = lookupPerson() // Get current user.
			currentUser.addToFollowed(per)	 // For user to follow, add them to current users followed list.
		}
		redirect action: 'index' // Redirect to index page.
	}
 
	// Update the status of the current user.
    def updateStatus = {
		
        def status = new Status(message: params.message+lastKnownLocation()) // GET the message & append the get the last known location (REST service)
        status.author = lookupPerson()					 // Current user is author.
        status.save()									 // Save object with current properties.
        def messages = currentUserTimeline()			 // Get the messages for current user.
		
        render template: 'messages', collection: messages, var: 'message' // Render messages in _messages.gsp template.
    }
 
	// Get last known location details from the REST location service.
	private lastKnownLocation() {
		def locationJson = locationService.getLocation(springSecurityService.principal.id).json
		" [Last known location was ${locationJson.city}, ${locationJson.countryCode} at ${locationJson.lastUpdate}]"
	}
	
	// Get current user.
    private lookupPerson() {
        Person.get(springSecurityService.principal.id)
    }
	
	// Get all users. Used for listing possible users to follow.
	private lookupPersons() {
		Person.getAll()
	}
 
	// Get all messages that are in messages and were written by the current user
	// OR where a user is in their followed list.
    private currentUserTimeline() {
        def per = lookupPerson()
		def messages = Status.withCriteria {
			or {
				author {
					eq 'username', per.username
				}
				if (per.followedList) {
					inList 'author', per.followedList
				}
			}
			maxResults 10				// 10 messages max
			order 'dateCreated', 'desc' // Order descending by date created
		}
    }
}
