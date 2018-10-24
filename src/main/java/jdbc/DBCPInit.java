package jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

@WebServlet("/DBCPInit")
public class DBCPInit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DBCPInit() {
		loadJDBCDriver();
		initConnectionPool();
	}

	private void loadJDBCDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("OpenProject DB Driver Load Success.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void initConnectionPool() {
		try {
			String jdbcDriver = "jdbc:oracle:thin:localhost:1521:orcl";
			String username = "nujobes";
			String password = "nujobes";

			ConnectionFactory connFactory = new DriverManagerConnectionFactory(jdbcDriver, username, password);

			PoolableConnectionFactory poolableConnFactory = new PoolableConnectionFactory(connFactory, null);

			poolableConnFactory.setValidationQuery("select 1");

			GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();

			poolConfig.setTimeBetweenEvictionRunsMillis(1000L * 60L * 5L);
			poolConfig.setTestWhileIdle(true);
			poolConfig.setMinIdle(4);
			poolConfig.setMaxTotal(50);

			GenericObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<>(poolableConnFactory,
					poolConfig);

			poolableConnFactory.setPool(connectionPool);

			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");

			driver.registerPool("OpenProject", connectionPool);
			System.out.println("POOLING 등록 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
