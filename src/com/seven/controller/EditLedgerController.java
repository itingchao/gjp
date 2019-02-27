package com.seven.controller;

import com.seven.domain.Ledger;
import com.seven.sevice.LedgerService;
import com.seven.sevice.SortService;
import com.seven.view.AbstractOperationLedgerDialog;

import javax.swing.*;
import java.util.List;

/**
 * @ClassName:EditLedgerController
 * @Description:TODO
 * @Author:Admin
 * @Date: 2019/2/2622:24
 * @version: 1.0
 */
public class EditLedgerController extends AbstractOperationLedgerDialog {
    private SortService sortService = new SortService();
    private Ledger ledger;
    private LedgerService ledgerService = new LedgerService();
    public EditLedgerController(JDialog dialog,Ledger ledger) {
        super(dialog);
        this.titleLabel.setText("编辑账务");
        super.setTitle("编辑账务");

        this.ledger = ledger;
        parentBox.setSelectedItem(ledger.getParent());
        sortBox.setSelectedItem(ledger.getSname());
        accountTxt.setText(ledger.getAccount());
        moneyTxt.setText(ledger.getMoney()+"");
        createtimeTxt.setText(ledger.getCreatetime());
        ldescTxt.setText(ledger.getLdesc());

    }

    @Override
    public void initDialog() {
        super.initDialog();
    }

    @Override
    public void changeParent() {
        String parent = parentBox.getSelectedItem().toString();
        //parent选择的是”=请选择=“
        if (parent.equals("-请选择-")){
            sortBox.setModel(new DefaultComboBoxModel(new String[]{"-请选择-"}));
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
    public void confirm() {
        String parent = parentBox.getSelectedItem().toString();
        String sname = sortBox.getSelectedItem().toString();
        String account = accountTxt.getText();
        String sMoney = moneyTxt.getText();
        String sDesc = ldescTxt.getText();
        String createtime = createtimeTxt.getText();

        if (parent.equals("-请选择-")){
            JOptionPane.showMessageDialog(this,"请选择分类");
            return;
        }
        if (sname.equals("-请选择-")){
            JOptionPane.showMessageDialog(this,"请选择分类名称");
            return;
        }
        if (account == null || account.isEmpty()){
            JOptionPane.showMessageDialog(this,"请填写账户");
            return;
        }
        double money = 0;
        try{
            money = Double.parseDouble(sMoney);
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this,"必须填写数字");
            return;
        }
        if (money < 0){
            JOptionPane.showMessageDialog(this,"金额必须大于0");
            return;
        }

        int lid = ledger.getLid();
        int sid = ledgerService.querySidBySname(sname);
        ledger = new Ledger();
        ledger.setParent(parent);
        ledger.setMoney(money);
        ledger.setLid(lid);
        ledger.setSname(sname);
        ledger.setSid(sid);
        ledger.setLdesc(sDesc);
        ledger.setAccount(account);
        ledger.setCreatetime(createtime);

        ledgerService.editLedger(ledger);
        this.dispose();
        JOptionPane.showMessageDialog(this,"编辑成功");
    }
}
