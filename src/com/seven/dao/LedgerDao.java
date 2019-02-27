package com.seven.dao;

import com.seven.domain.Ledger;
import com.seven.domain.QueryForm;
import com.seven.tools.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:LedgerDao
 * @Description:TODO
 * @Author:Admin
 * @Date: 2019/2/2022:24
 * @version: 1.0
 */
public class LedgerDao {

    private SortDao sortDao = new SortDao();
    private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

    //编辑账务
    public void editLedger(Ledger ledger){
        String sql = "UPDATE gjp_ledger set parent=?,money=?,sid=?,account=?,createtime=?,ldesc=? where lid = ?";
        Object[] params = {ledger.getParent(),ledger.getMoney(),ledger.getSid(),ledger.getAccount(),ledger.getCreatetime(),ledger.getLdesc(),ledger.getSid()};
        try {
            qr.update(sql,params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //添加账务
    public void addLedger(Ledger ledger){
        String sql = "INSERT INTO gjp_ledger (parent,money,sid,account,createtime,ldesc) values(?,?,?,?,?,?)";
        Object[] params = {ledger.getParent(),ledger.getMoney(),ledger.getSid(),ledger.getAccount(),ledger.getCreatetime(),ledger.getLdesc()};
        try {
            qr.update(sql,params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Ledger> queryLedgerByQueryForm(QueryForm form){
        List<String> param = new ArrayList<String>();
        StringBuffer builder = new StringBuffer();//用来储存拼接sql语句
        builder.append("SELECT * FROM gjp_ledger WHERE createtime between ? and ?");
        param.add(form.getBegin());
        param.add(form.getEnd());

        //判断parent为收入或者支出
        if (form.getParent().equals("收入")||form.getParent().equals("支出")){
            builder.append(" and parent = ?");
            param.add(form.getParent());
        }
        if (!form.getSname().equals("-请选择-")){
            int sid = sortDao.querySidBySname(form.getSname());
            builder.append(" and sid = ?");
            param.add(sid+"");
        }
        try {
            return qr.query(builder.toString(),new BeanListHandler<Ledger>(Ledger.class),param.toArray());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}