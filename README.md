# SpringRestfullWSTest

Spring restfull service. supporting xml and json return values.

## How to use

### Start server
 * `run as > run on server` -> this did not always seem to work (spring sts exited every time I started the server)

 * I added the **maven jetty plugin** and now you can can start the app in the jetty webserver with the following maven command:
 ```shell
$ mvn jetty:run
```

### Test using **curl**
 * when running on tomcat or you chose `run on server`
 
 ```shell
$ curl -u remote:remote -v -H "Accept: application/xml" http://localhost:8080/SpringRestfullWSTest/contact/listdata
```
```shell
$ curl -u remote:remote 	-v -H "Accept: application/json" http://localhost:8080/SpringRestfullWSTest/contact/listdata
```
 * when runnin on jetty via maven the context root is not mentioned in the url:
```shell
$ curl -u remote:remote -v -H "Accept: application/xml" http://localhost:8080/contact/listdata
```
```shell
$ curl -u remote:remote 	-v -H "Accept: application/json" http://localhost:8080/contact/listdata  
```

### Test using Spring Resttemplate
* just run the maven test:
```shell
$	mvn test
```
  _(restart server for each tests, since delete occurs in db ...)_
