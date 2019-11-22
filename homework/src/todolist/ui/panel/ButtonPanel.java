package todolist.ui.panel;

import todolist.ui.ToDoList;
import todolist.ui.button.*;

import javax.swing.*;

/**
 * 按键的面板
 * @author wxy
 */
public class ButtonPanel extends JPanel {

    public ButtonPanel(ToDoList frame) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // 添加 “Add” 按键
        JButton add = new AddButton(frame);
        add(Box.createVerticalGlue());
        add(add);

        // 添加 “Edit” 按键
        JButton edit = new EditButton(frame);
        add(Box.createVerticalGlue());
        add(edit);

        // 添加 “Edit” 按键
        JButton search = new SearchButton(frame);
        add(Box.createVerticalGlue());
        add(search);

        // 添加 “Delete” 按键
        JButton del = new DeleteButton(frame);
        add(Box.createVerticalGlue());
        add(del);

        // 添加 "Save" 按键
        JButton save = new SaveButton(frame);
        add(Box.createVerticalGlue());
        add(save);

        // 添加 "Import" 按键
        JButton importButton = new ImportButton(frame);
        add(Box.createVerticalGlue());
        add(importButton);

        // 添加 "Output" 按键
        JButton outputButton = new OutputButton(frame);
        add(Box.createVerticalGlue());
        add(outputButton);

        // 添加 “Help” 按键
        JButton help = new HelpButton(frame);
        add(Box.createVerticalGlue());
        add(help);

        // 添加 “Top” 按键
        JButton top = new TopButton(frame);
        add(Box.createVerticalGlue());
        add(top);

        // 添加 “Exit” 按键
        JButton exit = new ExitButton(frame);
        add(Box.createVerticalGlue());
        add(exit);

        add(Box.createVerticalGlue());
    }
}