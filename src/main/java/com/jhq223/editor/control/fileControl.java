/*
 * Copyright (c) 2022.
 *
 * 作者：今何求
 * 邮箱：jhq223@gmail.com
 *
 */

package com.jhq223.editor.control;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class fileControl extends Component {

    //-----打开文件-----
    public File openFile(){
        var fileChooser = new JFileChooser();
        var filter = new FileNameExtensionFilter("文本","txt");
        fileChooser.addChoosableFileFilter(filter);
        int ret = fileChooser.showOpenDialog(fileChooser);
        if (ret == JFileChooser .APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }

    //-----读取文件-----
    public String readFile(File file){
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(String.valueOf(file.getAbsoluteFile()))));
        } catch (IOException ex){
            JOptionPane.showMessageDialog(this,"无法打开文件","Error",JOptionPane.ERROR_MESSAGE);
        }
        return content;
    }


    //-----保存文件-----
    public void saveFile(File file,String str){
        try {
            var fileWriter = new FileWriter(file);
            fileWriter.write(str);
            fileWriter.close();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null,"发生错误,可能是未打开文件","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    //-----重命名-----
    public String renameFile(File file,String newname){
        String str = String.valueOf(file);
        String oldname = file.getName();
        String newstr = str.replace(oldname,newname);
        if (file.renameTo(new File(newstr))){
            JOptionPane.showMessageDialog(null,"成功");
        }
        return newstr;

    }

}
