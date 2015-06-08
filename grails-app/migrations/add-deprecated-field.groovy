databaseChangeLog = {

	changeSet(author: "varuzza (generated)", id: "1433781719464-1") {
		addColumn(tableName: "products") {
			column(name: "deprecated", type: "bool",defaultValue:false) {
				constraints(nullable: "false")
			}
		}
	}
}
