package todolist.ui.button;

import todolist.ui.ToDoList;

import javax.swing.*;
import java.awt.*;

/**
 * A Button in buttonPanel to make a table row to the top
 */
public class TopButton extends JButton {

    public TopButton(ToDoList frame) {
        setText("Top");
        setAlignmentX(Component.CENTER_ALIGNMENT);
        addActionListener(event -> {
            int row = frame.getTable().getSelectedRow();
            if (row > 0) {
                int delConfirm = JOptionPane.showConfirmDialog(frame.getButtonPanel(), "Are you sure you want to top this entry?",
                        "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (delConfirm == 0) {
                    frame.getModel().moveRow(row, row, 0);
                }
            } else if (row == 0) {
                JOptionPane.showMessageDialog(frame.getButtonPanel(), "It has already be the top", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame.getButtonPanel(), "You haven't chosen an entry to top!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
