package com.db;

import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db.utils.MapFieldStringResultSetHandler;

@Component
public class ConfigDB {

	@Autowired
	private MapFieldStringResultSetHandler mapFieldStringResultSetHandler;
	@Autowired
	private QueryRunner queryRunner;
	
	private String GET_CONFIG_BY_FIELD = "SELECT * FROM tbl_config ";
	public Map<String, String> loadAllConfig() throws SQLException {
		return queryRunner.query(GET_CONFIG_BY_FIELD, mapFieldStringResultSetHandler);
	}
}
