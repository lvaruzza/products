<html>

<head>
<meta name="layout" content="default">

</head>


<body>
	<div id="formHolder">

		<g:uploadForm action="upload" name="uploadForm">



			<div class="mdl-grid">
				<div class="mdl-cell mdl-cell--1-col">List Type</div>
				<div class="mdl-cell mdl-cell--4-col">
					<input type="radio" name="type" value="general" checked />General
					List <input type="radio" name="type" value="platics" />Platics LPG
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