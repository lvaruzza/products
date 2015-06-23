databaseChangeLog = {

	changeSet(author: "varuzza (generated)", id: "1431522205208-2") {
		createTable(tableName: "price") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "price_pkey")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "ncm", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "price_brl", type: "NUMERIC(19,2)")

			column(name: "price_brl_no_ipi", type: "NUMERIC(19,2)")

			column(name: "price_usd", type: "NUMERIC(19,2)")

			column(name: "size", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "sku", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "updated_on", type: "TIMESTAMP WITH TIME ZONE") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "VARCHAR(255)")
		}
	}


	include file: 'changelog_001.groovy'

	include file: 'changelog_002.groovy'

	include file: 'changelog_003.groovy'

	include file: 'add-deprecated-field.groovy'

	include file: 'create_messages.groovy'
}
