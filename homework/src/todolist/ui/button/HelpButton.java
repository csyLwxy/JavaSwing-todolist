package todolist.ui.button;

import todolist.ui.ToDoList;

import javax.swing.*;
import java.awt.*;

/**
 * A button on buttonPanel to show help message
 */
public class HelpButton extends JButton {

    public HelpButton(ToDoList frame) {
        setText("Help");
        setAlignmentX(Component.CENTER_ALIGNMENT);
        String helpMessage = "-Add new a new entry with 'Add' -button\n"
                + "-Edit an existing entry by clicking on it in the list and pressing the 'Edit' -button\n"
                + "-Delete an entry from the list by clicking on it and pressing the 'Delete' -button\n"
                + "-Save an entry to save the todo list to a file\n"
                + "-Search an entry to search by specific word\n"
                + "-Top an entry to top a todo list to the top of the table\n"
                + "-Reorganize the list by column by clicking on it in the list";

        addActionListener(event -> {
            JOptionPane.showMessageDialog(frame.getButtonPanel(), helpMessage, "Help", JOptionPane.PLAIN_MESSAGE);
        });
    }
}
