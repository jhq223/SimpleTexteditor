/*
 * Copyright (c) 2022.
 *
 * 作者：今何求
 * 邮箱：jhq223@gmail.com
 *
 */

package com.jhq223.editor.controller;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.jhq223.editor.view.RootView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ViewController {

    private Frame root;

    public ViewController() {
        root = new Frame();
    }

    //-----退出方法-----
    public static void exit(RootView rootView) {
        if (JOptionPane.showConfirmDialog(null, "确认退出？", "退出", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
            rootView.dispose();
            System.exit(0);
        }
    }


    public static void main(String[] args) {

        //-----初始化主题-----
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        //===== 初始化程序 =====
        Frame root = new RootView();
        root.setTitle("文本编辑器");
        root.setVisible(true);

        //-----点击退出后调用该方法-----
        root.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                exit((RootView) root);
            }
        });
    }
}
