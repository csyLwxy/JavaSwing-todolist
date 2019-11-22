package todolist.ui.button;

import todolist.ui.ToDoList;
import todolist.ui.panel.AddTaskPanel;

import javax.swing.*;
import java.awt.*;

public class AddButton extends JButton {

    public AddButton(ToDoList frame) {
        setText("Add");
        setAlignmentX(Component.CENTER_ALIGNMENT);
        addActionListener(event -> {
            new AddTaskPanel(frame);
        });
    }
}
