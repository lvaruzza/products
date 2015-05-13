databaseChangeLog = {

	changeSet(author: "varuzza (generated)", id: "1431521724214-1") {
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

	changeSet(author: "varuzza (generated)", id: "1431521724214-2") {
		createTable(tableName: "price") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "pricePK")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)")

			column(name: "ncm", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "price_brl", type: "numeric(19, 2)")

			column(name: "price_brl_no_ipi", type: "numeric(19, 2)")

			column(name: "price_usd", type: "numeric(19, 2)")

			column(name: "size", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "sku", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "updated_on", type: "timestamp") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "varuzza (generated)", id: "1431521724214-3") {
		createTable(tableName: "products") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "productsPK")
			}

			column(name: "version", type: "int4") {
				constraints(nullable: "false")
			}

			column(name: "contents_and_storage", type: "text")

			column(name: "description", type: "text")

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

			column(name: "path", type: "text")

			column(name: "size", type: "text")

			column(name: "sku", type: "varchar(20)") {
				constraints(nullable: "false")
			}

			column(name: "url", type: "text")
		}
	}

	changeSet(author: "varuzza (generated)", id: "1431521724214-4") {
		createTable(tableName: "products_price") {
			column(name: "product_prices_id", type: "int8")

			column(name: "price_id", type: "int8")
		}
	}

	changeSet(author: "varuzza (generated)", id: "1431521724214-5") {
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

	changeSet(author: "varuzza (generated)", id: "1431521724214-6") {
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

	changeSet(author: "varuzza (generated)", id: "1431521724214-7") {
		createTable(tableName: "translations") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "translationsPK")
			}

			column(name: "version", type: "int4") {
				constraints(nullable: "false")
			}

			column(name: "contents_and_storage", type: "text")

			column(name: "description", type: "text")

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

			column(name: "size", type: "text")

			column(name: "sku", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "varuzza (generated)", id: "1431521724214-8") {
		createTable(tableName: "user_role") {
			column(name: "role_id", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "int8") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "varuzza (generated)", id: "1431521724214-9") {
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

	changeSet(author: "varuzza (generated)", id: "1431521724214-10") {
		addPrimaryKey(columnNames: "role_id, user_id", constraintName: "user_rolePK", tableName: "user_role")
	}

	changeSet(author: "varuzza (generated)", id: "1431521724214-16") {
		createIndex(indexName: "product_name_Idx", tableName: "products") {
			column(name: "name")
		}
	}

	changeSet(author: "varuzza (generated)", id: "1431521724214-17") {
		createIndex(indexName: "product_sku_Idx", tableName: "products") {
			column(name: "sku")
		}
	}

	changeSet(author: "varuzza (generated)", id: "1431521724214-18") {
		createIndex(indexName: "authority_uniq_1431521724174", tableName: "role", unique: "true") {
			column(name: "authority")
		}
	}

	changeSet(author: "varuzza (generated)", id: "1431521724214-19") {
		createIndex(indexName: "product_id_uniq_1431521724175", tableName: "translations", unique: "true") {
			column(name: "product_id")
		}
	}

	changeSet(author: "varuzza (generated)", id: "1431521724214-20") {
		createIndex(indexName: "username_uniq_1431521724154", tableName: "users", unique: "true") {
			column(name: "username")
		}
	}

	changeSet(author: "varuzza (generated)", id: "1431521724214-21") {
		createSequence(sequenceName: "hibernate_sequence")
	}

	changeSet(author: "varuzza (generated)", id: "1431521724214-11") {
		addForeignKeyConstraint(baseColumnNames: "price_id", baseTableName: "products_price", constraintName: "FKB64AAE652F33F0", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "price", referencesUniqueColumn: "false")
	}

	changeSet(author: "varuzza (generated)", id: "1431521724214-12") {
		addForeignKeyConstraint(baseColumnNames: "product_prices_id", baseTableName: "products_price", constraintName: "FKB64AAEB79EE825", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "products", referencesUniqueColumn: "false")
	}

	changeSet(author: "varuzza (generated)", id: "1431521724214-13") {
		addForeignKeyConstraint(baseColumnNames: "product_id", baseTableName: "translations", constraintName: "FKB6F463E2963F6CB0", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "products", referencesUniqueColumn: "false")
	}

	changeSet(author: "varuzza (generated)", id: "1431521724214-14") {
		addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "user_role", constraintName: "FK143BF46AC2F43064", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "role", referencesUniqueColumn: "false")
	}

	changeSet(author: "varuzza (generated)", id: "1431521724214-15") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_role", constraintName: "FK143BF46A681EF444", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "users", referencesUniqueColumn: "false")
	}
}
