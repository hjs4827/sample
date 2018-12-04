package net.bnjjong.sample.net.bnjjong.sample.conn;


import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.Assert.*;

/**
 * Created by bnjjong on 2018-12-03.
 */
public class MySqlConnectorTest {


	@Test
	public void connTest() throws SQLException {
		Connection conn = MySqlConnector.getConnection();
		PreparedStatement ps;

		// create table
		ps = conn.prepareStatement("CREATE TABLE IF NOT EXISTS test_from_app(col1 varchar(100), col2 varchar(100));");
		ps.executeQuery();
		conn.commit();

		// delete rows
		ps = conn.prepareStatement("delete from test_from_app;");
		ps.executeUpdate();
		conn.commit();


		// insert row
		ps = conn.prepareStatement("insert into test_from_app(col1, col2) values('11','22');");
		ps.executeUpdate();
		conn.commit();

		ps = conn.prepareStatement("select col1, col2 from test_from_app where col1 = '11';");
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			String col1Value = rs.getString("col1");
			String col2Value = rs.getString("col2");
			assertEquals("11", col1Value);
			assertEquals("22", col2Value);
		} else {
			fail("fail!!");
		}

	}
}