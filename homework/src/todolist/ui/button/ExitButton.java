package todolist.ui.button;

import todolist.ui.ToDoList;
import todolist.ui.util.FileTool;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ExitButton extends JButton {

    public ExitButton(ToDoList frame) {
        setText("Exit");
        setAlignmentX(Component.CENTER_ALIGNMENT);
        addActionListener(event -> {
            String filePath = "./ToDoList/todolist";
            File file = new File(filePath);
            FileTool.SaveFile(frame, file);
            System.exit(0);
        });
    }
}
