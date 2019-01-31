package com.seven.dao;

import com.seven.domain.Sort;
import com.seven.tools.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName:SortDao
 * @Description: 访问数据库的类
 * SortDao类，负责分类功能
 * @Author:Admin
 * @Date: 2019/1/2615:02
 * @version: 1.0
 */
public class SortDao {

    //在类的成员位置，定义QueryRunner对象，所有方法，都可以直接使用
    private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

    /**
     *querySortNameIncome 查询所有收入的分类
     */
    public List<Object> querySortNamePay(){
        try {
            String sql = "SELECT sname FROM gjp_sort WHERE parent = '支出'";
            return qr.query(sql,new ColumnListHandler());
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /**
     *querySortNameIncome 查询所有收入的分类
     */
    public List<Object> querySortNameIncome(){
        try {
           String sql = "SELECT sname FROM gjp_sort WHERE parent = '收入'";
           return qr.query(sql,new ColumnListHandler());
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /**
     * querySortNameAll 查询所有分类的名称
     *
     */
    public List<Object> querySortNameAll(){
        try {
            String sql = "SELECT sname FROM gjp_sort";
            return qr.query(sql,new ColumnListHandler());
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    /**
     * 删除分类
     */
    public void deleteSort(Sort sort){
        try {
            String sql = "DELETE FROM gjp_sort WHERE sid = ?";
            Object[] params = {sort.getSid()};
            qr.update(sql,params);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /**
     *分类管理--分类编辑
     */
    public void editSort(Sort sort) {
        try {
            String sql = "UPDATE gjp_sort SET sname = ?,parent = ?,sdesc=? where sid = ?";
            Object[] params = {sort.getSname(),sort.getParent(),sort.getSdesc(),sort.getSid()};
            qr.update(sql,params);
        }catch (SQLException e){
            throw new RuntimeException(e);

        }

    }

    /**
     * 定义方法，添加分类数据
     * 方法需要传递参数，Sort对象
     * 添加的即使Sort对象中的数据
     * 没有返回值
     * 由service层调用
     */
    public void addSort(Sort sort){
        try {
            String sql = "INSERT INTO gjp_sort(sname,parent,sdesc)value(?,?,?)";
            //定义SQL语句中的参数，OBJECT数据
            Object[] params = {sort.getSname(),sort.getParent(),sort.getSdesc()};
            //QueryRunner方法update
            qr.update(sql,params);
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 定义方法，查询出所有分类数据
     * 返回List集合，泛型Sort类型
     *
     */
    public List<Sort> querySortAll(){

        try {
            //拼写数据库的SQL语句
            String sql = "SELECT * from gjp_sort";
            //调用Querunner方法查询数据表，结果集的处理方式Beanlisthandler
            return qr.query(sql, new BeanListHandler<>(Sort.class));
        }catch (SQLException e){
            //手动抛出运行时异常
            throw new RuntimeException(e);
        }

    }
}
