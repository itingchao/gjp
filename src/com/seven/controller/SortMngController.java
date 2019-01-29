package com.seven.controller;

import com.seven.domain.Sort;
import com.seven.sevice.SortService;
import com.seven.view.AbstractSortMngDialog;

import javax.swing.*;
import java.util.List;

/**
 * @ClassName:SortMngController
 * @Description:TODO
 * @Author:Admin
 * @Date: 2019/1/1622:23
 * @version: 1.0
 */
public class SortMngController extends AbstractSortMngDialog {


    //成员位置创建出service层SortService类对象
    private SortService sortService = new SortService();

    public SortMngController(JFrame frame) {
        super(frame);
        //向表格中填充分类数据，在构造方法中实现
        //setTableModel 方法，传递List<Sort>集合
        /**
         * 实现步骤
         * 1\调用service层中，获取出list集合
         * 2、service层掉dao层，获取list集合
         * 3、dao层，查询数据库，数据表中的结果集变成List集合，返回
         * 4、调用父类方法setTableModel
         */
        refresh();
    }

    @Override
    protected void initDialog() {
        super.initDialog();
    }

    @Override
    protected void setTableModel(List<Sort> sortList) {
        super.setTableModel(sortList);
    }

    @Override
    protected Sort getSortByTableRow(int row) {
        return super.getSortByTableRow(row);
    }

    /**
     * 添加分类按钮点击后，调用的方法
     */
    @Override
    public void addSort() {

        new AddSortController(this).setVisible(true);
        //添加成功之后，需要重新刷新数据
        refresh();
    }

    @Override
    public void editSort() {
        //获取用户选中的行号
        int row = sortDataTable.getSelectedRow();

        if (row < 0){
            JOptionPane.showMessageDialog(this,"请选择数据");
            return;
        }
        //System.out.println(row);
        //getSortByTableRow 传递行号，返回这一行的数据，封装sort对象
        Sort sort = getSortByTableRow(row);
        //System.out.println(sort);
        if (sort == null){
            JOptionPane.showMessageDialog(this,"请选择有数据的行");
            return;
        }

        new EditSortController(this,sort).setVisible(true);
        refresh();
    }

    @Override
    public void deleteSort() {
        int row = sortDataTable.getSelectedRow();

        if (row < 0){
            JOptionPane.showMessageDialog(this,"请选择数据");
            return;
        }
        Sort sort = getSortByTableRow(row);
        //System.out.println(sort);
        if (sort == null){
            JOptionPane.showMessageDialog(this,"请选择有数据的行");
            return;
        }
        sortService.deleteSort(sort);
        JOptionPane.showMessageDialog(this,"确定删除这个分类吗");
        refresh();
    }

    /**
     * 刷新显示分类数据
     *
     */
    private void refresh(){
        List<Sort> list = sortService.querySortAll();
        super.setTableModel(list);
    }
}

