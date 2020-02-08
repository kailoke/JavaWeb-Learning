package a4_JSP_EL_JSTL.model;

import a3_MVCLoginTest.domain.User_table;
import a3_MVCLoginTest.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 查询DB/test内容
 */
public class UserModel {
    public static List<User_table> getInfo() throws SQLException {
        String sql = "select * from user_table";
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
        return runner.query(sql,new BeanListHandler<>(User_table.class));
    }
}
