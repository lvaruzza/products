dataSource {
	pooled = true
	jmxExport = true
	driverClassName = "org.postgresql.Driver"
	dialect = org.hibernate.dialect.PostgreSQLDialect
	username = "grails"
	password = "grails"
}

hibernate {
	cache.use_second_level_cache = true
	cache.use_query_cache = false
	cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
	//cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
	singleSession = true // configure OSIV singleSession mode
	flush.mode = 'manual' // OSIV session flush mode outside of transactional context
}


environments {
	development {
		dataSource {
			pooled = true
			//dbCreate = "update"
			url = "jdbc:postgresql://localhost/products_dev"
			logSql=true
			formatSql=true
		}

		//grails.serverURL = "http://localhost:8080/${appName}"
	}

	test {
		dataSource {
			dbCreate = "update"
			url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
		}
		//grails.serverURL = "http://localhost:8080/${appName}"
	}

	production {
		dataSource {
			pooled = true
			driverClassName = "org.postgresql.Driver"
			//dialect = org.hibernate.dialect.PostgreSQLDialect
			//dbCreate = "update"
			url = "jdbc:postgresql://localhost/products"
			logSql=false
			formatSql=true
		}
		hibernate {
			// default Grails configuration:
			cache.use_second_level_cache = true
			cache.use_query_cache = true
			cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'

			// hibernate search configuration:
			search.default.directory_provider = 'filesystem'
			search.default.indexBase = '/scratch/products/production/'
		}
	}
}
