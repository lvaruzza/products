<html>
<head>
<meta name="layout" content="default">
</head>
<body>

	<div id="searchbox">
		<g:form action="list" name="search" method="GET">
		Search: <g:textField name="query" value="${query}" />
			<g:link action="list" params="${[query:""]}">Clear</g:link>
		</g:form>
	</div>

	<div id="productsListDiv">
		<g:if test="${results.size() > 0}">
			<table id="productsList">
				<tr>
					<th>SKU</th>
					<th>Name</th>
					<th>Translation</th>
					<th>Update</th>
				</tr>
				<g:each var="product" in="${results}">
					<tr
						class="${product.deprecated ? 'deprecated_product' : 'valid_product'  }"}>
						<td><g:link action="edit" id="${product.id}">
								${product.sku}
							</g:link></td>
						<td class="orig">
							${product.name}
						</td>
						<td class="translation">
							${product.translation?.name}
						</td>
						<td class="update"><g:if test="${product.deprecated}">
								<span class="deprecated_message">DEPRECATED</span>
							</g:if> <prod:updated editedBy="${product.editedBy}"
								updated="${product.lastUpdated}" /></td>
					</tr>
				</g:each>
			</table>

			<div id="listPaging" class="paginateButtons">
				<g:paginate controller="Products" action="list" max="${max}"
					params="[query:query,max:max]" total="${total}" />
			</div>

		</g:if>
		<g:else>
			<p>No results found</p>
		</g:else>
	</div>
</body>
</html>