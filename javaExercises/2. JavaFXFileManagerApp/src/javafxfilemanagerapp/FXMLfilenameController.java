package javafxfilemanagerapp;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLfilenameController implements Initializable {

    @FXML
    private TextField textfield;
    @FXML
    private Button ConfirmButton;
    private String fileName;
    private String path;
    private FileType type;
    private File selectedFile;
    private FXMLDocumentController dc;
    
    public void init(String path, FileType type, File selectedFile, FXMLDocumentController dc){
        this.type = type;
        this.path = path;
        this.selectedFile = selectedFile;
        this.dc = dc;
    }
    
    @FXML
    private void handleButtonActionSend(ActionEvent event) {        
        fileName = textfield.getText();
        System.out.println(path+" "+type);
        
        if(fileName != null && fileName!=""){
            File newFile = new File(selectedFile, fileName);
            if(this.type == FileType.FILE){
                try{
                    newFile.createNewFile();
                }
                catch(IOException e){
                    System.out.println("Error during creating file");
                }
            }
            else if(this.type == FileType.DIRECTORY){
                System.out.println(path+"/"+fileName);
                boolean newDir = new File(path+"/"+fileName).mkdirs();
                if(!newDir) System.out.println("error during creatig directory");
            }// get a handle to the stage
            Stage stage = (Stage) ConfirmButton.getScene().getWindow();
            // do what you have to do
            stage.close();
            dc.fillTreeView();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
