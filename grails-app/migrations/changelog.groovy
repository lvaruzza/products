databaseChangeLog = {

	changeSet(author: "varuzza (generated)", id: "1431522205208-1") {
		createTable(tableName: "persistent_logins") {
			column(name: "series", type: "VARCHAR(64)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "persistent_logins_pkey")
			}

			column(name: "last_used", type: "TIMESTAMP WITH TIME ZONE") {
				constraints(nullable: "false")
			}

			column(name: "token", type: "VARCHAR(64)") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "VARCHAR(64)") {
				constraints(nullable: "false")
			}
		}
	}

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

	changeSet(author: "varuzza (generated)", id: "1431522205208-3") {
		createTable(tableName: "products") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "products_pkey")
			}

			column(name: "version", type: "int4") {
				constraints(nullable: "false")
			}

			column(name: "contents_and_storage", type: "TEXT") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "TEXT") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "TEXT") {
				constraints(nullable: "false")
			}

			column(name: "path", type: "TEXT") {
				constraints(nullable: "false")
			}

			column(name: "size", type: "TEXT") {
				constraints(nullable: "false")
			}

			column(name: "sku", type: "VARCHAR(20)") {
				constraints(nullable: "false")
			}

			column(name: "url", type: "TEXT") {
				constraints(nullable: "false")
			}

			column(name: "edited_by", type: "VARCHAR(8)")

			column(name: "last_updated", type: "TIMESTAMP WITH TIME ZONE")

			column(name: "lang", type: "VARCHAR(5)")
		}
	}

	changeSet(author: "varuzza (generated)", id: "1431522205208-4") {
		createTable(tableName: "products_price") {
			column(name: "product_prices_id", type: "int8")

			column(name: "price_id", type: "int8")
		}
	}

	changeSet(author: "varuzza (generated)", id: "1431522205208-5") {
		createTable(tableName: "registration_code") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "registration_code_pkey")
			}

			column(name: "date_created", type: "TIMESTAMP WITH TIME ZONE") {
				constraints(nullable: "false")
			}

			column(name: "token", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "varuzza (generated)", id: "1431522205208-6") {
		createTable(tableName: "role") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "role_pkey")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "authority", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "varuzza (generated)", id: "1431522205208-7") {
		createTable(tableName: "temp2") {
			column(name: "sku", type: "TEXT")

			column(name: "name", type: "TEXT")

			column(name: "description", type: "TEXT")

			column(name: "ncm", type: "TEXT")

			column(name: "dimemsions", type: "TEXT")

			column(name: "weight", type: "TEXT")

			column(name: "children", type: "TEXT")

			column(autoIncrement: "true", name: "id", type: "serial") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "varuzza (generated)", id: "1431522205208-8") {
		createTable(tableName: "translations") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "translations_pkey")
			}

			column(name: "version", type: "int4") {
				constraints(nullable: "false")
			}

			column(name: "contents_and_storage", type: "TEXT") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "TEXT") {
				constraints(nullable: "false")
			}

			column(name: "edited_by", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "lang", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "TIMESTAMP WITH TIME ZONE") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "TEXT") {
				constraints(nullable: "false")
			}

			column(name: "product_id", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "size", type: "TEXT") {
				constraints(nullable: "false")
			}

			column(name: "sku", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "varuzza (generated)", id: "1431522205208-9") {
		createTable(tableName: "user_role") {
			column(name: "role_id", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "int8") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "varuzza (generated)", id: "1431522205208-10") {
		createTable(tableName: "users") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "userspk")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "email", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "password", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "active", type: "bool") {
				constraints(nullable: "false")
			}

			column(name: "initials", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "permission", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(defaultValueBoolean: "false", name: "account_expired", type: "bool") {
				constraints(nullable: "false")
			}

			column(defaultValueBoolean: "false", name: "account_locked", type: "bool") {
				constraints(nullable: "false")
			}

			column(defaultValueBoolean: "true", name: "enabled", type: "bool") {
				constraints(nullable: "false")
			}

			column(defaultValueBoolean: "false", name: "password_expired", type: "bool") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "varuzza (generated)", id: "1431522205208-11") {
		addPrimaryKey(columnNames: "role_id, user_id", constraintName: "user_role_pkey", tableName: "user_role")
	}

	changeSet(author: "varuzza (generated)", id: "1431522205208-12") {
		addUniqueConstraint(columnNames: "authority", constraintName: "role_authority_key", deferrable: "false", disabled: "false", initiallyDeferred: "false", tableName: "role")
	}

	changeSet(author: "varuzza (generated)", id: "1431522205208-13") {
		addUniqueConstraint(columnNames: "product_id", constraintName: "translations_product_id_key", deferrable: "false", disabled: "false", initiallyDeferred: "false", tableName: "translations")
	}

	changeSet(author: "varuzza (generated)", id: "1431522205208-19") {
		createIndex(indexName: "product_name_idx", tableName: "products", unique: "false") {
			column(name: "name")
		}
	}

	changeSet(author: "varuzza (generated)", id: "1431522205208-20") {
		createIndex(indexName: "product_sku_idx", tableName: "products", unique: "false") {
			column(name: "sku")
		}
	}

	changeSet(author: "varuzza (generated)", id: "1431522205208-21") {
		createIndex(indexName: "user_login_idx", tableName: "users", unique: "false") {
			column(name: "username")
		}
	}

	changeSet(author: "varuzza (generated)", id: "1431522205208-22") {
		createSequence(schemaName: "public", sequenceName: "hibernate_sequence")
	}

	changeSet(author: "varuzza (generated)", id: "1431522205208-23") {
		createView(""" SELECT p.id,
    t.sku,
    t.name
   FROM (temp2 t
     LEFT JOIN products p ON (((p.sku)::text = t.sku)));""", schemaName: "public", viewName: "temp_products")
	}

	changeSet(author: "varuzza (generated)", id: "1431522205208-14") {
		addForeignKeyConstraint(baseColumnNames: "price_id", baseTableName: "products_price", baseTableSchemaName: "public", constraintName: "fkb64aae652f33f0", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "price", referencedTableSchemaName: "public", referencesUniqueColumn: "false")
	}

	changeSet(author: "varuzza (generated)", id: "1431522205208-15") {
		addForeignKeyConstraint(baseColumnNames: "product_prices_id", baseTableName: "products_price", baseTableSchemaName: "public", constraintName: "fkb64aaeb79ee825", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "products", referencedTableSchemaName: "public", referencesUniqueColumn: "false")
	}

	changeSet(author: "varuzza (generated)", id: "1431522205208-16") {
		addForeignKeyConstraint(baseColumnNames: "product_id", baseTableName: "translations", baseTableSchemaName: "public", constraintName: "fkb6f463e2963f6cb0", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "products", referencedTableSchemaName: "public", referencesUniqueColumn: "false")
	}

	changeSet(author: "varuzza (generated)", id: "1431522205208-17") {
		addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "user_role", baseTableSchemaName: "public", constraintName: "fk143bf46ac2f43064", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "role", referencedTableSchemaName: "public", referencesUniqueColumn: "false")
	}

	changeSet(author: "varuzza (generated)", id: "1431522205208-18") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_role", baseTableSchemaName: "public", constraintName: "fk143bf46a681ef444", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "users", referencedTableSchemaName: "public", referencesUniqueColumn: "false")
	}
}
