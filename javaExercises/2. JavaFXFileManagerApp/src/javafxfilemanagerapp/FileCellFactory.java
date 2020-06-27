package javafxfilemanagerapp;

import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeView;
import javafx.util.Callback;

public class FileCellFactory implements Callback<TreeView<DiskFile>, TreeCell<DiskFile>> {

    @Override
    public TreeCell<DiskFile> call(TreeView<DiskFile> param) {
        return new FileCell();
    }
    
}
