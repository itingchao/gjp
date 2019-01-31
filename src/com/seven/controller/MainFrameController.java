package com.seven.controller;

import com.seven.domain.Sort;
import com.seven.view.AbstractMainFrame;
import com.seven.view.AbstractSortMngDialog;

import javax.swing.*;
import java.util.List;

/**
 * @ClassName:MainFrameController
 * @Description:TODO
 * @Author:Admin
 * @Date: 2019/1/1622:06
 * @version: 1.0
 */
public class MainFrameController extends AbstractMainFrame {

    public MainFrameController() {
        super();
    }

    /**
     * 重写主窗体类的抽象方法
     * 打开账务管理对话框
     */
    @Override
    public void ledgerMng() {
        new LedgerMngController(this).setVisible(true);
    }

    /**
     * 重写主窗体类的抽象方法
     * 打开分类管理对话框
     */

    @Override
    public void sortMng() {
        //创建分类对话框的子类对象
        new SortMngController(this).setVisible(true);
    }

}
