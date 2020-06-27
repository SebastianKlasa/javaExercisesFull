package receiverapp;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.Property;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.DirectoryChooser;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label statusLabel;
    @FXML
    private Label fileLocationLabel;
    @FXML
    private Button startReceiveButton;
    @FXML
    private Button fileLocationButton;
    
    String fileLocation;
    boolean readyToReceive;
    Thread connectionHandle;
    
    @FXML
    private void handleStartReceiveButton(ActionEvent event) {
        if(fileLocation == null){
            fileLocationLabel.setText("Proszę wybrać katalog do zapisu!");
            return;
        }
        if(readyToReceive==false){
            readyToReceive = true;
            ReceiveTask task = new ReceiveTask(this);
            statusLabel.textProperty().bindBidirectional((Property<String>) task.messageProperty());
            connectionHandle = new Thread(task);
            connectionHandle.setDaemon(true);
            try{
                connectionHandle.start();
                statusLabel.setText("oczekuje na połączenie");
                startReceiveButton.setText("Zakończ");
            }
            catch(Exception e){
                readyToReceive = false;
                System.out.println(e.getMessage());
            }
        }
        else{
            statusLabel.setText("");
            readyToReceive = false;
            startReceiveButton.setText("Start");
        }
    }
    
    @FXML
    private void handleFileLocationButton(ActionEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File file = directoryChooser.showDialog(fileLocationButton.getScene().getWindow());
        if(file == null){
            System.out.println("not directory selected!");
        }else{
            fileLocation = file.getPath();
            fileLocationLabel.setText(fileLocation);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        readyToReceive = false;
    }    
    
    public boolean isReadyToReceive(){
        return readyToReceive;
    }
    
    public String getFilePath(){
        return this.fileLocation;
    }
}
