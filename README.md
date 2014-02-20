SpringRestfullWSTest
====================
Spring restfull service. supporting xml and json return values.

How to use
==========
Start server: 
	run as > run on server
Test using curl:
	curl -v -H "Accept: application/xml" http://localhost:8080/SpringRestfullWSTest/contact/listdata
	curl -v -H "Accept: application/json" http://localhost:8080/SpringRestfullWSTest/contact/listdata
Test spring rest client using resttemplate (restart server for each tests, since delete occurs in db ...)
	mvn test


