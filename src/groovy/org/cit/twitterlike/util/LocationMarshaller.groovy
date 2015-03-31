package org.cit.twitterlike.util;

import grails.converters.*;
import org.cit.twitterlike.Location;

// To demonstrate how to would customise the REST response.
class LocationMarshaller {
    @javax.annotation.PostConstruct
    void register() {
    	//log "info" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
        log.info "Registering Location Marshaller ..."
        JSON.registerObjectMarshaller (Location) { Location location ->
            def output = [:]
            output['city'] = location.cityName
            output['countryCode'] = location.countryCode
            output['lastUpdate'] = location.dateCreated.format('dd MMM yyyy HH:mm:ss')
            return output;
        }
        log.info "Finished registering Location Marshaller!"
    }
}