package com.seven.sevice;

import com.seven.dao.LedgerDao;
import com.seven.dao.SortDao;
import com.seven.domain.Ledger;
import com.seven.domain.QueryForm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName:LedgerService
 * @Description:TODO
 * @Author:Admin
 * @Date: 2019/1/2922:04
 * @version: 1.0
 */
public class LedgerService {

    private LedgerDao ledgerDao = new LedgerDao();
    private SortDao sortDao = new SortDao();

    //编辑账务
    public void editLedger(Ledger ledger){
        ledgerDao.editLedger(ledger);
    }

    //添加账务
    public void addLedger(Ledger ledger){
        ledgerDao.addLedger(ledger);
    }
    //调用sortDao的querySidBySname
    public int querySidBySname(String sname){
        return sortDao.querySidBySname(sname);
    }

    public Map<String,Object> queryLedgerByQueryForm(QueryForm form){

       List<Ledger> list =  ledgerDao.queryLedgerByQueryForm(form);
        double in = 0;
        double pay = 0;
       for (Ledger ledger : list){
           //System.out.println(ledger);
           String sname = sortDao.querySnameBySid(ledger.getSid());
           //System.out.println(sname);
           ledger.setSname(sname);
           //System.out.println("------------------------");
           //System.out.println(ledger);
           //判断收入或者支出，然后计算综合
           if (ledger.getParent().equals("收入")){
                in += ledger.getMoney();
           }else {
               pay += ledger.getMoney();
           }
       }
       Map<String,Object> date = new HashMap<String, Object>();
       date.put("Ledger",list);
       date.put("in",in);
       date.put("pay",pay);
        System.out.println(date);
        return date;
    }
}
