/*
 * Copyright (c) 2022.
 *
 * 作者：今何求
 * 邮箱：jhq223@gmail.com
 *
 */

/*
 * Created by JFormDesigner on Thu May 19 12:46:41 CST 2022
 */

package com.jhq223.editor.view;

import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import javax.swing.event.*;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.jhq223.editor.control.fileControl;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @author 今何求
 */
public class Main extends JFrame {
    public Main() {
        initComponents();
    }


    //-----监听光标位置-----
    private void textPane1CaretUpdate(CaretEvent e) {
        label5.setText("第"+textPane1.getLineAtCaret()+"行,第"+textPane1.getColumnAtCaret()+"列");
    }


    //*****菜单事件*****

    //-----打开-----
    private void menuItem2(ActionEvent e) {
        var myfilecontrol = new fileControl();
        var file =  myfilecontrol.openFile();
        if (file != null) {
            textPane1.setText(myfilecontrol.readFile(file));
            label1.setText(String.valueOf(file));
        }
    }

    //-----保存-----
    private void menuItem3(ActionEvent e) {
        String str = textPane1.getText();
        var myfilecontrol = new fileControl();
        myfilecontrol.saveFile(new File(label1.getText()),textPane1.getText());
    }

    //-----菜单退出-----
    private void menuItem5(ActionEvent e) {
       exit();
    }

    //-----撤销-----
    private void menuItem13(ActionEvent e) {
        undoManager.undo();
    }

    //-----剪切-----
    private void menuItem4(ActionEvent e) {
        textPane1.cut();
    }

    //-----复制-----
    private void menuItem8(ActionEvent e) {
        textPane1.copy();
    }

    //-----粘贴-----
    private void menuItem16(ActionEvent e) {
        textPane1.paste();
    }

    //-----删除-----
    //P.S.将选择的文本替换为空
    private void menuItem9(ActionEvent e) {
        textPane1.replaceSelection(null);
    }

    //-----全选-----
    private void menuItem12(ActionEvent e) {
        textPane1.selectAll();
    }

    //-----帮助-----
    private void menuItem14(ActionEvent e) {
        JOptionPane.showMessageDialog(null,"最好的帮助就是没有帮助");
    }

    //-----关于-----
    private void menuItem15(ActionEvent e) {
        JOptionPane.showMessageDialog(null,"今何求的Java课设\n欢迎参考\n代码已开源至Github\n在Github上搜索jhq223即可找到我");
    }

    //-----路径菜单-----
    private void label1MouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
            popupMenu1.show(e.getComponent(),e.getX(),e.getY());
        }
    }


    //----重命名-----
    private void menuItem19(ActionEvent e) {
        String newname = JOptionPane.showInputDialog(null,"请输入文件名",new File(label1.getText()).getName());
        var filecontrol = new fileControl();
        label1.setText(filecontrol.renameFile(new File(label1.getText()),newname));
    }

    //-----复制路径-----
    private void menuItem17(ActionEvent e) {
        String con = label1.getText();
        if (con != null) {
            StringSelection stringSelection = new StringSelection(con);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,stringSelection);
        }
    }

    //-----打开资源管理器-----
    private void menuItem18(ActionEvent e){
        try {
            java.awt.Desktop.getDesktop().open(new File(label1.getText()));
        } catch (IOException ioex){
            JOptionPane.showMessageDialog(null,"发生错误","错误",JOptionPane.ERROR_MESSAGE);
        }
    }

    //-----退出方法-----
    private void exit() {
        if (JOptionPane.showConfirmDialog(this,"确认退出？","退出",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
            dispose();
            System.exit(0);
        }
    }

    //*****菜单事件*****

    //-----设置撤销监听器-----
    private UndoManager undoManager = new UndoManager();

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - 今何求
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem2 = new JMenuItem();
        menuItem3 = new JMenuItem();
        menuItem5 = new JMenuItem();
        menu2 = new JMenu();
        menuItem13 = new JMenuItem();
        menuItem4 = new JMenuItem();
        menuItem8 = new JMenuItem();
        menuItem16 = new JMenuItem();
        menuItem9 = new JMenuItem();
        menuItem12 = new JMenuItem();
        menu4 = new JMenu();
        menuItem14 = new JMenuItem();
        menuItem15 = new JMenuItem();
        scrollPane1 = new JScrollPane();
        textPane1 = new MyTextPane();
        label1 = new JLabel();
        label2 = new JLabel();
        label5 = new JLabel();
        popupMenu1 = new JPopupMenu();
        menuItem17 = new JMenuItem();
        menuItem18 = new JMenuItem();
        menuItem19 = new JMenuItem();

        //======== this ========
        setMinimumSize(new Dimension(500, 400));
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        var contentPane = getContentPane();

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u6587\u4ef6(F)");
                menu1.setMnemonic('F');

                //---- menuItem2 ----
                menuItem2.setText("\u6253\u5f00(O)");
                menuItem2.setMnemonic('O');
                menuItem2.addActionListener(e -> menuItem2(e));
                menu1.add(menuItem2);

                //---- menuItem3 ----
                menuItem3.setText("\u4fdd\u5b58(S)");
                menuItem3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
                menuItem3.setMnemonic('S');
                menuItem3.addActionListener(e -> menuItem3(e));
                menu1.add(menuItem3);
                menu1.addSeparator();

                //---- menuItem5 ----
                menuItem5.setText("\u9000\u51fa(X)");
                menuItem5.setMnemonic('X');
                menuItem5.addActionListener(e -> menuItem5(e));
                menu1.add(menuItem5);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("\u7f16\u8f91(E)");
                menu2.setMnemonic('E');

                //---- menuItem13 ----
                menuItem13.setText("\u64a4\u9500(U)");
                menuItem13.setMnemonic('U');
                menuItem13.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK));
                menuItem13.setEnabled(false);
                menuItem13.addActionListener(e -> menuItem13(e));
                menu2.add(menuItem13);
                menu2.addSeparator();

                //---- menuItem4 ----
                menuItem4.setText("\u526a\u5207(T)");
                menuItem4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));
                menuItem4.setMnemonic('T');
                menuItem4.addActionListener(e -> menuItem4(e));
                menu2.add(menuItem4);

                //---- menuItem8 ----
                menuItem8.setText("\u590d\u5236(C)");
                menuItem8.setMnemonic('C');
                menuItem8.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
                menuItem8.addActionListener(e -> menuItem8(e));
                menu2.add(menuItem8);

                //---- menuItem16 ----
                menuItem16.setText("\u7c98\u8d34(V)");
                menuItem16.setMnemonic('V');
                menuItem16.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));
                menuItem16.addActionListener(e -> menuItem16(e));
                menu2.add(menuItem16);

                //---- menuItem9 ----
                menuItem9.setText("\u5220\u9664(D)");
                menuItem9.setMnemonic('D');
                menuItem9.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
                menuItem9.addActionListener(e -> menuItem9(e));
                menu2.add(menuItem9);
                menu2.addSeparator();

                //---- menuItem12 ----
                menuItem12.setText("\u5168\u9009(A)");
                menuItem12.setMnemonic('A');
                menuItem12.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));
                menuItem12.addActionListener(e -> menuItem12(e));
                menu2.add(menuItem12);
            }
            menuBar1.add(menu2);

            //======== menu4 ========
            {
                menu4.setText("\u5e2e\u52a9(H)");
                menu4.setMnemonic('H');

                //---- menuItem14 ----
                menuItem14.setText("\u5e2e\u52a9(H)");
                menuItem14.setMnemonic('H');
                menuItem14.addActionListener(e -> menuItem14(e));
                menu4.add(menuItem14);

                //---- menuItem15 ----
                menuItem15.setText("\u5173\u4e8e(A)");
                menuItem15.setMnemonic('A');
                menuItem15.addActionListener(e -> menuItem15(e));
                menu4.add(menuItem15);
            }
            menuBar1.add(menu4);
        }
        setJMenuBar(menuBar1);

        //======== scrollPane1 ========
        {
            scrollPane1.setBorder(null);
            scrollPane1.setPreferredSize(new Dimension(7, 23));

            //---- textPane1 ----
            textPane1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
            textPane1.addCaretListener(e -> textPane1CaretUpdate(e));
            scrollPane1.setViewportView(textPane1);
        }

        //---- label1 ----
        label1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                label1MouseReleased(e);
            }
        });

        //---- label2 ----
        label2.setText("\u7edf\u8ba1");

        //---- label5 ----
        label5.setText("\u5149\u6807\u4f4d\u7f6e");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label1)
                    .addContainerGap(492, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(402, Short.MAX_VALUE)
                    .addComponent(label5)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(label2)
                    .addGap(12, 12, 12))
                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                    .addGap(5, 5, 5)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(label1)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label5)
                            .addComponent(label2)))
                    .addGap(5, 5, 5))
        );
        pack();
        setLocationRelativeTo(getOwner());

        //======== popupMenu1 ========
        {

            //---- menuItem17 ----
            menuItem17.setText("\u590d\u5236\u6587\u4ef6\u8def\u5f84");
            popupMenu1.add(menuItem17);

            //---- menuItem18 ----
            menuItem18.setText("\u6253\u5f00\u8def\u5f84\u6587\u4ef6\u5939");
            menuItem18.addActionListener(e -> menuItem18(e));
            popupMenu1.add(menuItem18);
            popupMenu1.addSeparator();

            //---- menuItem19 ----
            menuItem19.setText("\u91cd\u547d\u540d");
            menuItem19.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
            menuItem19.addActionListener(e -> menuItem19(e));
            popupMenu1.add(menuItem19);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        textPane1.setShowLineNumber(true);
        label5.setText("第"+textPane1.getLineAtCaret()+"行,第"+textPane1.getColumnAtCaret()+"列");
        label2.setText("共"+textPane1.getDocument().getLength()+"字符");


        //-----text监听改变-----
        textPane1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                label2.setText("共"+textPane1.getDocument().getLength()+"字符");
                if (undoManager.canUndo()) {
                    menuItem13.setEnabled(true);
                }else {
                    menuItem13.setEnabled(false);
                }

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                label2.setText("共"+textPane1.getDocument().getLength()+"字符");
                if (undoManager.canUndo()) {
                    menuItem13.setEnabled(true);
                }else {
                    menuItem13.setEnabled(false);
                }

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                label2.setText("共"+textPane1.getDocument().getLength()+"字符");
                if (undoManager.canUndo()) {
                    menuItem13.setEnabled(true);
                }else {
                    menuItem13.setEnabled(false);
                }
            }
        });

        textPane1.getDocument().addUndoableEditListener(undoManager);

        //-----点击退出后调用该方法-----
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                exit();
            }
        });

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - 今何求
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem2;
    private JMenuItem menuItem3;
    private JMenuItem menuItem5;
    private JMenu menu2;
    private JMenuItem menuItem13;
    private JMenuItem menuItem4;
    private JMenuItem menuItem8;
    private JMenuItem menuItem16;
    private JMenuItem menuItem9;
    private JMenuItem menuItem12;
    private JMenu menu4;
    private JMenuItem menuItem14;
    private JMenuItem menuItem15;
    private JScrollPane scrollPane1;
    private MyTextPane textPane1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label5;
    private JPopupMenu popupMenu1;
    private JMenuItem menuItem17;
    private JMenuItem menuItem18;
    private JMenuItem menuItem19;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args) {
        //-----初始化主题-----
        try {
            UIManager.setLookAndFeel( new FlatDarculaLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }

        Frame root = new Main();
        root.setTitle("文本编辑器");
        root.setVisible(true);
    }


}
