package todolist.ui.panel;

import todolist.ui.ToDoList;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * 添加任务 面板
 * @author wxy
 */
public class AddTaskPanel extends JPanel {

    public AddTaskPanel(ToDoList frame) {
        setLayout(new BorderLayout(5, 5));
        Object[] row = new Object[frame.getModel().getColumnCount()];

        JPanel selsectPrioritiesPanel = new JPanel(new GridLayout(0 ,1, 2, 2));
        selsectPrioritiesPanel.add(new JLabel("任务类型：", SwingConstants.RIGHT));

        JPanel selsectPrioritiesFields = new JPanel(new GridLayout(0, 1, 2, 2));

        JComboBox<String> priority = new JComboBox<>();
        priority.setModel(new DefaultComboBoxModel<>(new String[] { "临时任务", "周期任务", "长期任务"}));
        selsectPrioritiesFields.add(priority);

        this.add(selsectPrioritiesFields, BorderLayout.CENTER);

        int selectConfirm = JOptionPane.showConfirmDialog(frame, this, "Select", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        if (selectConfirm == JOptionPane.OK_OPTION) {
            row[0] = Objects.requireNonNull(priority.getSelectedItem()).toString();
        }

        this.removeAll();

        selsectPrioritiesPanel.setVisible(false);

        // 输入提示
        JPanel addLabel = new JPanel(new GridLayout(0, 1, 2, 2));
        addLabel.add(new JLabel("任务名称：", SwingConstants.RIGHT));
        addLabel.add(new JLabel("任务描述：", SwingConstants.RIGHT));
        addLabel.add(new JLabel("截止日期：", SwingConstants.RIGHT));
        addLabel.add(new JLabel("执行日期：", SwingConstants.RIGHT));
        addLabel.add(new JLabel("重复次数：", SwingConstants.RIGHT));
        addLabel.add(new JLabel("重复周期：", SwingConstants.RIGHT));
        this.add(addLabel, BorderLayout.WEST);

        // 设置输入文本框
        JPanel addTestFields = new JPanel(new GridLayout(0, 1, 2, 2));

        JTextField title = new JTextField();
        addTestFields.add(title);

        JTextField description = new JTextField();
        addTestFields.add(description);

        JTextField ddl = new JTextField();
        addTestFields.add(ddl);

        JTextField executionDate = new JTextField();
        if (priority.getSelectedIndex() != 1) {
            executionDate.setEditable(false);
        }
        addTestFields.add(executionDate);

        JTextField repeatTimes = new JTextField();
        if (priority.getSelectedIndex() != 1) {
            repeatTimes.setEditable(false);
        }
        addTestFields.add(repeatTimes);

        JTextField repeatCycle = new JTextField();

        if (priority.getSelectedIndex() != 1) {
            repeatCycle.setEditable(false);
        }
        addTestFields.add(repeatCycle);

        this.add(addTestFields, BorderLayout.CENTER);

        int addConfirm = JOptionPane.showConfirmDialog(frame, this, "Add", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        if (addConfirm == JOptionPane.OK_OPTION) {
            if (!title.getText().isEmpty()) {
                row[0] = Objects.requireNonNull(priority.getSelectedItem()).toString();
                row[1] = title.getText();
                row[2] = description.getText();
                row[3] = ddl.getText();
                row[4] = executionDate.getText();
                row[5] = repeatTimes.getText();
                row[6] = repeatCycle.getText();
                frame.getModel().addRow(row);
            } else {
                JOptionPane.showMessageDialog(frame.getButtonPanel(), "Title is empty!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
