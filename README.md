# SpringWSTest

## What

Spring mvc application with both rest and mvc controllers

## 'Architecture'

Spring applicationwith 2 dispatcher servlets:
 * restDispatcherSerlet: dispatches all /rest/* requests
  * config : *mvc-rest-config.xml*
 * viewDispatcherSerlet: dispatches all /view/* requests
  * config : *mvc-view-config.xml*

## Security
Some basic http security is present from wayback for the restfull  urls.
**TODO:** Must be completely redone

## Views
Currently using .jsp. Should convert to .jspx but had error parsing when a just changed the extension.
Did not had time ... need to modify content so it adheres to xml standards...

## How to 'use'

### DB
Currently an embedded db is used with two scripts:
* DDL.sql : create required tables
* DML.sql : add some data for the test

--> **TODO** *this is fine for now, but should eventually move to the test config, and make place for 'production' db*

### Start server
 * `run as > run on server` -> this did not always seem to work (spring sts exited every time I started the server)

 * I added the **maven jetty plugin** and now you can can start the app in the jetty webserver with the following maven command:
 ```shell
$ mvn jetty:run
```
*hint: if you prefer starting the server from within Eclipse you can specify a run configuration in Eclipse for this ....*

### Test using _Curl_
 * when running on tomcat or you chose `run on server`
```shell
$ curl -u remote:remote -v -H "Accept: application/xml" http://localhost:8080/SpringRestfullWSTest/contact/listdata
```
```shell
$ curl -u remote:remote -v -H "Accept: application/json" http://localhost:8080/SpringRestfullWSTest/contact/listdata
```
 * when runnin on jetty via maven the context root is not mentioned in the url:
```shell
$ curl -u remote:remote -v -H "Accept: application/xml" http://localhost:8080/contact/listdata
```
```shell
$ curl -u remote:remote -v -H "Accept: application/json" http://localhost:8080/contact/listdata  
```

### Test restfull services using Springs _Resttemplate_
* just run the maven test:
```shell
$	mvn test
```
  _(restart server for each tests, since delete occurs in db ...)_
