package senderapp;

import java.io.File;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

//class is not in use; to remove
public class FileSendTemplate{
    ProgressBar pb;
    Label fileName;
    Label status;
    File file;
    
    public FileSendTemplate(Label fileName, ProgressBar pb, 
            Label status, File file){
        this.pb = pb;
        this.fileName = fileName;
        this.status = status;
        this.file = file;
        
        initializeControls();
    }
    
    private void initializeControls(){
        fileName.setText(this.file.getName());
        status.setText("oczekuje");
    }
    
    public void startSend(){
        FileSendTask task = new FileSendTask(file, "", 0);
        status.textProperty().bind(task.messageProperty());
        pb.progressProperty().bind(task.progressProperty());
        
        Thread th = new Thread(task);
        try{
            th.start();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
