# SpringWSTest

## What

Spring mvc application with both rest and mvc controllers

## 'Architecture'

Spring application with 2 dispatcher servlets:
 * restDispatcherSerlet: dispatches all /rest/* requests
  * config : *mvc-rest-config.xml*
 * viewDispatcherSerlet: dispatches all /view/* requests
  * config : *mvc-view-config.xml*
 * tilesDispatcherSerlet: dispatches all /tiles/* requests
  * config : *mvc-tiles-config.xml*

## Security
Some basic http security is present from wayback for the restfull  urls.
**TODO:** Must be completely redone

## Validation
Todo Describe (jsr 303 annotations on entity and controller operations)

## I18n
In some bullet points:
* property files are created per "locale" in for instance WEB-INF/i18n:
 * application.properties / application_nl_BE.properties/ application_fr_FR.properties /...
 * messages.properties / messages_nl_BE.properties/ messages_fr_FR.properties /...


* there is some config in the dispatcher servlet config

 * beans:

    * *org.springframework.context.support.ReloadableResourceBundleMessageSource* --> this one has a param which points to the property files: `p:basenames="WEB-INF/i18n/messages,WEB-INF/i18n/application"`
    * *org.springframework.web.servlet.i18n.CookieLocaleResolver*

 * interceptor
    * *org.springframework.web.servlet.i18n.LocaleChangeInterceptor*    

# Theming
In some bullet points:
* property files are created in WEB-INF/classes:
  * standard_theme.properties for instance `styleSheet=view/resources/styles/standard.css`
  * dev_theme.properties
* there is some config in the dispatcher servlet config
 * beans:

    * *org.springframework.ui.context.support.ResourceBundleThemeSource* (reads the properties as messageSource)
    * *org.springframework.web.servlet.theme.CookieThemeResolver*

 * interceptor

  * *org.springframework.web.servlet.theme.ThemeChangeInterceptor*

* in view (jspx)
  * the messagesource is used to resolve the name of the stylesheet to use `<spring:theme code="styleSheet" var="app_css" />`

## Views
* view/*
 * uses `InternalResourceViewResolver`

* tiles/*
 * uses view `UrlBasedViewResolver` with the `TilesView` as viewClass

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

### Test Rest services using _Curl_
 * when running on tomcat or you chose `run on server`
```shell
$ curl -u remote:remote -v -H "Accept: application/xml" http://localhost:8080/springMVC/rest/contact/listdata
```
```shell
$ curl -u remote:remote -v -H "Accept: application/json" http://localhost:8080/springMVC/rest/contact/listdata
```

 * when runnin on jetty via maven the context root is not mentioned in the url:
```shell
$ curl -u remote:remote -v -H "Accept: application/xml" http://localhost:8080/rest/contact/listdata
```
```shell
$ curl -u remote:remote -v -H "Accept: application/json" http://localhost:8080/rest/contact/listdata
```

### Test rest services using Springs _Resttemplate_
* just run the maven test:
```shell
$	mvn test
```
  _(restart server for each tests, since delete occurs in db ...)_

### Test the view
Go to following page and you'll get an overview of the availabl endpoints:
* http://localhost:8080/index.jsp
No automated test yet.  


### Known issues (todos?)
 * When the webapp is run as a contextroot for instance tomcat uses name of the war as default contextroot then the security related urls don't all work (they are not all relatively resolved it seems)
 * ...
