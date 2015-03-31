package org.cit.twitterlike

import grails.rest.RestfulController

class LocationController extends RestfulController {
	// TODO With these I can provide content negotiation between json & xml.
    static responseFormats = ['json', 'xml']
    LocationController() {
        super(Location)
    }
}
