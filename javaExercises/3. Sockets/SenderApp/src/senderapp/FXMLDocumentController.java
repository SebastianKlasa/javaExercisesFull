package senderapp;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FXMLDocumentController implements Initializable {
    @FXML
    Button chooseFileButton;
    @FXML
    AnchorPane mainContainer;
    @FXML
    ListView<Label> VisibleObjFileName;
    @FXML
    ListView<Label> VisibleObjStatus;
    @FXML
    ListView<ProgressBar> VisibleObjProgressBar;     
    @FXML
    TextField IPTextField;
    @FXML
    TextField portTextField;
    @FXML
    Button startButton;
    
    private final ObservableList fileNames = 
        FXCollections.observableArrayList();
    private final ObservableList statuses = 
        FXCollections.observableArrayList();
    private final ObservableList progressBars = 
        FXCollections.observableArrayList();
    
    private File[] rootDirectory;
    private ExecutorService executor;
    private String ip ="127.0.0.1";
    private int port = 9876;
    
    @FXML
    private void startSendButtonAction(){
        //validate ip and port    
        if(!validateIpPort()) return;
        
        if(rootDirectory == null){
            System.out.println("not file/s selected!");
        }else{
            executor = new ThreadPoolExecutor(2, 8, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
            for(File file: rootDirectory){
                if(file.isFile()){
                    addSendThread(file);
                }
                else System.out.println("not file");
            }
            executor.shutdown();
        }
    }
    
    @FXML
    private void chooseFileButtonAction(ActionEvent event) {
        JFileChooser f = new JFileChooser();
        f.setMultiSelectionEnabled(true);
        f.setFileSelectionMode(JFileChooser.FILES_ONLY); 
        f.showSaveDialog(null);  
        rootDirectory = f.getSelectedFiles();
    }
    
    private void addSendThread(File file){
        //controls initialize
        ProgressBar pb = new ProgressBar();
        progressBars.add(pb);        
        Label fileName = new Label();
        fileNames.add(fileName);        
        Label status = new Label();
        statuses.add(status);        
        fileName.setText(file.getName());
        status.setText("oczekuje");
        
        //new task to send data
        FileSendTask task = new FileSendTask(file, ip, port);
        status.textProperty().bind(task.messageProperty());
        pb.progressProperty().bind(task.progressProperty());
        executor.submit(task);
    }
    
    private boolean validateIpPort(){
        boolean flag = true;
        String portTF = portTextField.getText();
        String ipTF = IPTextField.getText();
        
        if(validPort(portTF) && validIP(ipTF)){
            port = Integer.parseInt(portTF);
            ip = ipTF;
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Please input valid ip and port number", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }  
    
    private boolean validPort (String port) {    
        int minPort = 1024;
        int maxPort = 65535;      
        try{
            int portTF = Integer.parseInt(port);
            if(portTF < minPort || portTF > maxPort){
                return false;
            }
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }
    
    private boolean validIP (String ip) {
    try {
        if ( ip == null || ip.isEmpty() ) {
            return false;
        }

        String[] parts = ip.split( "\\." );
        if ( parts.length != 4 ) {
            return false;
        }

        for ( String s : parts ) {
            int i = Integer.parseInt( s );
            if ( (i < 0) || (i > 255) ) {
                return false;
            }
        }
        if ( ip.endsWith(".") ) {
            return false;
        }

        return true;
    } catch (NumberFormatException nfe) {
        return false;
    }
}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        VisibleObjFileName.setItems(fileNames);
        VisibleObjStatus.setItems(statuses);
        VisibleObjProgressBar.setItems(progressBars);        
        IPTextField.setText(ip);
        portTextField.setText(Integer.toString(port));
    }    
}
