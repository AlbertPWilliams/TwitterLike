package org.cit.twitterlike

import grails.plugins.rest.client.RestBuilder
import grails.transaction.Transactional

@Transactional
class LocationService {

    def serviceMethod() {
    }
	
	def getLocation(Long id) {
		String url = "http://localhost:8080/TwitterLike/api/location/$id"
		def resp = new RestBuilder().get(url) {
			header 'Authorization', 'Basic base64EncodedUsername&Password'
		}
		resp
	}
}
