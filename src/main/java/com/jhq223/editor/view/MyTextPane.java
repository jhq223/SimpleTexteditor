/*
 * Copyright (c) 2022.
 *
 * 作者：今何求
 * 邮箱：jhq223@gmail.com
 *
 */

package com.jhq223.editor.view;

import javax.swing.*;
import javax.swing.text.Element;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class MyTextPane extends JTextPane {
    private boolean showLineNumber = false;

    //总行数
    private int rows;

    //文本框总字符数
    private int sumnumber;

    //光标所在行
    private int lineAtCaret;

    //所在列
    private int ColumnAtCaret;


    public int getLineAtCaret() {
        StyledDocument docu = getStyledDocument();
        Element element = docu.getDefaultRootElement();
        int carePosition = getCaretPosition();
        return element.getElementIndex(carePosition)+1;
    }

    public int getColumnAtCaret() {
        StyledDocument docu = getStyledDocument();
        Element element = docu.getDefaultRootElement();
        int carePosition = getCaretPosition();
        int line= element.getElementIndex(carePosition);
        int linestart = element.getElement(line).getStartOffset();
        return carePosition-linestart+1;
    }


    public int getRows() {
        StyledDocument docu = getStyledDocument();
        Element element = docu.getDefaultRootElement();
        return element.getElementCount();
    }

    public int getSumnumber() {
        StyledDocument docu = getStyledDocument();
        return docu.getLength();
    }

    public boolean isShowLineNumber() {
        return showLineNumber;
    }

    public void setShowLineNumber(boolean showLineNumber) {
        this.showLineNumber = showLineNumber;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(isShowLineNumber()){
            drawLineNumber(g);
        }
    }


    protected void drawLineNumber(Graphics g){
        setMargin(new Insets(0,30,0,0));
        g.setColor(new Color(49, 51, 53));
        g.fillRect(0,0,30,getHeight());

        g.setColor(new Color(213, 221, 239));
        g.setFont(getFont());
        int Si = getFont().getSize();
        for (int i = 0; i < getRows(); i++) {
            if (i<9) {
                g.drawString("  "+String.valueOf(i+1),0,(i+1)*(Si+6)-6);
            } else if (i<99) {
                g.drawString(" "+String.valueOf(i+1),0,(i+1)*(Si+6)-6);
            }else {
                g.drawString(String.valueOf(i+1),0,(i+1)*(Si+6)-6);
            }

        }
    }



}
