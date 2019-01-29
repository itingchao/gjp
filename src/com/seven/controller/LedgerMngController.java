package com.seven.controller;

import com.seven.view.AbstractLedgerMngDialog;

import javax.swing.*;

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

    }

    @Override
    public void pie() {
        new ShapeController(this).setVisible(true);
    }
}
