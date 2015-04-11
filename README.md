# TwitterLike
## TwitterLike application.

### To help you with the assessment Igor I've commented most of the code, but I'll list the items I covered here also:

1.  Controllers
2.  Views, incl. use of jQuery & AJAX, plus Grails template.
3.  Persistence layer uses GORM & I've played around with the H2 database, postgreSQL locally, and trying to use the Pivotal Web Services ElephantSQL service (PostgreSQL).
4.  **pom.xml** was generated for building from maven.
5.  **war** was generated for single file deploy (**NOTE:** I did this war deploy to PWS using CLI, GGTS dosen't direct deploy for Grails 2.4.4. This took a long time to figure out that it was a known issue **(i.e. days)**. The errors given were not useful.) I even paid for more memory etc.. Just in case that was the issue. It's a known issue.
5.  I populate multiple tables with data for the application. Namely 5 tables. authority, location, person, person_authority, status.
4.  A REST endpoint (JSON & XML)
5.  Marshaller of the REST service, changing fields of the response. Just showing that I looked into this.
6.  Created rendering beans for both rest response as single object & mlutiple/collection (i.e. removing some redundant fields).
6.  I also change the url of the endpoint to a more convention friendly url (regex rules of urls).
6.  Authentication with login & against regex rules of urls (Spring Security Core plugin). You will need these usernames and passwords to login and test the twitter follow functionality:
  - Your details are  **un: igor pw: password**
  - User 2: **un: albert pw: password**
  - User 3: **un: ava pw: password**
7.  I deployed the application successfully to PWS.
8.  A unit test for Status, testing against the Status constraints (uses Spock, Mocks) (This is flaky & needs more work)
9.  Tests for the REST LocationService, testing HTTP status codes (i.e. 200=Ok) and values epected form the JSON/XML data.
10.  Front-end styling (using twitter bootstrap and my own personal styling).
13.  **Transactional management** was demonstrated in LocationService when the JSON location data is requested from the location service REST API. NOTE: This location data was provided from a database that I populate at startup.

## CHALLENGES ENCOUNTERED

As mentioned previously by email (I sent a picture of logs on PWS), there was a number of issues encountered.

**They included, but were not limited to:**

**Jira issue - Tar packaged grails application cannot resolve /index**
https://jira.grails.org/browse/GRAILS-12076

**Problems validating blank constraints with spock in a grails application**
http://stackoverflow.com/questions/19831034/problems-validating-blank-constraints-with-spock-in-a-grails-application

**Codehaus gone, which affected a lot of dependencies (incl. transitive dependencies) & plugins.**
http://www.codehaus.org/

**Not being able to deploy to PWS from GGTS.**
The latest version of GGTS has issues with deploying directly to PWS. The workaround is to deploy the war from the CLI.
I did this successfully. However the Jira issue mentioned above complicated things.
This took a very long time to figure out **(i.e. days)**, the errors given are not useful.

**The latest version fo Grails 3.0.1 does not get recogines by GGTS as a Grails library**
This also took a long time to figure out. I was trying to upgrade Grails to address the many issues encountered.
With Pivotal removal of sponsorship this isn't expected to be addressed in teh future. 

## FINDINGS
Though Groovy the Grails framework are very exciting to learn and work with. I find that there's way too much broken dependencies and churn between versions. The removal of Pivotal sponsorship is seen by some as a bad thing, it's seen by others as a great thing. http://blog.pivotal.io/pivotal/news-2/groovy-2-4-and-grails-3-0-to-be-last-major-releases-under-pivotal-sponsorship
Personally I would not be comfortable developing enterprise software with Grails & Groovy until the issues are overcome.
My experience with it has been mixed. I can see the benefit of convention over configuration on steroids, but the many interdependent technologies require a strong and committed user-base & a big developer mindshare.

Kind regards,

Albert

Mob. 0861523332
