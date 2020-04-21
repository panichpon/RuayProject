package ruay.db.config;

import com.zaxxer.hikari.HikariConfig;

public class DatabaseConfig {
	private final String DB_SERVER = "localhost";
	private final String DB_PORT = "3306";
	private final String DB_NAME = "ruaydb";
	private final String DB_USERNAME = "root";
	private final String DB_PASSWORD = "1234";

	public HikariConfig getHikariConfig() {
		HikariConfig config = new HikariConfig();
		config.setLeakDetectionThreshold(3600000); // 1 hour
		config.setMinimumIdle(5);
		config.setMaximumPoolSize(10);
		config.setConnectionTestQuery("/* ping */ SELECT 1");
		config.setConnectionTimeout(30000); // 30 sec
		config.setMaxLifetime(1800000); // 30 mins
		config.setIdleTimeout(300000); // 5 mins
		config.setPoolName("RUAY-HikariPool-1");
		config.setDataSourceClassName("org.mariadb.jdbc.MariaDbDataSource");
		config.addDataSourceProperty("serverName", DB_SERVER);
		config.addDataSourceProperty("portNumber", DB_PORT);
		config.addDataSourceProperty("user", DB_USERNAME);
		config.addDataSourceProperty("password", DB_PASSWORD);
		config.addDataSourceProperty("databaseName", DB_NAME);
		return config;
	}
}
