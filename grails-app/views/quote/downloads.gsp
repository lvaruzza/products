<html>

<head>
<meta name="layout" content="default">
</head>

<body>


	<div class="mdl-card mdl-shadow--2dp demo-card-wide">
		<div class="mdl-card__title">
			<h2 class="mdl-card__title-text">Quote Creation</h2>
		</div>
		<div class="mdl-card__supporting-text">
			<p>To create a quote you need to configure your computer according to this instructions and 
			download the excel template. 
			</p>
			<ol>
				<li>Download and install PosgreSQL ODBC driver: <a
					href="https://ftp.postgresql.org/pub/odbc/versions/msi/psqlodbc_09_03_0300.zip">psqlodbc_09_03_0300.zip</a></li>
				<li>Execute o programa: C:\Windows\SysWOW64\odbcad32</li>
				<li>Configure the odbc connection:
					<table>
						<tr>
							<td>Driver</td>
							<td>PosgreSQL Unicode</td>
						</tr>
						<tr>
							<td>Data Source</td>
							<td>orange</td>
						</tr>
						<tr>
							<td>Database</td>
							<td>products</td>
						</tr>
						<tr>
							<td>Server</td>
							<td>orange</td>
						</tr>
						<tr>
							<td>username</td>
							<td>odbc</td>
						</tr>
						<tr>
							<td>password</td>
							<td>odbc</td>
						</tr>
					</table>
				</li>
			</ol>
			</p>

			</p>
		</div>
		<div class="mdl-card__actions mdl-card--border">
			<a href="${resource(dir: 'static/price', file: 'template.xltx')}"
				class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
				Quote Template</a>

		</div>
	</div>
</body>

</html>