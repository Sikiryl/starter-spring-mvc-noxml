package com.db.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.dbutils.ResultSetHandler;
import org.springframework.stereotype.Component;

@Component
public class MapFieldStringResultSetHandler implements ResultSetHandler<Map<String, String>>{
	
	private String keyField;
	private String valueField;
	
	public MapFieldStringResultSetHandler() {
		this.keyField = "field";
		this.valueField = "value";
	}
	
	public MapFieldStringResultSetHandler(String keyField, String valueField){
		this.keyField = keyField;
		this.valueField = valueField;
	}
	
	public Map<String, String> handle(ResultSet rs) throws SQLException {
		Map<String, String> m = new HashMap<String, String>();		
		while (rs.next()) {
			Object key = rs.getObject(keyField);
			Object value = rs.getObject(valueField);
			if(key != null) {
				if(value == null) {
					m.put(String.valueOf(key), null);
				} else {
					m.put(String.valueOf(key), String.valueOf(value));
				}				
			}		
		}
		return m;
	}
	
	
}
