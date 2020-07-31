package javafxfilemanagerapp;

import javafx.scene.control.TreeCell;

public class FileCell extends TreeCell<DiskFile> {
    
    @Override
    protected void updateItem(DiskFile file, boolean empty){
        super.updateItem(file, empty);
        if(file != null){
            setText(file.getFileName()+ " " + file.getModified());
        }
        else{
            setText(null);
        }
    }
}
