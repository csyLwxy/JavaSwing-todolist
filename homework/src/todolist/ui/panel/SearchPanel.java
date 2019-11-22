package todolist.ui.panel;

import todolist.ui.ToDoList;

import javax.swing.*;
import java.awt.*;
public class SearchPanel extends JPanel {

    public SearchPanel(ToDoList frame) {
        setLayout(new BorderLayout(5, 5));

        // 输入提示
        JPanel searchLabel = new JPanel(new GridLayout(0, 1, 2, 2));
        searchLabel.add(new JLabel("search", SwingConstants.RIGHT));
        this.add(searchLabel, BorderLayout.WEST);

        // 设置输入文本框
        JPanel searchTestFields = new JPanel(new GridLayout(0, 1, 2, 2));
        JTextField search = new JTextField();
        searchTestFields.add(search);

        this.add(searchTestFields, BorderLayout.CENTER);
        int addConfirm = JOptionPane.showConfirmDialog(frame, this, "search: ", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        if (addConfirm == JOptionPane.OK_OPTION) {
            String text = search.getText();
            if (text.length() == 0) {
                frame.getSorter().setRowFilter(null);
            } else {
                frame.getSorter().setRowFilter(RowFilter.regexFilter(text));
            }
        }
    }
}
