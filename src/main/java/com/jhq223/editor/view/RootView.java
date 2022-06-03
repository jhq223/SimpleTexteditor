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

    /**
    *监听事件
    */

    //-----监听光标位置-----
    private void textPane1CaretUpdate(CaretEvent e) {
        Cxy.setText("第"+textPane1.getLineAtCaret()+"行,第"+textPane1.getColumnAtCaret()+"列");
    }

    private void textPane1MouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
            popupMenu2.show(e.getComponent(),e.getX(),e.getY());
        }
    }

    private void MypathMouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
            popupMenu1.show(e.getComponent(),e.getX(),e.getY());
        }
    }

    private void CxyMouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
            popupMenu3.show(e.getComponent(),e.getX(),e.getY());
        }
    }

    /**
     * 菜单事件
     */

    //-----打开-----
    private void open(ActionEvent e) {
        var file =  FileModel.openFile();
        if (file != null) {
            textPane1.setText(FileModel.readFile(file));
            Mypath.setVisible(true);
            Mypath.setText(String.valueOf(file));
            savebtn1.setEnabled(true);
        }
    }

    //-----保存-----
    private void save(ActionEvent e) {
        String str = textPane1.getText();
        FileModel.saveFile(new File(Mypath.getText()),textPane1.getText());
    }

    //===== 保存为 =====
    private void saveofbtn1(ActionEvent e) {
        var file =  FileModel.saveofFile(textPane1);
        if (file != null) {
            textPane1.setText(FileModel.readFile(file));
            Mypath.setVisible(true);
            Mypath.setText(String.valueOf(file));
            savebtn1.setEnabled(true);
        }
    }

    //-----菜单退出-----
    private void exitbtn(ActionEvent e) {
       ViewController.exit(this);
    }

    //***** 菜单2 *****

    //-----撤销-----
    private void undo(ActionEvent e) {
         textPane1.getUndoManager().undo();
    }

    //===== 恢复 =====
    private void redo(ActionEvent e) {
        textPane1.getUndoManager().redo();
    }


    //-----剪切-----
    private void cut(ActionEvent e) {
        textPane1.cut();
    }

    //-----复制-----
    private void copy(ActionEvent e) {
        textPane1.copy();
    }

    //-----粘贴-----
    private void paste(ActionEvent e) {
        textPane1.paste();
    }

    //-----删除-----
    //P.S.将选择的文本替换为空
    private void delete(ActionEvent e) {
        textPane1.replaceSelection(null);
    }

    //-----全选-----
    private void all(ActionEvent e) {
        textPane1.selectAll();
    }

    //===== 搜索 =====
    private void search(ActionEvent e) {
        searchrootbar.setVisible(true);
        replacebar.setVisible(false);
    }

    //===== 替换 =====
    private void replace(ActionEvent e) {
        searchrootbar.setVisible(true);
    }


    //***** 菜单3 *****

    //-----帮助-----
    private void help(ActionEvent e) {
        JOptionPane.showMessageDialog(null,"最好的帮助就是没有帮助");
    }

    //-----关于-----
    private void about(ActionEvent e) {
        JOptionPane.showMessageDialog(null,"今何求的Java课设\n欢迎参考\n代码已开源至Github\n在Github上搜索jhq223即可找到我");
    }

    //-----路径菜单-----
    private void label1MouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
            popupMenu1.show(e.getComponent(),e.getX(),e.getY());
        }
    }

  //***** 弹出菜单1 *****
    //----重命名-----
    private void rename(ActionEvent e) {
        String newname = JOptionPane.showInputDialog(null,"请输入文件名",new File(Mypath.getText()).getName());
        Mypath  .setText(FileModel.renameFile(new File(Mypath.getText()),newname));
    }

    //-----复制路径-----
    private void copypath(ActionEvent e) {
        String con = Mypath.getText();
        if (con != null) {
            StringSelection stringSelection = new StringSelection(con);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,stringSelection);
        }
    }

    //-----打开资源管理器-----
    private void openpath(ActionEvent e){
        try {
            java.awt.Desktop.getDesktop().open(new File(Mypath.getText()));
        } catch (IOException ioex){
            JOptionPane.showMessageDialog(null,"发生错误","错误",JOptionPane.ERROR_MESSAGE);
        }
    }

    //***** 弹出菜单3 *****

    private void cxygo(ActionEvent e) {
        // TODO add your code here
    }

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
        undobtn1 = new JMenuItem();
        redobtn1 = new JMenuItem();
        cutbtn1 = new JMenuItem();
        copybtn1 = new JMenuItem();
        pastebtn = new JMenuItem();
        menu3 = new JMenu();
        searchbtn1 = new JMenuItem();
        replacebtn1 = new JMenuItem();
        deletebtn1 = new JMenuItem();
        allbtn1 = new JMenuItem();
        helpmenu = new JMenu();
        helpbtn = new JMenuItem();
        aboutbtn = new JMenuItem();
        searchrootbar = new JPanel();
        searchbar = new JPanel();
        searchtext = new JTextField();
        isreplaece = new JCheckBox();
        lastbtn = new JButton();
        nextbtn = new JButton();
        closebtn = new JButton();
        replacebar = new JPanel();
        textField2 = new JTextField();
        replaecebtn = new JButton();
        scrollPane1 = new JScrollPane();
        textPane1 = new MyTextPane();
        Mypath = new JLabel();
        Cxy = new JLabel();
        sum = new JLabel();
        popupMenu1 = new JPopupMenu();
        copypath = new JMenuItem();
        openpath = new JMenuItem();
        rename = new JMenuItem();
        popupMenu2 = new JPopupMenu();
        undobtn2 = new JMenuItem();
        redobtn2 = new JMenuItem();
        pastebtn2 = new JMenuItem();
        cutbtn2 = new JMenuItem();
        copybtn2 = new JMenuItem();
        menu5 = new JMenu();
        searchbtn2 = new JMenuItem();
        replacebtn2 = new JMenuItem();
        deletebtn2 = new JMenuItem();
        allbtn2 = new JMenuItem();
        popupMenu3 = new JPopupMenu();
        cxygo = new JMenuItem();

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
            "rel[0,fill]rel" +
            "[0]rel" +
            "[310,fill]rel" +
            "[30]2" +
            "[fill]2"));

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
                savebtn1.addActionListener(e -> save(e));
                filemenu.add(savebtn1);

                //---- saveofbtn1 ----
                saveofbtn1.setText("\u4fdd\u5b58\u4e3a");
                saveofbtn1.addActionListener(e -> saveofbtn1(e));
                filemenu.add(saveofbtn1);
                filemenu.addSeparator();

                //---- exitbtn ----
                exitbtn.setText("\u9000\u51fa(X)");
                exitbtn.setMnemonic('X');
                exitbtn.addActionListener(e -> exitbtn(e));
                filemenu.add(exitbtn);
            }
            menuBar1.add(filemenu);

            //======== editormenu ========
            {
                editormenu.setText("\u7f16\u8f91(E)");
                editormenu.setMnemonic('E');

                //---- undobtn1 ----
                undobtn1.setText("\u64a4\u9500(U)");
                undobtn1.setMnemonic('U');
                undobtn1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK));
                undobtn1.setEnabled(false);
                undobtn1.addActionListener(e -> undo(e));
                editormenu.add(undobtn1);

                //---- redobtn1 ----
                redobtn1.setText("\u6062\u590d(R)");
                redobtn1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK|KeyEvent.SHIFT_DOWN_MASK));
                redobtn1.setEnabled(false);
                redobtn1.addActionListener(e -> redo(e));
                editormenu.add(redobtn1);
                editormenu.addSeparator();

                //---- cutbtn1 ----
                cutbtn1.setText("\u526a\u5207(T)");
                cutbtn1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));
                cutbtn1.setMnemonic('T');
                cutbtn1.addActionListener(e -> cut(e));
                editormenu.add(cutbtn1);

                //---- copybtn1 ----
                copybtn1.setText("\u590d\u5236(C)");
                copybtn1.setMnemonic('C');
                copybtn1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
                copybtn1.addActionListener(e -> copy(e));
                editormenu.add(copybtn1);

                //---- pastebtn ----
                pastebtn.setText("\u7c98\u8d34(V)");
                pastebtn.setMnemonic('V');
                pastebtn.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));
                pastebtn.addActionListener(e -> paste(e));
                editormenu.add(pastebtn);

                //---- deletebtn1 ----
                deletebtn1.setText("\u5220\u9664(D)");
                deletebtn1.setMnemonic('D');
                deletebtn1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
                deletebtn1.addActionListener(e -> delete(e));
                editormenu.add(deletebtn1);
                editormenu.addSeparator();

                //---- allbtn1 ----
                allbtn1.setText("\u5168\u9009(A)");
                allbtn1.setMnemonic('A');
                allbtn1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));
                allbtn1.addActionListener(e -> all(e));
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
                helpbtn.addActionListener(e -> help(e));
                helpmenu.add(helpbtn);

                //---- aboutbtn ----
                aboutbtn.setText("\u5173\u4e8e(A)");
                aboutbtn.setMnemonic('A');
                aboutbtn.addActionListener(e -> about(e));
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
        contentPane.add(scrollPane1, "cell 0 0 4 3,dock center");

        //---- Mypath ----
        Mypath.setText("\u8def\u5f84");
        Mypath.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                MypathMouseReleased(e);
            }
        });
        contentPane.add(Mypath, "cell 0 3");

        //---- Cxy ----
        Cxy.setText("\u884c\u5217");
        Cxy.setHorizontalAlignment(SwingConstants.CENTER);
        Cxy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                CxyMouseReleased(e);
            }
        });
        contentPane.add(Cxy, "cell 2 3");

        //---- sum ----
        sum.setText("\u603b\u5b57\u7b26\u6570");
        sum.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(sum, "cell 3 3");
        pack();
        setLocationRelativeTo(getOwner());

        //======== popupMenu1 ========
        {

            //---- copypath ----
            copypath.setText("\u590d\u5236\u6587\u4ef6\u8def\u5f84");
            copypath.addActionListener(e -> copypath(e));
            popupMenu1.add(copypath);

            //---- openpath ----
            openpath.setText("\u6253\u5f00\u8def\u5f84\u6587\u4ef6\u5939");
            openpath.addActionListener(e -> openpath(e));
            popupMenu1.add(openpath);
            popupMenu1.addSeparator();

            //---- rename ----
            rename.setText("\u91cd\u547d\u540d");
            rename.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
            rename.addActionListener(e -> rename(e));
            popupMenu1.add(rename);
        }

        //======== popupMenu2 ========
        {

            //---- undobtn2 ----
            undobtn2.setText("\u64a4\u9500(U)");
            undobtn2.setMnemonic('U');
            undobtn2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK));
            undobtn2.setEnabled(false);
            undobtn2.addActionListener(e -> undo(e));
            popupMenu2.add(undobtn2);

            //---- redobtn2 ----
            redobtn2.setText("\u6062\u590d(R)");
            redobtn2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK|KeyEvent.SHIFT_DOWN_MASK));
            redobtn2.setMnemonic('R');
            redobtn2.setEnabled(false);
            redobtn2.addActionListener(e -> redo(e));
            popupMenu2.add(redobtn2);
            popupMenu2.addSeparator();

            //---- pastebtn2 ----
            pastebtn2.setText("\u7c98\u8d34(V)");
            pastebtn2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));
            pastebtn2.setMnemonic('V');
            pastebtn2.addActionListener(e -> paste(e));
            popupMenu2.add(pastebtn2);

            //---- cutbtn2 ----
            cutbtn2.setText("\u526a\u5207(T)");
            cutbtn2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));
            cutbtn2.setMnemonic('T');
            cutbtn2.addActionListener(e -> cut(e));
            popupMenu2.add(cutbtn2);

            //---- copybtn2 ----
            copybtn2.setText("\u590d\u5236(C)");
            copybtn2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
            copybtn2.setMnemonic('C');
            copybtn2.addActionListener(e -> copy(e));
            popupMenu2.add(copybtn2);
            popupMenu2.addSeparator();

            //---- deletebtn2 ----
            deletebtn2.setText("\u5220\u9664(D)");
            deletebtn2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK));
            deletebtn2.setMnemonic('D');
            deletebtn2.addActionListener(e -> delete(e));
            popupMenu2.add(deletebtn2);
            popupMenu2.addSeparator();

            //---- allbtn2 ----
            allbtn2.setText("\u5168\u9009(A)");
            allbtn2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));
            allbtn2.setMnemonic('A');
            allbtn2.addActionListener(e -> all(e));
            popupMenu2.add(allbtn2);
        }

        //======== popupMenu3 ========
        {

            //---- cxygo ----
            cxygo.setText("\u8df3\u8f6c\u5230\u884c");
            cxygo.addActionListener(e -> cxygo(e));
            popupMenu3.add(cxygo);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        textPane1.setShowLineNumber(true);
        Mypath.setVisible(false);
        Cxy.setText("第"+textPane1.getLineAtCaret()+"行,第"+textPane1.getColumnAtCaret()+"列");
        sum.setText("共"+textPane1.getDocument().getLength()+"字符");


        //-----text监听改变-----
        textPane1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                sum.setText("共"+textPane1.getDocument().getLength()+"字符");
                if (undoManager.canUndo()) {
                    undobtn1.setEnabled(true);
                    undobtn2.setEnabled(true);
                }else {
                    undobtn1.setEnabled(false);
                    undobtn2.setEnabled(false);
                }
                if (undoManager.canRedo()) {
                    redobtn1.setEnabled(true);
                    redobtn2.setEnabled(true);
                }else {
                    redobtn1.setEnabled(false);
                    redobtn2.setEnabled(false);
                }

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                sum.setText("共"+textPane1.getDocument().getLength()+"字符");
                if (undoManager.canUndo()) {
                    undobtn1.setEnabled(true);
                    undobtn2.setEnabled(true);
                }else {
                    undobtn1.setEnabled(false);
                    undobtn2.setEnabled(false);
                }

                if (undoManager.canRedo()) {
                    redobtn1.setEnabled(true);
                    redobtn2.setEnabled(true);
                }else {
                    redobtn1.setEnabled(false);
                    redobtn2.setEnabled(false);
                }

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                sum.setText("共"+textPane1.getDocument().getLength()+"字符");
                if (undoManager.canUndo()) {
                    undobtn1.setEnabled(true);
                    undobtn2.setEnabled(true);
                }else {
                    undobtn1.setEnabled(false);
                    undobtn2.setEnabled(false);
                }

                if (undoManager.canRedo()) {
                    redobtn1.setEnabled(true);
                    redobtn2.setEnabled(true);
                }else {
                    redobtn1.setEnabled(false);
                    redobtn2.setEnabled(false);
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
    private JMenuItem undobtn1;
    private JMenuItem redobtn1;
    private JMenuItem cutbtn1;
    private JMenuItem copybtn1;
    private JMenuItem pastebtn;
    private JMenu menu3;
    private JMenuItem searchbtn1;
    private JMenuItem replacebtn1;
    private JMenuItem deletebtn1;
    private JMenuItem allbtn1;
    private JMenu helpmenu;
    private JMenuItem helpbtn;
    private JMenuItem aboutbtn;
    private JPanel searchrootbar;
    private JPanel searchbar;
    private JTextField searchtext;
    private JCheckBox isreplaece;
    private JButton lastbtn;
    private JButton nextbtn;
    private JButton closebtn;
    private JPanel replacebar;
    private JTextField textField2;
    private JButton replaecebtn;
    private JScrollPane scrollPane1;
    private MyTextPane textPane1;
    private JLabel Mypath;
    private JLabel Cxy;
    private JLabel sum;
    private JPopupMenu popupMenu1;
    private JMenuItem copypath;
    private JMenuItem openpath;
    private JMenuItem rename;
    private JPopupMenu popupMenu2;
    private JMenuItem undobtn2;
    private JMenuItem redobtn2;
    private JMenuItem pastebtn2;
    private JMenuItem cutbtn2;
    private JMenuItem copybtn2;
    private JMenu menu5;
    private JMenuItem searchbtn2;
    private JMenuItem replacebtn2;
    private JMenuItem deletebtn2;
    private JMenuItem allbtn2;
    private JPopupMenu popupMenu3;
    private JMenuItem cxygo;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
