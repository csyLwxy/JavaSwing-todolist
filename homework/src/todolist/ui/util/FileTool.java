package todolist.ui.util;

import todolist.ui.ToDoList;

import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileTool {

    public static void ImportToMyToDoList(ToDoList frame, File file) {
        try {
            FileInputStream in = new FileInputStream(file);
            int length = in.available();
            if (length != 0){
                byte[] buffer = new byte[length];
                in.read(buffer);
                String str = new String(buffer, StandardCharsets.UTF_8);
                // 由于可能匹配正则表达式，所以"$"需要转义
                String[] strings = str.split("\\$\\$");
                for (int i = 0; i < strings.length; i += frame.getModel().getColumnCount()) {
                    Object[] row = new Object[frame.getModel().getColumnCount()];
                    for (int j = 0; j < frame.getModel().getColumnCount() - 1; ++j) {
                        row[j] = strings[i + j];
                    }
                    row[frame.getModel().getColumnCount() - 1] = Boolean.parseBoolean(strings[i + frame.getModel().getColumnCount() - 1]);
                    frame.getModel().addRow(row);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void OutputToFile(ToDoList frame) {
        JFileChooser chooser = new JFileChooser();

        //下面的方法将阻塞，直到【用户按下保存按钮且“文件名”文本框不为空】或【用户按下取消按钮】
        int option = chooser.showSaveDialog(null);
        //假如用户选择了保存
        if(option == JFileChooser.APPROVE_OPTION){
            File file = chooser.getSelectedFile();
            SaveFile(frame, file);
        }
    }

    public static void SaveFile(ToDoList frame, File file) {
        try {
            //写文件操作……
            PrintStream ps = new PrintStream(new FileOutputStream(file));
            ps.print('\0');
            int size = frame.getTable().getRowCount();
            for (int i = 0; i < size; ++i) {
                for (int j = 0; j < frame.getModel().getColumnCount(); ++j) {
                    // 往文件里写入字符串
                    ps.append(frame.getModel().getValueAt(i, j) + "$$");
                }
            }
            ps.close();
        } catch (IOException e) {
            System.err.println("IO异常");
            e.printStackTrace();
        }
    }
}
