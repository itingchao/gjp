package com.seven.app;


import com.seven.controller.MainFrameController;

/*
 * 整个项目的起始入口
 */
public class MainApp {
	public static void main(String[] args) {
		//开启主窗体，创建他的子类对象
		new MainFrameController().setVisible(true);
	}
}
