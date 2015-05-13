databaseChangeLog = {

	changeSet(author: "varuzza (generated)", id: "1431522458818-1") {
		modifyDataType(columnName: "contents_and_storage", newDataType: "text", tableName: "products")
	}

	changeSet(author: "varuzza (generated)", id: "1431522458818-2") {
		dropNotNullConstraint(columnDataType: "text", columnName: "contents_and_storage", tableName: "products")
	}

	changeSet(author: "varuzza (generated)", id: "1431522458818-3") {
		modifyDataType(columnName: "description", newDataType: "text", tableName: "products")
	}

	changeSet(author: "varuzza (generated)", id: "1431522458818-4") {
		dropNotNullConstraint(columnDataType: "text", columnName: "description", tableName: "products")
	}

	changeSet(author: "varuzza (generated)", id: "1431522458818-5") {
		modifyDataType(columnName: "edited_by", newDataType: "varchar(255)", tableName: "products")
	}

	changeSet(author: "varuzza (generated)", id: "1431522458818-6") {
		addNotNullConstraint(columnDataType: "varchar(255)", columnName: "edited_by", tableName: "products")
	}

	changeSet(author: "varuzza (generated)", id: "1431522458818-7") {
		modifyDataType(columnName: "lang", newDataType: "varchar(255)", tableName: "products")
	}

	changeSet(author: "varuzza (generated)", id: "1431522458818-8") {
		addNotNullConstraint(columnDataType: "varchar(255)", columnName: "lang", tableName: "products")
	}


	changeSet(author: "varuzza (generated)", id: "1431522458818-9") {
		sql("update products set last_updated=now() where last_updated is null")
		modifyDataType(columnName: "last_updated", newDataType: "timestamp", tableName: "products")
	}

	changeSet(author: "varuzza (generated)", id: "1431522458818-10") {
		addNotNullConstraint(columnDataType: "timestamp", columnName: "last_updated", tableName: "products")
	}

	changeSet(author: "varuzza (generated)", id: "1431522458818-11") {
		modifyDataType(columnName: "path", newDataType: "text", tableName: "products")
	}

	changeSet(author: "varuzza (generated)", id: "1431522458818-12") {
		dropNotNullConstraint(columnDataType: "text", columnName: "path", tableName: "products")
	}

	changeSet(author: "varuzza (generated)", id: "1431522458818-13") {
		modifyDataType(columnName: "size", newDataType: "text", tableName: "products")
	}

	changeSet(author: "varuzza (generated)", id: "1431522458818-14") {
		dropNotNullConstraint(columnDataType: "text", columnName: "size", tableName: "products")
	}

	changeSet(author: "varuzza (generated)", id: "1431522458818-15") {
		modifyDataType(columnName: "url", newDataType: "text", tableName: "products")
	}

	changeSet(author: "varuzza (generated)", id: "1431522458818-16") {
		dropNotNullConstraint(columnDataType: "text", columnName: "url", tableName: "products")
	}

	changeSet(author: "varuzza (generated)", id: "1431522458818-17") {
		modifyDataType(columnName: "contents_and_storage", newDataType: "text", tableName: "translations")
	}

	changeSet(author: "varuzza (generated)", id: "1431522458818-18") {
		dropNotNullConstraint(columnDataType: "text", columnName: "contents_and_storage", tableName: "translations")
	}

	changeSet(author: "varuzza (generated)", id: "1431522458818-19") {
		modifyDataType(columnName: "description", newDataType: "text", tableName: "translations")
	}

	changeSet(author: "varuzza (generated)", id: "1431522458818-20") {
		dropNotNullConstraint(columnDataType: "text", columnName: "description", tableName: "translations")
	}

	changeSet(author: "varuzza (generated)", id: "1431522458818-21") {
		modifyDataType(columnName: "size", newDataType: "text", tableName: "translations")
	}

	changeSet(author: "varuzza (generated)", id: "1431522458818-22") {
		dropNotNullConstraint(columnDataType: "text", columnName: "size", tableName: "translations")
	}

	changeSet(author: "varuzza (generated)", id: "1431522458818-23") {
		dropColumn(columnName: "active", tableName: "users")
	}

	changeSet(author: "varuzza (generated)", id: "1431522458818-24") {
		dropColumn(columnName: "permission", tableName: "users")
	}

	changeSet(author: "varuzza (generated)", id: "1431522458818-25") {
		dropView(schemaName: "public", viewName: "temp_products")
	}

	changeSet(author: "varuzza (generated)", id: "1431522458818-26") {
		dropTable(tableName: "temp2")
	}
}
