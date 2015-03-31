// Place your Spring DSL code here
import grails.rest.render.xml.*;
import grails.rest.render.json.*;
import org.cit.twitterlike.Location;
import org.cit.twitterlike.util.*;

// Exclude some properties (class & dateCreated) from the rendered response.
beans = {
	
	// Bean for single object rendering.
	// Typical use of curl:
	// JSON:
	// 		curl -X GET -H "Accept:application/json" http://localhost:8080/TwitterLike/api/location/1
	// XML:
	//		curl -X GET -H "Accept:application/xml" http://localhost:8080/TwitterLike/api/location/1
	locationXmlRenderer(XmlRenderer, Location) {
		excludes = ['class', 'dateCreated']
	}
	locationJSONRenderer(JsonRenderer, Location) {
		excludes = ['class', 'dateCreated']
	}
	
	// Bean for collection rendering.
	// This handles implementing the exclusions when the number isn't given, i.e.:
	// JSON:
	// 		curl -X GET -H "Accept:application/json" http://localhost:8080/TwitterLike/api/location
	// XML:
	//		curl -X GET -H "Accept:application/xml" http://localhost:8080/TwitterLike/api/location
	locationXmlCollectionRenderer(XmlCollectionRenderer, Location) {
		excludes = ['class', 'dateCreated']
	}
	locationJSONCollectionRenderer(JsonCollectionRenderer, Location) {
		excludes = ['class', 'dateCreated']
	}
	
	// The custom object marshaller as spring bean.
	locationMarshallerRegistrar(LocationMarshaller) {
		
	}
}