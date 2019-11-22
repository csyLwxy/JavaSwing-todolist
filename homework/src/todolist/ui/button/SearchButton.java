package todolist.ui.button;

import todolist.ui.ToDoList;
import todolist.ui.panel.SearchPanel;

import javax.swing.*;
import java.awt.*;

public class SearchButton extends JButton {

    public SearchButton(ToDoList frame) {
        setText("Search");
        setAlignmentX(Component.CENTER_ALIGNMENT);
        addActionListener(event -> {
            new SearchPanel(frame);
        });
    }
}
