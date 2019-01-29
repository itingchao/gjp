package com.seven.controller;

import com.seven.domain.Sort;
import com.seven.sevice.SortService;
import com.seven.view.AbstractOperationSortDialog;

import javax.swing.*;

/**
 * @ClassName:EditSortController
 * @Description: 编辑分类的对话框
 * @Author:Admin
 * @Date: 2019/1/2318:04
 * @version: 1.0
 */
public class EditSortController extends AbstractOperationSortDialog {
    private Sort sort;
    public EditSortController(JDialog dialog, Sort sort) {
        super(dialog);
        titleLabel.setText("编辑分类");
        super.setTitle("编辑分类");

        this.sort = sort;
        //获取
        parentBox.setSelectedItem(sort.getParent());
        snameTxt.setText(sort.getSname());
        sdescArea.setText(sort.getSdesc());
    }

    @Override
    public void initDialog() {
        super.initDialog();
    }

    @Override
    public void confirm() {

        String parent = parentBox.getSelectedItem().toString();
        String sname = snameTxt.getText().trim();
        String sdesc = sdescArea.getText();

        if (parent.equals("=请选择=")){
            JOptionPane.showMessageDialog(this,"请选择分类");
            return;
        }
        if (sname == null || sname.isEmpty()){
            JOptionPane.showMessageDialog(this,"请输入分类名称");
            return;
        }
        //
        sort.setParent(parent);
        sort.setSdesc(sdesc);
        sort.setSname(sname);

        SortService sortService = new SortService();
        sortService.editSort(sort);
        this.dispose();
        JOptionPane.showMessageDialog(this,"编辑成功");
    }
}
