package com.seven.controller;

import com.seven.domain.Sort;
import com.seven.sevice.SortService;
import com.seven.view.AbstractOperationSortDialog;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;

/**
 * @ClassName:AddSortController
 * @Description: 添加分类对话框的控制器
 * @Author:Admin
 * @Date: 2019/1/2317:24
 * @version: 1.0
 */
public class AddSortController extends AbstractOperationSortDialog {
    public AddSortController(JDialog dialog) {
        super(dialog);
        titleLabel.setText("添加分类");
        super.setTitle("添加分类");
    }

    @Override
    public void initDialog() {
        super.initDialog();
    }

    /**
     * 添加分类的确定按钮
     * 实现步骤：
     *      1.数据验证
     *         验证分类选项
     *         验证分类名称
     *         如果数据不符合要求，提示对话框，从新输入
     *      2.将获取到的数据，封装成sort对象
     *         lid成员，不需要设置值
     *      3.将sort对象传递给service层处理
     *      4.service获取Sort对后,对象传递给dao层
     *      5.dao层中，将sort对象中的数据写入到数据库中 insert
     *      6.提示用户添加成功
     *      7.从新加载分类功能
     */
    @Override
    public void confirm() {
        //对添加功能的数据，进行验证
        //获取分类下拉菜单，用户选择的值
        //getSelectedItem()获取下拉菜单中选择的内容
        String parent = parentBox.getSelectedItem().toString();
        //获取分类名称
        String sname = snameTxt.getText().trim();
        //获取分类的描述
        String sddesc = sdescArea.getText();
        //验证下拉菜单
        //选择的内容，不等于 =请选择=
        if("=请选择=".equals(parent)){
            //必须选择一个，弹出对话框
            JOptionPane.showMessageDialog(this,"请选择分类","错误提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //验证分类名称,不是空即可
        if(sname == null ||sname.equals("")){
            JOptionPane.showMessageDialog(this,"请填写分类名称","错误提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //获取到的数据封装成Sort对象
        //利用构造方法赋值
        Sort sort = new Sort(0,sname,parent,sddesc);
//        sort.setParent(parent);
//        sort.setSname(sname);
//        sort.setSdesc(sddesc);
        //调用service层的SortService方法addSort() 传递Sort对象
        //创建service层的SortSerivce类的对象
        SortService sortService = new SortService();
        //调用对象方法addSort传递封装好的Sort对象
        sortService.addSort(sort);
        //提示用户，添加分类成功
        JOptionPane.showMessageDialog(this,"添加分类成功","操作成功",JOptionPane.PLAIN_MESSAGE);

        //关闭自己的弹框
        this.dispose();

    }
}
