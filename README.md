SpringRestfullWSTest
====================
Spring restfull service. supporting xml and json return values.

How to use
==========
* Start server: 
 * `run as > run on server` -> this did not always seem to work (spring sts exited every time I started the server)
 * I added the **maven jetty plugin** and now you can run:
	`mvn jetty:run`  to run the app under jetty server

* Test using **curl**
 * when running on tomcat or you chose `run on server`
	`curl -u remote:remote -v -H "Accept: application/xml" http://localhost:8080/SpringRestfullWSTest/contact/listdata`
	`curl -u remote:remote 	-v -H "Accept: application/json" http://localhost:8080/SpringRestfullWSTest/contact/listdata`
 * when runnin on jetty via maven the context root is not mentioned in the url:
	`curl -u remote:remote -v -H "Accept: application/xml" http://localhost:8080/contact/listdata`
	`curl -u remote:remote 	-v -H "Accept: application/json" http://localhost:8080/contact/listdata`

* Test using **Spring Resttemplate** (restart server for each tests, since delete occurs in db ...)
	`mvn test`