package todolist.ui.button;

import todolist.ui.ToDoList;
import todolist.ui.util.FileTool;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ImportButton extends JButton {

    public ImportButton(ToDoList frame) {
        setText("Import");
        setAlignmentX(Component.CENTER_ALIGNMENT);

        addActionListener(event -> {
            JFileChooser fileChooser = new JFileChooser();
            //fd.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fileChooser.showOpenDialog(null);
            File file = fileChooser.getSelectedFile();
            if(file != null){
                FileTool.ImportToMyToDoList(frame, file);
            }
        });
    }
}
