package org.mattpayne.demo.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class ResultSetExtractorListMap implements ResultSetExtractor<List<Map<String,Object>>> {

	@Override
	public List<Map<String,Object>> extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<Map<String, Object>> retval=new ArrayList<Map<String,Object>>();
		ResultSetMetaData meta = rs.getMetaData();
		int numCols=meta.getColumnCount();
		while (rs.next()) {
			Map<String,Object> m = new TreeMap<String, Object>();
			for (int column=1; column <= numCols; ++column) {
				m.put(meta.getColumnName(column), rs.getObject(column));
			}
			retval.add(m);
		}
		
		return retval;
	}

}
