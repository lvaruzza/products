databaseChangeLog = {

	changeSet(author: "varuzza (generated)", id: "1431521506807-1") {
		createTable(tableName: "persistent_logins") {
			column(name: "series", type: "varchar(64)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "persistent_loPK")
			}

			column(name: "last_used", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "token", type: "varchar(64)") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "varchar(64)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "varuzza (generated)", id: "1431521506807-2") {
		createTable(tableName: "products") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "productsPK")
			}

			column(name: "version", type: "int4") {
				constraints(nullable: "false")
			}

			column(name: "contents_and_storage", type: "text") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "text") {
				constraints(nullable: "false")
			}

			column(name: "edited_by", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "lang", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "text") {
				constraints(nullable: "false")
			}

			column(name: "path", type: "text") {
				constraints(nullable: "false")
			}

			column(name: "size", type: "text") {
				constraints(nullable: "false")
			}

			column(name: "sku", type: "varchar(20)") {
				constraints(nullable: "false")
			}

			column(name: "url", type: "text") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "varuzza (generated)", id: "1431521506807-3") {
		createTable(tableName: "registration_code") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "registration_PK")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "token", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "varuzza (generated)", id: "1431521506807-4") {
		createTable(tableName: "role") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "rolePK")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "authority", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "varuzza (generated)", id: "1431521506807-5") {
		createTable(tableName: "translations") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "translationsPK")
			}

			column(name: "version", type: "int4") {
				constraints(nullable: "false")
			}

			column(name: "contents_and_storage", type: "text") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "text") {
				constraints(nullable: "false")
			}

			column(name: "edited_by", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "lang", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "text") {
				constraints(nullable: "false")
			}

			column(name: "product_id", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "size", type: "text") {
				constraints(nullable: "false")
			}

			column(name: "sku", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "varuzza (generated)", id: "1431521506807-6") {
		createTable(tableName: "user_role") {
			column(name: "role_id", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "int8") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "varuzza (generated)", id: "1431521506807-7") {
		createTable(tableName: "users") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "usersPK")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "account_expired", type: "bool") {
				constraints(nullable: "false")
			}

			column(name: "account_locked", type: "bool") {
				constraints(nullable: "false")
			}

			column(name: "email", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "enabled", type: "bool") {
				constraints(nullable: "false")
			}

			column(name: "initials", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "password", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "password_expired", type: "bool") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "varuzza (generated)", id: "1431521506807-8") {
		addPrimaryKey(columnNames: "role_id, user_id", constraintName: "user_rolePK", tableName: "user_role")
	}

	changeSet(author: "varuzza (generated)", id: "1431521506807-12") {
		createIndex(indexName: "product_name_Idx", tableName: "products") {
			column(name: "name")
		}
	}

	changeSet(author: "varuzza (generated)", id: "1431521506807-13") {
		createIndex(indexName: "product_sku_Idx", tableName: "products") {
			column(name: "sku")
		}
	}

	changeSet(author: "varuzza (generated)", id: "1431521506807-14") {
		createIndex(indexName: "authority_uniq_1431521506769", tableName: "role", unique: "true") {
			column(name: "authority")
		}
	}

	changeSet(author: "varuzza (generated)", id: "1431521506807-15") {
		createIndex(indexName: "product_id_uniq_1431521506772", tableName: "translations", unique: "true") {
			column(name: "product_id")
		}
	}

	changeSet(author: "varuzza (generated)", id: "1431521506807-16") {
		createIndex(indexName: "username_uniq_1431521506758", tableName: "users", unique: "true") {
			column(name: "username")
		}
	}

	changeSet(author: "varuzza (generated)", id: "1431521506807-17") {
		createSequence(sequenceName: "hibernate_sequence")
	}

	changeSet(author: "varuzza (generated)", id: "1431521506807-9") {
		addForeignKeyConstraint(baseColumnNames: "product_id", baseTableName: "translations", constraintName: "FKB6F463E2963F6CB0", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "products", referencesUniqueColumn: "false")
	}

	changeSet(author: "varuzza (generated)", id: "1431521506807-10") {
		addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "user_role", constraintName: "FK143BF46AC2F43064", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "role", referencesUniqueColumn: "false")
	}

	changeSet(author: "varuzza (generated)", id: "1431521506807-11") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_role", constraintName: "FK143BF46A681EF444", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "users", referencesUniqueColumn: "false")
	}
}
