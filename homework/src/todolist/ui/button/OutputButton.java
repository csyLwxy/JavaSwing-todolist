package todolist.ui.button;

import todolist.ui.ToDoList;
import todolist.ui.util.FileTool;

import javax.swing.*;
import java.awt.*;

public class OutputButton extends JButton {

    public OutputButton(ToDoList frame) {
        setText("Output");
        setAlignmentX(Component.CENTER_ALIGNMENT);

        addActionListener(event -> {
            FileTool.OutputToFile(frame);
        });
    }
}
