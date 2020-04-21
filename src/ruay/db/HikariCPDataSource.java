package ruay.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import ruay.db.config.DatabaseConfig;

@Component
public class HikariCPDataSource {
    private static final Logger LOG = LoggerFactory.getLogger(HikariCPDataSource.class);
    
    public static HikariDataSource ds = null;

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    
    @PostConstruct
    public void init() {
	    HikariConfig config = new DatabaseConfig().getHikariConfig();
	    ds = new HikariDataSource(config);
	    LOG.info("HikariDataSource Started");
    }
    
    @PreDestroy
    public void shutDown() {
	    ds.close();
    }
}
