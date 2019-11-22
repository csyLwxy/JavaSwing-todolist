package todolist.ui.button;

import todolist.ui.ToDoList;

import javax.swing.*;
import java.awt.*;

public class DeleteButton extends JButton {

    public DeleteButton(ToDoList frame) {
        setText("Delete");
        setAlignmentX(Component.CENTER_ALIGNMENT);
        addActionListener(event -> {
            int row = frame.getTable().getSelectedRow();
            if (row >= 0) {
                int delConfirm = JOptionPane.showConfirmDialog(frame.getButtonPanel(), "Are you sure you want to delete this entry?",
                        "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (delConfirm == 0) {
                    frame.getModel().removeRow(row);
                }
            } else {
                JOptionPane.showMessageDialog(frame.getButtonPanel(), "You haven't chosen an entry to delete!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
