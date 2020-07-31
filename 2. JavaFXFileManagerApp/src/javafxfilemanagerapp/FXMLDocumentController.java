/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxfilemanagerapp;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private VBox vbox;
    @FXML
    private Label label;
    @FXML
    private Button AddFileButton;
    @FXML
    private Button AddDirButton;
    @FXML
    private Button DeleteButton;
    
    private File rootDirectory;
    TreeView<DiskFile> directoryView;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {        
        DirectoryChooser directoryChooser = new DirectoryChooser();
        rootDirectory = directoryChooser.showDialog(AddFileButton.getScene().getWindow());
        if(rootDirectory == null){
            System.out.println("not directory selected!");
        }else{
            fillTreeView();
        }
    }
    
    private void openNameDialog(String path, FileType ft, File selectedFile){
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLfilename.fxml"));
            Parent root = (Parent) loader.load();

            FXMLfilenameController secController=loader.getController();
            secController.init(path ,ft, selectedFile, this);

            Stage stage=new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(AddFileButton.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void handleButtonAddFile(ActionEvent event){
        TreeItem<DiskFile> selectedItem = directoryView.getSelectionModel().getSelectedItem();
        DiskFile selectedFile = selectedItem.getValue();
        
        if(selectedFile.getFileType() == FileType.DIRECTORY){
            openNameDialog(selectedFile.getFilePath(), selectedFile.getFileType(), selectedFile.getFile());
            System.out.println("essa");
        }
    }   
    
    @FXML
    private void handleButtonAddDirectory(ActionEvent event) throws IOException{
        TreeItem<DiskFile> selectedItem = directoryView.getSelectionModel().getSelectedItem();
        DiskFile selectedFile = selectedItem.getValue();
        
        if(selectedFile.getFileType() == FileType.DIRECTORY){
            openNameDialog(selectedFile.getFilePath(), selectedFile.getFileType(), selectedFile.getFile());
        }
    }
    
    @FXML
    private void handleButtonDelete(ActionEvent event){
        TreeItem<DiskFile> selectedItem = directoryView.getSelectionModel().getSelectedItem();
        del(selectedItem.getValue());
        if(selectedItem.getParent()==null) directoryView.setRoot(null);
        else{
            selectedItem.getParent().getChildren().remove(selectedItem);
        }
    }
    
    private void del(DiskFile df){
        Set<DiskFile> children = df.getAllFiles();
        //delete children
        for(DiskFile f : children){
            del(f);
        }
        df.deleteFile();
    }
    
    public void fillTreeView(){
        directoryView = new TreeView<DiskFile>();
        directoryView.setCellFactory(new FileCellFactory());
        DiskFile df = new DiskFile(true, true, rootDirectory, 1);
        
        //init root
        TreeItem<DiskFile> root = new TreeItem<>(df);
        addChildren(root, df);
        
        directoryView.setRoot(root);
        vbox.getChildren().clear();
        vbox.getChildren().add(directoryView);
    }
    
    void addChildren(TreeItem<DiskFile> root, DiskFile df){
        Set<DiskFile> children = df.getAllFiles();
        //set children
        for(DiskFile f : children){
            TreeItem<DiskFile> el = new TreeItem<>(f);
            root.getChildren().add(el);
            addChildren(el, f);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
