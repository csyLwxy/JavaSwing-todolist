package todolist.ui.panel;

import todolist.ui.ToDoList;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

/**
 * 重编辑任务的面板
 * @author wxy
 */
public class EditTaskPanel extends JPanel {

    public EditTaskPanel(ToDoList frame, int n) {
        setLayout(new BorderLayout(5, 5));
        // 输入提示
        JPanel editLabel = new JPanel(new GridLayout(0, 1, 2, 2));
        editLabel.add(new JLabel("任务类型：", SwingConstants.RIGHT));
        editLabel.add(new JLabel("任务名称：", SwingConstants.RIGHT));
        editLabel.add(new JLabel("任务描述：", SwingConstants.RIGHT));
        editLabel.add(new JLabel("截止日期：", SwingConstants.RIGHT));
        editLabel.add(new JLabel("执行日期：", SwingConstants.RIGHT));
        editLabel.add(new JLabel("重复次数：", SwingConstants.RIGHT));
        editLabel.add(new JLabel("重复周期：", SwingConstants.RIGHT));
        this.add(editLabel, BorderLayout.WEST);

        // 设置编辑文本框
        JPanel editTestFields = new JPanel(new GridLayout(0, 1, 2, 2));

        JComboBox<String> priority = new JComboBox<>();
        String[] priorities = new String[] { "临时任务", "周期任务", "长期任务"};
        priority.setModel(new DefaultComboBoxModel<>(priorities));
        priority.setSelectedIndex(Arrays.binarySearch(priorities, frame.getModel().getValueAt(n, 0).toString()));
        editTestFields.add(priority);

        JTextField title = new JTextField(frame.getModel().getValueAt(n, 1).toString());
        editTestFields.add(title);

        JTextField description = new JTextField(frame.getModel().getValueAt(n, 2).toString());
        editTestFields.add(description);

        JTextField ddl = new JTextField(frame.getModel().getValueAt(n, 3).toString());
        editTestFields.add(ddl);

        JTextField executionDate = new JTextField(frame.getModel().getValueAt(n, 4).toString());
        editTestFields.add(executionDate);

        JTextField repeatTimes = new JTextField(frame.getModel().getValueAt(n, 5).toString());
        editTestFields.add(repeatTimes);

        JTextField repeatCycle = new JTextField(frame.getModel().getValueAt(n, 6).toString());
        editTestFields.add(repeatCycle);


        if (!priorities[1].equals(frame.getModel().getValueAt(n, 0).toString())) {
            executionDate.setEditable(false);
            repeatTimes.setEditable(false);
            repeatCycle.setEditable(false);
        }

        this.add(editTestFields, BorderLayout.CENTER);

        int editConfirm = JOptionPane.showConfirmDialog(frame, this, "Edit", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        if (editConfirm == JOptionPane.OK_OPTION) {
            if (!title.getText().isEmpty()) {
                frame.getModel().setValueAt(Objects.requireNonNull(priority.getSelectedItem()).toString(), n, 0);
                frame.getModel().setValueAt(title.getText(), n, 1);
                frame.getModel().setValueAt(description.getText(), n, 2);
                frame.getModel().setValueAt(ddl.getText(), n, 3);
                frame.getModel().setValueAt(executionDate.getText(), n, 4);
                frame.getModel().setValueAt(repeatTimes.getText(), n, 5);
                frame.getModel().setValueAt(repeatCycle.getText(), n, 6);
            } else {
                JOptionPane.showMessageDialog(this, "Title is empty!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
