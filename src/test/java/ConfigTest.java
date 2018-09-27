import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigTest {

	@Test
	public void test() {
		String path = "classpath:spring/application-config.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(path);
		BasicDataSource bds = (BasicDataSource)ac.getBean("dataSource");

		int cnt = 0;
		try(Connection con = bds.getConnection()) {
			PreparedStatement ps = con.prepareStatement("select count(*) as cnt  from emp");
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		assertEquals(cnt, 14);
	}

}
