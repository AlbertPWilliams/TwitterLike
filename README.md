# TwitterLike
## TwitterLike application.

### To help you with the assessment Igor I'll list the items this includes:

1.  Controllers
2.  Views, incl. use of jQuery & AJAX, plus Grails template.
3.  Presistance layer uses GORM & I've played around with the H2 database, postgreSQL locally, and trying to use the Pivotal Web Services ElephantSQL service (PostgreSQL).
4.  I populate multiple tables with data for the application. Namely 5 tables. authority, location, person, person_authority, status.
4.  A REST endpoint
5.  Marshaller of the REST service
6.  I change the url of the endpoint to a more convention friendly url.
6.  Authentication with login. You will need these usernames and passwords to login and test the twitter follow functionality:
  - Your details are un: igor pw: password
  - User 2: un: albert pw: password
  - User 3: un: ava pw: password
7.  I deployed the application to PWS, but had issues. These issues seem to be common & may require me to use older versions of Tomcat & Grails.
8.  A unit test for Status (using Mocks) (This is flakey & needs more work)
9.  A unit test for the REST LocationService (This is flakey & needs more work)
10.  TODO Externalise strings into .properties, I started to do this.
11.  TODO Better logging (log4j). I started to look at this also.
12.  TODO Better frontend (using twitter bootstrap for styling).

My immediate focus will be fimding out the issues with deploying si=uccessfully on PWS.

I sent a picture of the logs in a previous email, any help appreciated. But I know you are very busy.

I'll research (i.e. google) the problem.

Kind regards,

Albert
