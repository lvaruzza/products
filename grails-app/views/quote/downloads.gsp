<html>

<head>
</head>

<body>
<h1>Quote Creation</h1>
<p> To create a new quote please download the Excel  template:
</p>

<div>
<a href="${resource(dir: 'static/price', file: 'template.xltx')}">template.xltx</a>
</div>

<p> This an excel file linked to this database. In order to use it you need to:
<ol>
<li>Download and install PosgreSQL ODBC driver: <a href="https://ftp.postgresql.org/pub/odbc/versions/msi/psqlodbc_09_03_0300.zip">psqlodbc_09_03_0300.zip</a></li>
<li>Execute o programa: C:\Windows\SysWOW64\odbcad32</li>
<li>Configure the odbc connection:
<table>
<tr><td>Driver</td><td>PosgreSQL Unicode</td></tr>
<tr><td>Data Source</td><td>orange</td></tr>
<tr><td>Database</td><td>products</td></tr>
<tr><td>Server</td><td>orange</td></tr>
<tr><td>username</td><td>odbc</td></tr>
<tr><td>password</td><td>odbc</td></tr>
</table>
</li>
</ol>
</p>

</p>
</body>

</html>