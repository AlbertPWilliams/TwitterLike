dataSource {
    pooled = true
    jmxExport = true
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
//    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
    singleSession = true // configure OSIV singleSession mode
    flush.mode = 'manual' // OSIV session flush mode outside of transactional context
}

// environment specific settings
environments {
    development {
        dataSource {
			// Connection details for H2 Database in-memory Java database.
			driverClassName = "org.h2.Driver"
			username = "sa"
			password = ""
            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
			
			// Connection details for my local PostgreSQL database
//			driverClassName = "org.postgresql.Driver"
//			username = "postgres"
//			password = "password"
//			dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
//			url = "jdbc:postgresql://localhost:5432/twitter-like"

			// Connection details for ElephantSQL database on Pivotal Web Services
//			driverClassName = "org.postgresql.Driver"
//			username = "ytogegvv"
//			password = "gFKEosIKU3vHG7JU8AmfMQmwCbsUhFdO"
//			dbCreate = "update"
//			url = "jdbc:postgres://babar.elephantsql.com:5432/ytogegvv"
        }
    }
    test {
        dataSource {
			driverClassName = "org.h2.Driver"
			username = "sa"
			password = ""
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
        }
    }
    production {
        dataSource {
			driverClassName = "org.postgresql.Driver"
			username = "ytogegvv"
			password = "gFKEosIKU3vHG7JU8AmfMQmwCbsUhFdO"
            dbCreate = "update"
			url = "jdbc:postgres://ytogegvv:gFKEosIKU3vHG7JU8AmfMQmwCbsUhFdO@babar.elephantsql.com:5432/ytogegvv"
            properties {
               // See http://grails.org/doc/latest/guide/conf.html#dataSource for documentation
               jmxEnabled = true
               initialSize = 5
               maxActive = 50
               minIdle = 5
               maxIdle = 25
               maxWait = 10000
               maxAge = 10 * 60000
               timeBetweenEvictionRunsMillis = 5000
               minEvictableIdleTimeMillis = 60000
               validationQuery = "SELECT 1"
               validationQueryTimeout = 3
               validationInterval = 15000
               testOnBorrow = true
               testWhileIdle = true
               testOnReturn = false
               jdbcInterceptors = "ConnectionState"
               defaultTransactionIsolation = java.sql.Connection.TRANSACTION_READ_COMMITTED
            }
        }
    }
}
