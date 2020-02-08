package A3_LoginExercise.model;

import A3_LoginExercise.domain.User_table;
import A3_LoginExercise.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import java.sql.SQLException;

/**
 * 处理JavaBean的数据，QueryRunner内部自动关闭RS && stmt
 */
public class UserModel {
    /**
     * 处理用户登陆
     * @param user 登陆信息
     * @return 查询结果
     */
    public static User_table login(User_table user) throws SQLException {
        String sql = "select * from user_table where `user`=? and `password`= ?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        return queryRunner.query(sql, new BeanHandler<>(User_table.class), user.getUser(), user.getPassword());
    }
}
