class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
		
		"/" {
			controller = "yourController"
			action = "yourAction"
		 }

        //"/"(view:"/index")
		"/" ( controller:'Status', action:'index' ) // The default controller and action (i.e. this will be the default page).
        "500"(view:'/error')
		
		// RESTService api better URL convention.
		"/api/location"(resources: 'location')
	}
}