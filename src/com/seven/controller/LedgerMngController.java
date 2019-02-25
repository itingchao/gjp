package com.seven.controller;

import com.seven.domain.Ledger;
import com.seven.domain.QueryForm;
import com.seven.sevice.LedgerService;
import com.seven.sevice.SortService;
import com.seven.view.AbstractLedgerMngDialog;

import javax.swing.*;
import java.util.List;
import java.util.Map;

/**
 * @ClassName:LedgerMngController
 * @Description: 管理账务的对话框，通过通主窗体中，管理账务按钮
 * @Author:Admin
 * @Date: 2019/1/2318:55
 * @version: 1.0
 */
public class LedgerMngController extends AbstractLedgerMngDialog {
    public LedgerMngController(JFrame frame) {
        super(frame);
    }

    private SortService sortService = new SortService();
    private LedgerService ledgerService = new LedgerService();
    @Override
    public void addLedger() {
        new AddLedgerController(this).setVisible(true);
    }

    @Override
    public void editLedger() {

    }

    @Override
    public void deleteLedger() {

    }

    @Override
    public void queryLedger() {
        String begin = beginDateTxt.getText();
        String end = endDateTxt.getText();
        String parent = parentBox.getSelectedItem().toString();
        String sname = sortBox.getSelectedItem().toString();
        QueryForm form = new QueryForm(begin,end,parent,sname);
        ledgerService.queryLedgerByQueryForm(form);

        Map<String,Object> data = ledgerService.queryLedgerByQueryForm(form);
        List<Ledger> list = (List<Ledger>)data.get("Ledger");
        double in = (double)data.get("in");
        double pay = (double)data.get("pay");

        setTableModel(list);
        inMoneyTotalLabel.setText(new StringBuffer().append("总收入：").append(in).append(" 元").toString());
        payMoneyTotalLabel.setText(new StringBuffer().append("总支出：").append(pay).append(" 元").toString());


    }

    @Override
    public void parentChange() {
        String parent = parentBox.getSelectedItem().toString();
        //parent选择的是”=请选择=“
        if (parent.equals("-请选择-")){
            sortBox.setModel(new DefaultComboBoxModel(new String[]{"-请选择-"}));
        }
        //
        if (parent.equals("收入/支出")){
            //调用service从里面的方法查询分类名称
            //获取list的集合，然后添加到下拉菜单中
            List<Object> list = sortService.querySortNameAll();
            list.add(0,"-请选择-");
            sortBox.setModel(new DefaultComboBoxModel(list.toArray()));
        }
        if (parent.equals("收入")){
            List<Object> list = sortService.querySortNameIncome();
            list.add(0,"-请选择-");
            sortBox.setModel(new DefaultComboBoxModel(list.toArray()));
        }
        if (parent.equals("支出")){
            List<Object> list = sortService.querySoryNamePay();
            list.add(0,"-请选择-");
            sortBox.setModel(new DefaultComboBoxModel(list.toArray()));
        }
    }

    @Override
    public void pie() {
        new ShapeController(this).setVisible(true);
    }
}
