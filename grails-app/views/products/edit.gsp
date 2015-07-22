<html>
<head>
<meta name="layout" content="default">
<style>
td.field {
	width: 10%;
}

td.orig {
	width: 30%;
	padding-right:3%;
	background-color: #FAEBD7;
}

textarea {
  overflow: auto;
  min-height: 150px;
  min-width: 300px;
}

td.orig input {
	width: 100%;
	background-color:transparent;
	border: 0px solid;	
}

td.orig div {
	padding-bottom: 5ex;
}

#uneditableFields td.orig div {
	padding-bottom: 2ex;
}

td.edit {
	width: 48%;
	background-color: #F0F8FF;
}


#uneditableFields {
	margin-bottom: 5ex;
}

#editTranslationDiv {
	margin-top: 2ex;
}

table.fields {
	text-align: left;
	padding-top: 1ex;
	border-collapse: collapse;
}

table.fields th {
	padding-bottom: 2ex;
}

table.fields td {
	vertical-align: top;
	margin-bottom:1ex;
}

table.fields tr {
	valign: top;
	border-bottom: 1px solid black;
}

td.edit textarea {
	width:100%;
	height: 100%;
	font-size: 14;
	border-width: 0;
	background-color: #F0F8FF;
}

td.orig textarea {
	width:100%;
	height: 100%;
	font-size: 14;
	border-width: 0;
	background-color: #FAEBD7;
}

</style>

</head>

<body>

<g:hasErrors bean="${product}">
              <ul class="errors">
            <g:eachError bean="${product}">
                  <li>${it.defaultMessage}</li>
              </g:eachError>
         </ul>
    </g:hasErrors>

<g:form action="${ create ? 'save' : 'update'}" method="POST" name="editProduct">

<g:if test="${product.deprecated}">
<h1 class="deprecated_message">
DEPRECATED
</h1>
</g:if>

<table id="uneditableFields" class="fields">
<tr class="${product.deprecated ? 'deprecated_product' : 'valid_product' }"> <td class="field">SKU</td> 
	 <td class="orig" colspan="2">
	   <g:textField name="sku" value="${product.sku}" />
	 </td>
</tr>

<sec:ifAnyGranted roles="ROLE_PRICE">
<tr> <td class="field">Last price update</td> 
	 <td class="orig" colspan="2"><g:textField name="price_update" value="${product.lastPrice()?.updated_on ?: 'No price registered'}" /></td></tr>
<tr> <td class="field">Price USD</td> 
	 <td class="orig" colspan="2"><g:textField name="price_USD" value="${product.lastPrice()?.price_USD ?: 'No price registered'}" /></td></tr>
<tr> <td class="field">Price BRL (no IPI)</td> 
	 <td class="orig" colspan="2"><g:textField name="price_BRL_no_IPI" value="${product.lastPrice()?.price_BRL_no_IPI ?: 'No price registered'}" /></td></tr>
<tr> <td class="field">Price BRL</td> 
	 <td class="orig" colspan="2"><g:textField name="price_BRL" value="${product.lastPrice()?.price_BRL ?: 'No price registered'}" /></td></tr>
</sec:ifAnyGranted>


<tr> <td class="field">Path</td> 
	 <td class="orig" colspan="2"><g:textField name="path" value="${product.path}" /></td></tr>

<tr> <td class="field">Edited by</td> 
	 <td class="orig" colspan="2"><div>${product.editedBy}</div></td></tr>

<tr> <td class="field">Last Update </td> 
	 <td class="orig" colspan="2"><div>${product.lastUpdated}</td></div></tr>

<tr>
	<td class="field">Product Page</td>
	<td class="orig" colspan="2">
<g:if test="${canEdit}">
	   <g:textArea readonly="${readonly}" name="url" value="${product.url}" />
</g:if>
<g:else>
	<a href="${product.url}" target="_blank">${product.url}</a>	
</g:else>
	</td>
</tr>
</table>

<div id="editTranslationDiv">
<g:if test="${create==false}">   
<g:hiddenField name="id" value="${product.id}" />
<g:hiddenField name="version" value="${product.version}" />
<g:hiddenField name="translation.id" value="${product.translation.id}" />
<g:hiddenField name="translation.version" value="${product.translation.version}" />
<g:hiddenField name="lang" value="${product.lang}" />
</g:if>

<table id="editTranslation" class="fields">
<tr> <th> Field</th> <th>Original</th> <th>Translation</th> </tr>

<tr> <td class="field">Name</td> 
	 <td class="orig"><g:textArea readonly="${readonly}" name="name" value="${product.name}" /></td>
	 <td class="edit">
	   <g:textArea readonly="${readonly}" name="translation.name" value="${product.translation?.name}" />
	 </td></tr>

<tr> <td class="field">Description</td>
	 <td class="orig">
	 	<g:textArea readonly="${readonly}" name="description" value="${product.description?.replaceAll('\n','<br/>')}" />
	 </td> 
	 <td class="edit">
	   	<g:textArea  readonly="${readonly}" name="translation.description" value="${product.translation?.description}" />
	 </td></tr>

<tr> <td class="field">Size</td> 
	 <td class="orig">
	 	<g:textArea  readonly="${readonly}" name="size" value="${product.size?.replaceAll('\n','<br/>')}" />
	 </td> 
	 <td class="edit">
	   <g:textArea readonly="${readonly}" name="translation.size" value="${product.translation?.size}" />
	 </td></tr>


<tr> <td class="field">Contents</td> 
	 <td class="orig">
	 	<g:textArea readonly="${readonly}" name="contentsAndStorage" value="${product.contentsAndStorage?.replaceAll('\n','<br/>')}" />
	 </td> 
	 <td class="edit">
	   <g:textArea readonly="${readonly}" name="translation.contentsAndStorage" value="${product.translation?.contentsAndStorage}" />
	 </td></tr>

</table>

<g:if test="${product.deprecated}">
<h1 class="deprecated_message">
DEPRECATED
</h1>
</g:if>

<g:if test="${ canEdit }">
<g:actionSubmit value="${ create ? "Save" : "Update"}" />
</g:if>
</g:form>

</div>
</body>
</html>