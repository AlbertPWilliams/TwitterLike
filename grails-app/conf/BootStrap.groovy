import org.cit.twitterlike.*
import grails.util.Environment

class BootStrap {

    def init = { servletContext ->
		grails.util.Environment.executeForCurrentEnvironment {
			development {
				log.info 'Development'
				if (!Person.count()) {
					createUsersData()
					createLocationData()
				}
			}
			production {
				log.info 'Production mode.'
				if (!Person.count()) {
					createUsersData()
					createLocationData()
				}
			}
			test {
				log.info 'Test mode.'
				if (!Person.count()) {
					createUsersData()
					createLocationData()
				}
			}
			mock {
				log.info 'Custom "mock" mode.'
				if (!Person.count()) {
					createUsersData()
					createLocationData()
				}
			}
		}
    }
		
    def destroy = {
		log.info "Shutting down."
    }
	
	// Creating the users and their details.
	// These will be used to authenticate access.
	private void createUsersData() {
		// Create an authority class for default user.
		def userRole = Authority.findByAuthority("ROLE_USER") ?: new Authority(authority: "ROLE_USER").save()
 
		// Default password for all users.
		String password = 'password'
 
		// Set the user data for authorisation.
		[igor: 'Igor Mihalik', albert: 'Albert Williams', ava: 'Ava Williams'].each { userName, realName ->
			def user = new Person(username: userName, realName: realName, password: password, enabled: true).save()
			PersonAuthority.create user, userRole, true
		}
	}
	
	// Creating a separate rest service that will provide the location of the users.
	// This location will get added to their status posts (i.e. tweets).
	// The pretend expectation is that this rest service is being provided by a third party, e.g. Google maps.
	private void createLocationData() {
		def location = null
		log.info "Start loading cities into database"
		location = new Location(cityName: 'Cork', postalCode: "90210", countryCode: 'IR')
		assert location.save(failOnError:true, flush:true, insert: true)
		location.errors = null
 
		location = new Location(cityName: 'Cork', postalCode: "12345", countryCode: 'IR')
		assert location.save(failOnError:true, flush:true, insert: true)
		location.errors = null
		
		location = new Location(cityName: 'Dublin', postalCode: "54321", countryCode: 'IR')
		assert location.save(failOnError:true, flush:true, insert: true)
		location.errors = null
		
		assert Location.count == 3;	// Assertion test against Location objects saved.
		log.info "Finished loading $Location.count locations into database"
	}
}