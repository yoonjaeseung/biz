package persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;


@Slf4j
public class JDBCTests {

	static {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConnection() {

		try (Connection con = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/springbook", "root",
				"root")) {

			log.info("{}",con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
