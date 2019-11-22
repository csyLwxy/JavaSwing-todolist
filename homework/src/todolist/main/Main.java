package todolist.main;

import todolist.ui.ToDoList;
import todolist.ui.util.FileTool;

import java.awt.*;
import java.io.File;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ToDoList toDoList = new ToDoList();
            try {
                String filePath = "./ToDoList/todolist";
                File file = new File(filePath);
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileTool.ImportToMyToDoList(toDoList, file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}