package model;

import domain.PageBean;
import domain.Product;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    private static QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

    private static List<Product> getProducts(int page, int pageSize) throws SQLException {
        String sql = "select * from product limit ?,?";
        return runner.query(sql, new BeanListHandler<>(Product.class), (page - 1) * pageSize, pageSize);
    }

    private static int getCount() throws SQLException {
        Long query = (Long) runner.query("select count(*) from product", new ScalarHandler());
        return query.intValue();
    }

    public static PageBean getPageBean(int page, int pageSize) throws SQLException {
        PageBean<Product> pageBean = new PageBean<>();
        // 页面数据
        List<Product> products = getProducts(page, pageSize);
        pageBean.setContent(products);
        // 分页数据
        pageBean.setPage(page);
        pageBean.setPageSize(pageSize);
        int count = getCount();
        pageBean.setTotalCount(count);
        pageBean.setTotalPage((int) Math.ceil(count * 1.0 / pageSize));

        return pageBean;
    }
}
