package todolist.ui.button;

import todolist.ui.ToDoList;
import todolist.ui.util.FileTool;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * "Save" 按键
 * @author wxy
 */
public class SaveButton extends JButton {

    public SaveButton(ToDoList frame) {
        setText("Save");
        setAlignmentX(Component.CENTER_ALIGNMENT);
        addActionListener(event -> {
            String filePath = "./ToDoList/todolist";
            File file = new File(filePath);
            FileTool.SaveFile(frame, file);
        });
    }
}
