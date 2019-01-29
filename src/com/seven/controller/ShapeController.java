package com.seven.controller;

import com.seven.view.AbstractShapeDialog;

import javax.swing.*;
import java.util.List;

/**
 * @ClassName:ShapeController
 * @Description:TODO
 * @Author:Admin
 * @Date: 2019/1/2614:37
 * @version: 1.0
 */
public class ShapeController extends AbstractShapeDialog {


    public ShapeController(JDialog dialog) {
        super(dialog);
    }

    @Override
    public List<String> getImagePaths() {
        return null;
    }
}
