package todolist.ui.button;

import todolist.ui.ToDoList;
import todolist.ui.panel.EditTaskPanel;

import javax.swing.*;
import java.awt.*;

/**
 *  "Edit" 按键
 * @author wxy
 */
public class EditButton extends JButton {

    public EditButton(ToDoList frame) {
        setText("Edit");
        setAlignmentX(Component.CENTER_ALIGNMENT);
        addActionListener(event -> {
            int row = frame.getTable().getSelectedRow();
            if (row >= 0) {
                new EditTaskPanel(frame, row);
            } else {
                JOptionPane.showMessageDialog(frame.getButtonPanel(), "You haven't chosen an entry to modify!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
