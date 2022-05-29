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
import com.jhq223.editor.controller.ViewController;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import com.jhq223.editor.model.FileModel;
import net.miginfocom.swing.*;

/**
 * @author 今何求
 */
public class RootView extends JFrame {
    public RootView() {
        initComponents();
    }


    //-----监听光标位置-----
    private void textPane1CaretUpdate(CaretEvent e) {
        Cxy.setText("第"+textPane1.getLineAtCaret()+"行,第"+textPane1.getColumnAtCaret()+"列");
    }

    //*****菜单事件*****

    //-----打开-----
    private void menuItem2(ActionEvent e) {
        var file =  FileModel.openFile();
        if (file != null) {
            textPane1.setText(FileModel.readFile(file));
            Mypath.setText(String.valueOf(file));
        }
    }

    //-----保存-----
    private void menuItem3(ActionEvent e) {
        String str = textPane1.getText();
        FileModel.saveFile(new File(Mypath.getText()),textPane1.getText());
    }

    //-----菜单退出-----
    private void menuItem5(ActionEvent e) {
       ViewController.exit(this);
    }

    //-----撤销-----
    private void menuItem13(ActionEvent e) {
         textPane1.getUndoManager().undo();
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
        String newname = JOptionPane.showInputDialog(null,"请输入文件名",new File(Mypath.getText()).getName());
        Mypath  .setText(FileModel.renameFile(new File(Mypath.getText()),newname));
    }

    //-----复制路径-----
    private void menuItem17(ActionEvent e) {
        String con = Mypath.getText();
        if (con != null) {
            StringSelection stringSelection = new StringSelection(con);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,stringSelection);
        }
    }

    //-----打开资源管理器-----
    private void menuItem18(ActionEvent e){
        try {
            java.awt.Desktop.getDesktop().open(new File(Mypath.getText()));
        } catch (IOException ioex){
            JOptionPane.showMessageDialog(null,"发生错误","错误",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void open(ActionEvent e) {
        // TODO add your code here
    }

    private void saveofbtn1(ActionEvent e) {
        // TODO add your code here
    }

    private void textPane1MouseReleased(MouseEvent e) {
        // TODO add your code here
    }

    private void MypathMouseReleased(MouseEvent e) {
        // TODO add your code here
    }

    private void CxyMouseReleased(MouseEvent e) {
        // TODO add your code here
    }

    //*****菜单事件*****

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - 今何求
        menuBar1 = new JMenuBar();
        filemenu = new JMenu();
        openbtn1 = new JMenuItem();
        savebtn1 = new JMenuItem();
        saveofbtn1 = new JMenuItem();
        exitbtn = new JMenuItem();
        editormenu = new JMenu();
        menuItem13 = new JMenuItem();
        menuItem1 = new JMenuItem();
        cutbtn1 = new JMenuItem();
        copybtn1 = new JMenuItem();
        menuItem16 = new JMenuItem();
        menu3 = new JMenu();
        menuItem7 = new JMenuItem();
        menuItem10 = new JMenuItem();
        deletebtn1 = new JMenuItem();
        allbtn1 = new JMenuItem();
        helpmenu = new JMenu();
        helpbtn = new JMenuItem();
        aboutbtn = new JMenuItem();
        scrollPane1 = new JScrollPane();
        textPane1 = new MyTextPane();
        Mypath = new JLabel();
        Cxy = new JLabel();
        sum = new JLabel();
        popupMenu1 = new JPopupMenu();
        menuItem17 = new JMenuItem();
        menuItem18 = new JMenuItem();
        menuItem19 = new JMenuItem();
        popupMenu2 = new JPopupMenu();
        menuItem20 = new JMenuItem();
        menuItem21 = new JMenuItem();
        menuItem22 = new JMenuItem();
        menuItem23 = new JMenuItem();
        menuItem24 = new JMenuItem();
        menu5 = new JMenu();
        menuItem26 = new JMenuItem();
        menuItem27 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menuItem25 = new JMenuItem();
        popupMenu3 = new JPopupMenu();
        menuItem3 = new JMenuItem();

        //======== this ========
        setMinimumSize(new Dimension(500, 400));
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "insets 0,hidemode 3,gap 5 5",
            // columns
            "[329,fill]" +
            "[50,fill]" +
            "[66,fill]" +
            "[36,fill]",
            // rows
            "[323,fill]" +
            "[28,fill]"));

        //======== menuBar1 ========
        {

            //======== filemenu ========
            {
                filemenu.setText("\u6587\u4ef6(F)");
                filemenu.setMnemonic('F');

                //---- openbtn1 ----
                openbtn1.setText("\u6253\u5f00(O)");
                openbtn1.setMnemonic('O');
                openbtn1.addActionListener(e -> open(e));
                filemenu.add(openbtn1);

                //---- savebtn1 ----
                savebtn1.setText("\u4fdd\u5b58(S)");
                savebtn1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
                savebtn1.setMnemonic('S');
                savebtn1.setEnabled(false);
                savebtn1.addActionListener(e -> menuItem3(e));
                filemenu.add(savebtn1);

                //---- saveofbtn1 ----
                saveofbtn1.setText("\u4fdd\u5b58\u4e3a");
                saveofbtn1.addActionListener(e -> saveofbtn1(e));
                filemenu.add(saveofbtn1);
                filemenu.addSeparator();

                //---- exitbtn ----
                exitbtn.setText("\u9000\u51fa(X)");
                exitbtn.setMnemonic('X');
                exitbtn.addActionListener(e -> menuItem5(e));
                filemenu.add(exitbtn);
            }
            menuBar1.add(filemenu);

            //======== editormenu ========
            {
                editormenu.setText("\u7f16\u8f91(E)");
                editormenu.setMnemonic('E');

                //---- menuItem13 ----
                menuItem13.setText("\u64a4\u9500(U)");
                menuItem13.setMnemonic('U');
                menuItem13.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK));
                menuItem13.setEnabled(false);
                menuItem13.addActionListener(e -> menuItem13(e));
                editormenu.add(menuItem13);

                //---- menuItem1 ----
                menuItem1.setText("\u6062\u590d(R)");
                menuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK|KeyEvent.SHIFT_DOWN_MASK));
                menuItem1.setEnabled(false);
                editormenu.add(menuItem1);
                editormenu.addSeparator();

                //---- cutbtn1 ----
                cutbtn1.setText("\u526a\u5207(T)");
                cutbtn1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));
                cutbtn1.setMnemonic('T');
                cutbtn1.addActionListener(e -> menuItem4(e));
                editormenu.add(cutbtn1);

                //---- copybtn1 ----
                copybtn1.setText("\u590d\u5236(C)");
                copybtn1.setMnemonic('C');
                copybtn1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
                copybtn1.addActionListener(e -> menuItem8(e));
                editormenu.add(copybtn1);

                //---- menuItem16 ----
                menuItem16.setText("\u7c98\u8d34(V)");
                menuItem16.setMnemonic('V');
                menuItem16.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));
                menuItem16.addActionListener(e -> menuItem16(e));
                editormenu.add(menuItem16);

                //======== menu3 ========
                {
                    menu3.setText("\u67e5\u627e(F)");
                    menu3.setMnemonic('F');

                    //---- menuItem7 ----
                    menuItem7.setText("\u67e5\u627e(F)");
                    menuItem7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK));
                    menuItem7.setMnemonic('F');
                    menu3.add(menuItem7);

                    //---- menuItem10 ----
                    menuItem10.setText("\u66ff\u6362(R)");
                    menuItem10.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK));
                    menuItem10.setMnemonic('R');
                    menu3.add(menuItem10);
                }
                editormenu.add(menu3);
                editormenu.addSeparator();

                //---- deletebtn1 ----
                deletebtn1.setText("\u5220\u9664(D)");
                deletebtn1.setMnemonic('D');
                deletebtn1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
                deletebtn1.addActionListener(e -> menuItem9(e));
                editormenu.add(deletebtn1);
                editormenu.addSeparator();

                //---- allbtn1 ----
                allbtn1.setText("\u5168\u9009(A)");
                allbtn1.setMnemonic('A');
                allbtn1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));
                allbtn1.addActionListener(e -> menuItem12(e));
                editormenu.add(allbtn1);
            }
            menuBar1.add(editormenu);

            //======== helpmenu ========
            {
                helpmenu.setText("\u5e2e\u52a9(H)");
                helpmenu.setMnemonic('H');

                //---- helpbtn ----
                helpbtn.setText("\u5e2e\u52a9(H)");
                helpbtn.setMnemonic('H');
                helpbtn.addActionListener(e -> menuItem14(e));
                helpmenu.add(helpbtn);

                //---- aboutbtn ----
                aboutbtn.setText("\u5173\u4e8e(A)");
                aboutbtn.setMnemonic('A');
                aboutbtn.addActionListener(e -> menuItem15(e));
                helpmenu.add(aboutbtn);
            }
            menuBar1.add(helpmenu);
        }
        setJMenuBar(menuBar1);

        //======== scrollPane1 ========
        {
            scrollPane1.setBorder(null);
            scrollPane1.setPreferredSize(null);

            //---- textPane1 ----
            textPane1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
            textPane1.addCaretListener(e -> textPane1CaretUpdate(e));
            textPane1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    textPane1MouseReleased(e);
                }
            });
            scrollPane1.setViewportView(textPane1);
        }
        contentPane.add(scrollPane1, "cell 0 0 4 1,dock center");

        //---- Mypath ----
        Mypath.setText("\u8def\u5f84");
        Mypath.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                MypathMouseReleased(e);
            }
        });
        contentPane.add(Mypath, "cell 0 1");

        //---- Cxy ----
        Cxy.setText("\u884c\u5217");
        Cxy.setHorizontalAlignment(SwingConstants.CENTER);
        Cxy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                CxyMouseReleased(e);
            }
        });
        contentPane.add(Cxy, "cell 1 1,aligny center,grow 100 0");

        //---- sum ----
        sum.setText("\u603b\u5b57\u7b26\u6570");
        sum.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(sum, "cell 3 1,aligny center,grow 100 0");
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

        //======== popupMenu2 ========
        {

            //---- menuItem20 ----
            menuItem20.setText("\u64a4\u9500(U)");
            menuItem20.setMnemonic('U');
            menuItem20.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK));
            popupMenu2.add(menuItem20);

            //---- menuItem21 ----
            menuItem21.setText("\u6062\u590d(R)");
            popupMenu2.add(menuItem21);
            popupMenu2.addSeparator();

            //---- menuItem22 ----
            menuItem22.setText("\u7c98\u8d34");
            popupMenu2.add(menuItem22);

            //---- menuItem23 ----
            menuItem23.setText("\u526a\u5207");
            popupMenu2.add(menuItem23);

            //---- menuItem24 ----
            menuItem24.setText("\u590d\u5236");
            popupMenu2.add(menuItem24);
            popupMenu2.addSeparator();

            //======== menu5 ========
            {
                menu5.setText("\u67e5\u627e");

                //---- menuItem26 ----
                menuItem26.setText("\u67e5\u627e");
                menu5.add(menuItem26);

                //---- menuItem27 ----
                menuItem27.setText("\u66ff\u6362");
                menu5.add(menuItem27);
            }
            popupMenu2.add(menu5);
            popupMenu2.addSeparator();

            //---- menuItem2 ----
            menuItem2.setText("\u5220\u9664");
            popupMenu2.add(menuItem2);
            popupMenu2.addSeparator();

            //---- menuItem25 ----
            menuItem25.setText("\u5168\u9009");
            popupMenu2.add(menuItem25);
        }

        //======== popupMenu3 ========
        {

            //---- menuItem3 ----
            menuItem3.setText("\u8df3\u8f6c\u5230\u884c");
            popupMenu3.add(menuItem3);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        textPane1.setShowLineNumber(true);
        Cxy.setText("第"+textPane1.getLineAtCaret()+"行,第"+textPane1.getColumnAtCaret()+"列");
        sum.setText("共"+textPane1.getDocument().getLength()+"字符");



        //-----text监听改变-----
        textPane1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
        public void insertUpdate(DocumentEvent e) {
            sum.setText("共"+textPane1.getDocument().getLength()+"字符");
            if (undoManager.canUndo()) {
                menuItem13.setEnabled(true);
            }else {
                menuItem13.setEnabled(false);
            }

        }

            @Override
            public void removeUpdate(DocumentEvent e) {
                sum.setText("共"+textPane1.getDocument().getLength()+"字符");
                if (undoManager.canUndo()) {
                    menuItem13.setEnabled(true);
                }else {
                    menuItem13.setEnabled(false);
                }

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                sum.setText("共"+textPane1.getDocument().getLength()+"字符");
                if (undoManager.canUndo()) {
                    menuItem13.setEnabled(true);
                }else {
                    menuItem13.setEnabled(false);
                }
            }
            UndoManager undoManager = textPane1.getUndoManager();
        });



                                                     }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - 今何求
    private JMenuBar menuBar1;
    private JMenu filemenu;
    private JMenuItem openbtn1;
    private JMenuItem savebtn1;
    private JMenuItem saveofbtn1;
    private JMenuItem exitbtn;
    private JMenu editormenu;
    private JMenuItem menuItem13;
    private JMenuItem menuItem1;
    private JMenuItem cutbtn1;
    private JMenuItem copybtn1;
    private JMenuItem menuItem16;
    private JMenu menu3;
    private JMenuItem menuItem7;
    private JMenuItem menuItem10;
    private JMenuItem deletebtn1;
    private JMenuItem allbtn1;
    private JMenu helpmenu;
    private JMenuItem helpbtn;
    private JMenuItem aboutbtn;
    private JScrollPane scrollPane1;
    private MyTextPane textPane1;
    private JLabel Mypath;
    private JLabel Cxy;
    private JLabel sum;
    private JPopupMenu popupMenu1;
    private JMenuItem menuItem17;
    private JMenuItem menuItem18;
    private JMenuItem menuItem19;
    private JPopupMenu popupMenu2;
    private JMenuItem menuItem20;
    private JMenuItem menuItem21;
    private JMenuItem menuItem22;
    private JMenuItem menuItem23;
    private JMenuItem menuItem24;
    private JMenu menu5;
    private JMenuItem menuItem26;
    private JMenuItem menuItem27;
    private JMenuItem menuItem2;
    private JMenuItem menuItem25;
    private JPopupMenu popupMenu3;
    private JMenuItem menuItem3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
