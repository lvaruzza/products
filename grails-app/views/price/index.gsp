<html>

<head>
<g:javascript library="jquery" plugin="jquery" />

<link rel="stylesheet"
	href="https://storage.googleapis.com/code.getmdl.io/1.0.0/material.indigo-pink.min.css">
<script
	src="https://storage.googleapis.com/code.getmdl.io/1.0.0/material.min.js"></script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:300,400,500,700"
	type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>


</head>


<body>
	<div class="mdl-layout mdl-js-layout mdl-layout--overlay-drawer-button">
		<header class="mdl-layout__header">
			<div class="mdl-layout-icon"></div>
			<div class="mdl-layout__header-row">
				<span class="mdl-layout-title">Price Uploader</span>
				<div class="mdl-layout-spacer"></div>
				<!--       <nav class="mdl-navigation">
        <a class="mdl-navigation__link" href="#">Nav link 1</a>
        <a class="mdl-navigation__link" href="#">Nav link 2</a>
        <a class="mdl-navigation__link" href="#">Nav link 3</a>
      </nav>
  -->
			</div>
		</header>
		<main class="mdl-layout__content"style:"margin-top:4ex; margin-left:5em">

		<g:if test="${flash.message}">
			<div class="message" style="display: block">
				${flash.message}
			</div>
		</g:if>

		<div id="formHolder">

			<g:uploadForm action="upload" name="uploadForm">



				<div class="mdl-grid">
					<div class="mdl-cell mdl-cell--1-col">List Type</div>
					<div class="mdl-cell mdl-cell--4-col">
						<input type="radio" name="type" value="general" checked />General
						List <input type="radio" name="type" value="platics" />Platics
						LPG 
<!-- 						
						<input type="radio" name="type" value="nanodrop" />Nanodrop
 -->						
					</div>
				</div>

				<div class="mdl-grid">
					<div class="mdl-cell mdl-cell--1-col">File</div>
					<div class="mdl-cell mdl-cell--2-col">
						<input type="file" name="file" />
					</div>

				</div>

				<div class="mdl-grid">
					<div class="mdl-cell mdl-cell--1-col"></div>
					<div class="mdl-cell mdl-cell--2-col">
						<button id="submit" onclick="submitClick()"
							class="mdl-button mdl-js-button mdl-button--primary">
							Submit</button>
					</div>
				</div>
			</g:uploadForm>
		</div>
		<div id="spinnerHolder"
			style="margin: auto; margin-top: 5ex; width: 60%;">
			<div class="mdl-spinner mdl-spinner--single-color mdl-js-spinner"
				id="form_spinner"></div>
			<span style="vertical-align: text-center; margin-left: 2em">
				Loading Prices. </span> <span id="curSKU"></span>
		</div>
		</main>
	</div>

	<script>
		$(function() {
			$('#spinnerHolder').hide();
		})

		function submitClick() {
			console.log("submit");
			console.log($('#form_spinner').attr('class'));
			$('#formHolder').hide();
			$('#spinnerHolder').show();
			$('#form_spinner').addClass('is-active');
			console.log($('#form_spinner').attr('class'));
			$('#uploadForm').submit();
			setInterval(function() {
				$.ajax({
					url : '${createLink(action:"progress")}',
					success : function(result) {
						$("#curSKU").text(" SKU: " + result);
					}
				});
			}, 1000);
		}
	</script>

</body>

</html>