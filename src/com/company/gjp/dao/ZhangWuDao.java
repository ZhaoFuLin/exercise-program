package com.company.gjp.dao;

import com.company.gjp.domain.ZhangWu;
import com.company.gjp.tools.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ZhangWuDao {
    private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

    public List<ZhangWu> selectAll() {
        try {
            String sql = "select * from gjp_zhangwu";
            List<ZhangWu> list = qr.query(sql, new BeanListHandler<>(ZhangWu.class));
            return list;
        } catch (SQLException throwables) {
            System.out.println(throwables);
            throw new RuntimeException("查询所有账务失败");
        }
    }

    public List<ZhangWu> select(String startDate, String endDate) {
        try {
            String sql = "select * from gjp_zhangwu where createtime between ? and ?";
            Object[] params = {startDate, endDate};
            return qr.query(sql, new BeanListHandler<>(ZhangWu.class), params);
        } catch (SQLException ex) {
            System.out.println(ex);
            throw new RuntimeException("条件查询失败");
        }
    }

    public void addZhangWu(ZhangWu zw) {
        try {
            String sql = "INSERT INTO gjp_zhangwu (flname,money,zhanghu,createtime,description) VALUES ( ?,?,?,?,?)";
            Object[] params = {zw.getFlname(), zw.getMoney(), zw.getZhangHu(), zw.getCreatetime(), zw.getDescription()};
            qr.update(sql, params);
        } catch (SQLException ex) {
            System.out.println(ex);
            throw new RuntimeException("账务添加失败");
        }
    }

    public void editZhangWu(ZhangWu zw) {
        try {
            String sql = "UPDATE gjp_zhangwu SET flname=?,money=?,zhanghu=?,createtime=?,description=? WHERE zwid=?";
            Object[] params = {zw.getFlname(), zw.getMoney(), zw.getZhangHu(), zw.getCreatetime(), zw.getDescription(),
                    zw.getZwid()};
            qr.update(sql, params);
        } catch (SQLException ex) {
            System.out.println(ex);
            throw new RuntimeException("账务编辑失败");
        }
    }

    public void deleteZhangWu(int zwid) {
        try {
            String sql = "DELETE FROM gjp_zhangwu WHERE zwid=?";
            qr.update(sql, zwid);
        } catch (SQLException ex) {
            System.out.println(ex);
            throw new RuntimeException("删除账务失败");
        }
    }
}
