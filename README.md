# TwitterLike
## TwitterLike application.

### To help you with the assessment Igor I've commented most of the code, but I'll list the items I covered here also:

1.  Controllers
2.  Views, incl. use of jQuery & AJAX, plus Grails template.
3.  Persistence layer uses GORM & I've played around with the H2 database, postgreSQL locally, and trying to use the Pivotal Web Services ElephantSQL service (PostgreSQL).
4.  pom.xml was generated for building from maven.
5.  war was generated for single file deploy.
5.  I populate multiple tables with data for the application. Namely 5 tables. authority, location, person, person_authority, status.
4.  A REST endpoint (JSON & XML)
5.  Marshaller of the REST service, changing fields of the response. Just showing that I looked into this.
6.  Created rendering beans for both rest response as single object & mlutiple/collection (i.e. removing some redundant fields).
6.  I also change the url of the endpoint to a more convention friendly url (regex rules of urls).
6.  Authentication with login & against regex rules of urls (Spring Security Core plugin). You will need these usernames and passwords to login and test the twitter follow functionality:
  - Your details are  **un: igor pw: password**
  - User 2: **un: albert pw: password**
  - User 3: **un: ava pw: password**
7.  I deployed the application to PWS, but had issues. These issues seem to be common & may require me to use older versions of Tomcat & Grails.
8.  A unit test for Status, testing against the Status constraints (uses Spock, Mocks) (This is flaky & needs more work)
9.  A unit test for the REST LocationService (This is flaky & needs more work)
10.  TODO Externalise strings into .properties, I started to do this.
11.  TODO Better logging (log4j). I started to look at this also.
12.  TODO Better frontend (using twitter bootstrap for styling).
13.  TODO I was thinking of trying to use OpenAuth.
14.  TODO More Unit testing & Stubs & Mocks.

**My immediate focus will be finding out the issues with deploying successfully on PWS.**

I sent a picture of the logs in a previous email, any help appreciated. But I know you are very busy.

I'll research (i.e. google) the problem.

Kind regards,

Albert

Mob. 0861523332
