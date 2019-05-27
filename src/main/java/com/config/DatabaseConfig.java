package com.config;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.db.utils.MapFieldStringResultSetHandler;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConfig {
	
	@Autowired
	private BaseConfig baseConfig;
	
	private HikariDataSource getDataSource(){
        HikariDataSource securityDataSource = new HikariDataSource();
        securityDataSource.setDriverClassName(baseConfig.DB_DRIVER);
		securityDataSource.setJdbcUrl(baseConfig.DB_URL);
		securityDataSource.setUsername(baseConfig.DB_USERNAME);
		securityDataSource.setPassword(baseConfig.DB_PASSWORD);
		securityDataSource.addDataSourceProperty("cachePrepStmts", "true");
		securityDataSource.addDataSourceProperty("prepStmtCacheSize", "250");
		securityDataSource.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		securityDataSource.addDataSourceProperty("rewriteBatchedStatements", "true");
		securityDataSource.addDataSourceProperty("cacheResultSetMetadata", "true");
		securityDataSource.addDataSourceProperty("cacheServerConfiguration", "true");
		securityDataSource.addDataSourceProperty("elideSetAutoCommits", "true");
		securityDataSource.addDataSourceProperty("maintainTimeStats", "false");
		securityDataSource.addDataSourceProperty("characterEncoding","utf8");
		securityDataSource.addDataSourceProperty("useUnicode","true");
		securityDataSource.setMaximumPoolSize(baseConfig.DB_MAX_ACTIVE);
		securityDataSource.setMinimumIdle(baseConfig.DB_MIN_IDLE);
        return securityDataSource;
    }
    
	@Bean
    public QueryRunner queryRunner() {
    	return new QueryRunner(getDataSource());
    }
	
}
