<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head> 
	<body>
	<ul>
		<li>
			<h3>REST Services:</h3>
			<ul>
				<li>
					<c:url value="/rest/contact/listdata" var="restContactListUrl" />
					<a href="${restContactListUrl}">/rest/contact/listdata</a>
				</li>
				<li>
					<c:url value="/rest/contact/1" var="restContactByIdUrl" />
					<a href="${restContactByIdUrl}">/rest/contact/1</a>
				</li>
			</ul>
		</li>
		<li>
			<h3>MVC Services:</h3>
			<ul>
				<li>
					<c:url value="/view/contact/listdata" var="mvcContactListUrl" />
					<a href="${mvcContactListUrl}">/view/contact/listdata</a>
				</li>
				<li>
					<c:url value="/view/contact/listdata?lang=nl_BE" var="mvcContactListUrlNlBe" />
					<a href="${mvcContactListUrlNlBe}">/view/contact/listdata?lang=nl_BE</a>
				</li>
				<li>
					<c:url value="/view/contact/listdata?lang=" var="mvcContactListUrlReset" />
					<a href="${mvcContactListUrlReset}">/view/contact/listdata?lang=</a>
				</li>
				<li>
					<c:url value="/view/contact/listdata?theme=dev_theme" var="mvcContactListUrlDevTheme" />
					<a href="${mvcContactListUrlDevTheme}">/view/contact/listdata?theme=dev_theme</a>
				</li>
				<li>
					<c:url value="/view/contact/listdata?theme=standard_theme" var="mvcContactListUrlStdTheme" />
					<a href="${mvcContactListUrlStdTheme}">/view/contact/listdata?theme=standard_theme</a>
				</li>
			</ul>
		</li>
		<li>
			<h3>Test exposure of static resources:</h3>
			<ul>
				<li>
					<c:url value="/view/resources/test.json" var="staticResourceUrl" />
					<a href="${staticResourceUrl}">/view/resources/test.json</a>
				</li>
			</ul>
		</li>
	</ul>
	</body>
</html>
