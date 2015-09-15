<html>

<head>
<meta name="layout" content="default">
</head>

<body>


	<div class="mdl-card mdl-shadow--2dp demo-card-wide">
		<div class="mdl-card__title">
			<h2 class="mdl-card__title-text">Export Data</h2>
		</div>
		<div class="mdl-card__supporting-text">
			<p>Export Products Database in XML.</p>
		</div>
		<div class="mdl-card__actions mdl-card--border">
			<div id="formHolder">
				<a href="#" onclick="submitClick()"
					class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
					Export</a>
			</div>
			<div id="spinnerHolder"
				style="margin: auto; margin-top: 5ex; width: 60%;">
				<div class="mdl-spinner mdl-spinner--single-color mdl-js-spinner"
					id="form_spinner"></div>
			</div>


		</div>



	</div>
	<script>
		$(function() {
			$('#spinnerHolder').hide();
		})

		function submitClick() {
			$('#formHolder').hide();
			$('#spinnerHolder').show();
			$('#form_spinner').addClass('is-active');
			console.log($('#form_spinner').attr('class'));
			$.ajax({
					url : '${createLink(action:"products_xml")}',
					success : function(result) {
							console.log("Download Link created")
							$('#form_spinner').removeClass('is-active');
							$('#formHolder').show();
							$('#spinnerHolder').hide();
						 	window.location = '${createLink(action:"products_xml")}';
						}
					});
		}
	</script>

</body>

</html>