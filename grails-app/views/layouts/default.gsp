
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


<g:javascript library="jquery" plugin="jquery" />

<link rel="stylesheet"
	href="https://storage.googleapis.com/code.getmdl.io/1.0.0/material.deep_orange-red.min.css" />

<script
	src="https://storage.googleapis.com/code.getmdl.io/1.0.0/material.min.js"></script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:300,400,500,700"
	type="text/css">


<style>
</style>

<g:layoutHead />
<r:layoutResources />
</head>
<body>

	<div class="mdl-layout mdl-js-layout mdl-layout--overlay-drawer-button">
		<header class="mdl-layout__header">
			<div class="mdl-layout-icon"></div>
			<div class="mdl-layout__header-row">
				<span class="mdl-layout-title">Orange</span>
				<div class="mdl-layout-spacer"></div>
				<nav class="mdl-navigation">
					<sec:ifNotLoggedIn>
						<g:link class="mdl-navigation__link" controller='login'
							action='auth'>Login</g:link>
					</sec:ifNotLoggedIn>


					<sec:ifLoggedIn>
						<sec:ifAllGranted roles="ROLE_ADMIN">
							<g:link class="mdl-navigation__link" controller="user">Admin Users</g:link>
						</sec:ifAllGranted>
						<span id="login"> User: <sec:username />
						</span>
						<g:link class="mdl-navigation__link" controller='login'
							action='logout'>Logout</g:link>
					</sec:ifLoggedIn>


				</nav>
			</div>
		</header>
		<main class="mdl-layout__content"style:"margin-top:4ex; margin-left:5em">
		<div class="page-content">
			<g:layoutBody />
		</div>
		</main>
	</div>
	<g:javascript library="application" />
	<r:layoutResources />

</body>

</html>
