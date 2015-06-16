
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title><g:layoutTitle default="Life Tech Products Catalogue" /></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon"
	href="${resource(dir: 'images', file: 'favicon.ico')}"
	type="image/x-icon">
<link rel="apple-touch-icon"
	href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
<link rel="apple-touch-icon" sizes="114x114"
	href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">

<link rel="stylesheet"
	href="${resource(dir: 'css', file: 'default.css')}" type="text/css">

<g:layoutHead />
<r:layoutResources />
</head>
<body>

	<div id="loginBox" class="loginBox">
		<div style="margin-top: 20px">
			<div style="float: right;">
				<sec:ifLoggedIn>
					<div id="login">User: <sec:username /></div>
					<div>
					<sec:ifAllGranted roles="ROLE_ADMIN">
						<g:link controller="user">Admin Users</g:link>
					</sec:ifAllGranted>
					</div>
					<form name="submitForm" method="POST"
						action="${createLink(controller: 'logout')}">
						<input type="hidden" name="" value=""> <a
							HREF="javascript:document.submitForm.submit()">Logout</a>
					</form>
				</sec:ifLoggedIn>
				<sec:ifNotLoggedIn>
					<g:link controller='login' action='auth'>Login</g:link>
				</sec:ifNotLoggedIn>

			</div>
		</div>
	</div>
	<div id="searchbox">
		<g:form action="list" name="search" method="GET">
		Search: <g:textField name="query" value="${query}" />
			<g:link action="list" params="${[query:""]}">Clear</g:link>
		</g:form>
	</div>

	<sec:ifAllGranted roles="ROLE_PRICE">
	<h1>
		<g:link controller="quote">Create a Quote</g:link>
	</h1>	
	</sec:ifAllGranted>

	<g:layoutBody />
	<g:javascript library="application" />
	<r:layoutResources />
</body>

</html>
