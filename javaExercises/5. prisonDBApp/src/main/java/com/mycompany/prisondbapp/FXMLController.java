package com.mycompany.prisondbapp;

import com.mycompany.prisondbapp.DatabaseController.OPERATION;
import entities.Cele;
import entities.Sektory;
import java.util.List;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;

public class FXMLController {
    @FXML
    TableView tableViewSektory;
    @FXML
    TableView tableViewCele;
    @FXML
    TableColumn tableColumnSektoryNazwa;
    @FXML
    TableColumn tableColumnSektoryIloscCel;
    @FXML
    TableColumn tableColumnCeleNumer;
    @FXML
    TableColumn tableColumnCeleIloscMiejsc;
    @FXML
    TableColumn tableColumnCelePowierzchnia;
    @FXML
    Label infoLabel;
    @FXML
    TextField textFieldSektoryNazwa;
    @FXML
    TextField textFieldSektoryIloscCel;
    @FXML
    TextField textFieldCeleNumer;
    @FXML
    TextField textFieldCeleIloscMiejsc;
    @FXML
    TextField textFieldPowierzchnia;
    
    private DatabaseController dbController;
    private ObservableList<Sektory> sektoryOL;
    ListProperty<Cele> cele;    
    
    @FXML
    public void addSektorButtonHandle(){
        if(!validSektorInput()){
            infoLabel.setText("Niepoprawne dane dot. Sektoru");
            return;
        }
        Sektory sektor = new Sektory(textFieldSektoryNazwa.getText(),
                Integer.parseInt(textFieldSektoryIloscCel.getText()));
        sektoryOL.add(sektor);
        dbController.operationSektory(sektor, OPERATION.ADD);
            infoLabel.setText("Dodano rekord");   
    }
    
    @FXML
    public void updateSektorButtonHandle(){
        Sektory sektor = (Sektory)tableViewSektory.getSelectionModel().getSelectedItem();
        dbController.operationSektory(sektor, OPERATION.UPDATE);   
        infoLabel.setText("Zaktualizowano rekord");   
    }
    
    @FXML
    public void removeSektorButtonHandle(){
        Sektory sektor = (Sektory)tableViewSektory.getSelectionModel().getSelectedItem();
        dbController.operationSektory(sektor, OPERATION.REMOVE);
        sektoryOL.remove(sektor); 
        infoLabel.setText("Usunięto rekord");   
    }
    
    @FXML
    public void addCelaButtonHandle(){
        if(!validCelaInput()){
            infoLabel.setText("Niepoprawne dane dot. Celi");
            return;
        }
        Sektory sektor = (Sektory)tableViewSektory.getSelectionModel().getSelectedItem();
        String sektorId = sektor.getNazwa();
        Cele cela = new Cele(Integer.parseInt(textFieldCeleNumer.getText()),
            Integer.parseInt(textFieldCeleIloscMiejsc.getText()),
            Float.parseFloat(textFieldPowierzchnia.getText()));
        cela.setIdSektor(sektorId.charAt(0));
        //sektoryOL.add(sektor);
        dbController.operationSektory(cela, OPERATION.ADD);
        infoLabel.setText("Dodano rekord w tabeli Cele");   
    }
    
    @FXML
    public void updateCelaButtonHandle(){
        Cele cela = (Cele)tableViewCele.getSelectionModel().getSelectedItem();
        dbController.operationSektory(cela, OPERATION.UPDATE);   
        infoLabel.setText("Zaktualizowano rekord w tabeli Cele");   
    }
    
    @FXML
    public void removeCelaButtonHandle(){
        Cele cele = (Cele)tableViewCele.getSelectionModel().getSelectedItem();
        dbController.operationSektory(cele, OPERATION.REMOVE);
        infoLabel.setText("Usunięto rekord w tabeli Cele");   
    }
    
    public void initialize(){
        dbController = new DatabaseController(); 
        initializeSektoryTable();
        initializeCeleTable();
        infoLabel.setText("Witamy w aplikacji PrisonDBApp!");
    }
    
    public void initializeSektoryTable(){
        sektoryOL = FXCollections.observableArrayList();
        sektoryOL.setAll(dbController.getAllSektory());
        tableViewSektory.setItems(sektoryOL);        
        tableColumnSektoryNazwa.setCellValueFactory(new PropertyValueFactory("nazwa")); 
        tableColumnSektoryIloscCel.setCellValueFactory(new PropertyValueFactory("iloscCel"));         
        tableViewSektory.setEditable(true);        
        IntegerStringConverter conv = new IntegerStringConverter();
        tableColumnSektoryIloscCel.setCellFactory(TextFieldTableCell.forTableColumn(conv));                
        tableColumnSektoryIloscCel.setOnEditCommit(new EventHandler<CellEditEvent<Sektory, String>>() {
            @Override
            public void handle(CellEditEvent<Sektory, String> t) {
                Sektory sektor = t.getRowValue();
                String newIloscCel = String.valueOf(t.getNewValue());
                try{
                    int iloscCel = Integer.parseInt(newIloscCel);                    
                    if(iloscCel<0 || iloscCel>1000) 
                        infoLabel.setText("Ilość cel musi zawierać się w zakresie od 0 do 1000!");
                    else sektor.setIloscCel(iloscCel);
                }
                catch(NumberFormatException e){
                    infoLabel.setText("Nieprawidłowy format. Ilość cel musi być liczbą!");
                }
            }
        });
    }
    
    public void initializeCeleTable(){
        cele = new SimpleListProperty<>();
        tableViewCele.itemsProperty().bind(cele);
        tableViewSektory.getSelectionModel().selectedItemProperty().addListener(new SektoryChangeListener());        
        tableColumnCeleNumer.setCellValueFactory(new PropertyValueFactory("nr"));   
        tableColumnCeleIloscMiejsc.setCellValueFactory(new PropertyValueFactory("iloscMiejsc"));  
        tableColumnCelePowierzchnia.setCellValueFactory(new PropertyValueFactory("powierzchnia"));     
        tableViewCele.setEditable(true);
        
        IntegerStringConverter conv = new IntegerStringConverter();
        FloatStringConverter convD = new FloatStringConverter();
        //tableColumnCeleNumer.setCellFactory(TextFieldTableCell.forTableColumn(conv));  
        tableColumnCeleIloscMiejsc.setCellFactory(TextFieldTableCell.forTableColumn(conv));   
        tableColumnCelePowierzchnia.setCellFactory(TextFieldTableCell.forTableColumn(convD));                 
        tableColumnCeleIloscMiejsc.setOnEditCommit(new EventHandler<CellEditEvent<Cele, String>>() {
            @Override
            public void handle(CellEditEvent<Cele, String> t) {
                Cele cela = t.getRowValue();
                String newIloscMiejsc = String.valueOf(t.getNewValue());
                try{
                    int iloscMiejsc = Integer.parseInt(newIloscMiejsc);
                    if(iloscMiejsc<0 || iloscMiejsc>10)
                        infoLabel.setText("Ilość miejsc musi zawierać się w zakresie od 0 do 10!");
                    else cela.setIloscMiejsc(iloscMiejsc);
                }
                catch(NumberFormatException e){
                    infoLabel.setText("Nieprawidłowy format. Ilość miejsc musi być liczbą!");
                }
            }
        });  
        tableColumnCelePowierzchnia.setOnEditCommit(new EventHandler<CellEditEvent<Cele, String>>() {
            @Override
            public void handle(CellEditEvent<Cele, String> t) {
                Cele cela = t.getRowValue();
                String newPowierzchnia = String.valueOf(t.getNewValue());
                try{
                    float powierzchnia = Float.parseFloat(newPowierzchnia);        
                    if(powierzchnia<1.0 || powierzchnia>50.0)  
                        infoLabel.setText("Powierzchnia musi zawierać się w zakresie od 1 do 50!");
                    else cela.setPowierzchnia(powierzchnia);
                }
                catch(NumberFormatException e){
                    infoLabel.setText("Nieprawidłowy format. Powierzchnia musi być liczbą!");
                }
            }
        });
    }

    public boolean validSektorInput(){
        int iloscCel;
        String sektorName = textFieldSektoryNazwa.getText();
        if(sektorName.length()!=1) return false;
        if(sektorName.charAt(0)<'A' || sektorName.charAt(0)>'Z') return false;        
        try{
            iloscCel = Integer.parseInt(textFieldSektoryIloscCel.getText());
        }
        catch(NumberFormatException e){
            return false;
        }
        if(iloscCel<0 || iloscCel>1000) return false;
        if(dbController.sektorExists(sektorName)) return false;
        return true;
    }
    
    public boolean validCelaInput(){
        int numer, iloscMiejsc;
        float powierzchnia;
        try{
            numer = Integer.parseInt(textFieldCeleNumer.getText());
            iloscMiejsc = Integer.parseInt(textFieldCeleIloscMiejsc.getText());
            powierzchnia = Float.parseFloat(textFieldPowierzchnia.getText());
        }
        catch(NumberFormatException e){
            return false;
        }
        if(numer<0 || numer>1000)return false;
        if(iloscMiejsc<0 || iloscMiejsc>10) return false;
        if(powierzchnia<1.0 || powierzchnia>50.0) return false;    
        if(dbController.celaExists(numer)) return false;    
        return true;
    }
        
    private class SektoryChangeListener implements ChangeListener{
        @Override
        public void changed(ObservableValue observable, Object oldValue, Object newValue) {
            Sektory newV = (Sektory)newValue;
            if (newValue != null) {
                cele.set(FXCollections.observableArrayList(dbController.getCeleBySektor(newV.getNazwa())));
            } 
            else {
                cele.setValue(null);
            }
        }
        
    }
    
}
