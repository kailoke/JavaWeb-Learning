package A3_LoginExercise.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * JDBC 数据库连接池
 */
public class JDBCUtils {
    private static final DataSource CPDS = new ComboPooledDataSource("helloc3p0");

    public static Connection getConnection() throws SQLException {
        return CPDS.getConnection();
    }

    public static DataSource getDataSource() {
        return CPDS;
    }
}
