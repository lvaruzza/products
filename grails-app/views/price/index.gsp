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

<script lang="javascript">
function uploadFiles(event)
{
    event.stopPropagation(); // Stop stuff happening
    event.preventDefault(); // Totally stop stuff happening

	$('uploadFormDiv').hide()
	
    // START A LOADING SPINNER HERE

    // Create a formdata object and add the files
    var data = new FormData();
    $.each(files, function(key, value)
    {
        data.append(key, value);
    });

    $.ajax({
        url: '${createLink(action: 'upload',controller:'price')}',
        type: 'POST',
        data: data,
        cache: false,
        dataType: 'json',
        processData: false, // Don't process the files
        contentType: false, // Set content type to false as jQuery will tell the server its a query string request
        success: function(data, textStatus, jqXHR)
        {
            if(typeof data.error === 'undefined')
            {
                // Success so call function to process the form
                submitForm(event, data);
            }
            else
            {
                // Handle errors here
                console.log('ERRORS: ' + data.error);
            }
        },
        error: function(jqXHR, textStatus, errorThrown)
        {
            // Handle errors here
            console.log('ERRORS: ' + textStatus);
            // STOP LOADING SPINNER
        }
    });
}
</script>

<body>


	<h1>Price List Upload</h1>

	<div id="upload">
		<div id="progress">Choose the price list file:</div>
		<p></p>
		<div id="uploadFormDiv">
			<g:uploadForm action="upload" name="uploadForm">
				<input type="file" name="price_list" />
				<input type="submit" />
			</g:uploadForm>
		</div>
	</div>

	<script lang="javascript">

function updateProgress() {
	 $.ajax({
	        url: "${createLink(action: 'progress',controller:'price')}"
	    }).then(function(data) {
	        $('#progress').text(data);
	    });  
}

$( document ).ready(function() {
	console.log("ready!")
	$("#uploadform").ajaxForm();	
	setInterval(updateProgress, 1000); // 5 * 1000 miliseconds
});
</script>

</body>

</html>