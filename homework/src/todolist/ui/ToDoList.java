package todolist.ui;

import todolist.ui.panel.ButtonPanel;
import todolist.ui.util.DragDropRowTableUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;


public class ToDoList extends JFrame {

    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 800;

    private JTable table;
    private DefaultTableModel model;
    private JPanel buttonPanel;
    private TableRowSorter<DefaultTableModel> sorter;

    public ToDoList() {

        initSet();
        initTable();

        buttonPanel = new ButtonPanel(this);

        JScrollPane tablePane = new JScrollPane(table);
        tablePane.setBounds(0, 0, 880, 200);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, buttonPanel, tablePane);
        splitPane.setPreferredSize(new Dimension(DEFAULT_HEIGHT, DEFAULT_WIDTH));
        add(splitPane);
        pack();
    }

    /**
     * 一些框架默认的设置
     */
    private void initSet() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        Image image = new ImageIcon("./resource/image/icon.png").getImage();
        setIconImage(image);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("MyToDoList");
        setVisible(true);
    }

    /**
     * 设置 todolist 表格的 title
     */
    private void initTable() {
        String[] columns = { "任务类型", "任务名称", "任务细节", "截止日期", "执行日期", "重复次数", "重复周期", "是否完成"};
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table = new JTable(model) {
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        return String.class;
                    default:
                        return Boolean.class;
                }
            }
        };
        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
        table.setRowHeight(30);
        table.setUI(new DragDropRowTableUI());
        table.setDragEnabled(true);
    }

    public TableRowSorter<DefaultTableModel> getSorter() {
        return sorter;
    }

    public JTable getTable() {
        return table;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }

}