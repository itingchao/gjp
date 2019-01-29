package com.seven.controller;

import com.seven.sevice.SortService;
import com.seven.view.AbstractLedgerMngDialog;

import javax.swing.*;
import java.util.List;

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
    @Override
    public void addLedger() {

    }

    @Override
    public void editLedger() {

    }

    @Override
    public void deleteLedger() {

    }

    @Override
    public void queryLedger() {

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
