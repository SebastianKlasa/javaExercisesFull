package com.mycompany.imgconverter;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ForkJoinPool;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ProgressBarTableCell;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;

public class FXMLController implements Initializable {
    
    @FXML private TableView tableViewFilesList;
    @FXML private TableColumn<ImageProcessingJob, String> tableColumnName;
    @FXML private TableColumn<ImageProcessingJob, String> tableColumnStatus;
    @FXML private TableColumn<ImageProcessingJob, Double> tableColumnProgress;
    @FXML private TextField textFieldFiles;
    @FXML private TextField textFieldSaveTo;
    @FXML private TextField textFieldThreadCount;
    @FXML private Label labelWarning;
    @FXML private Button saveToButton;
    @FXML private Button loadFilesButton;
    @FXML private Button startButton;
    @FXML private ChoiceBox processMode;
    
    private ObservableList<ImageProcessingJob> selFiles;
    private File saveDirectory;
    
    @FXML private void buttonSaveToHandle(){
        DirectoryChooser dc = new DirectoryChooser();
        saveDirectory = dc.showDialog(saveToButton.getScene().getWindow());
        if(saveDirectory != null){
            textFieldSaveTo.setText(saveDirectory.getPath());
        }
    }
    
    @FXML private void buttonLoadFilesHandle(){
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = 
                new FileChooser.ExtensionFilter("JPG images", "*.jpg");

        fileChooser.getExtensionFilters().add(filter);
        List<File> selectedFiles = fileChooser.showOpenMultipleDialog(null);
        
        if(selectedFiles != null){
            String files="";
            for(File f : selectedFiles){
                files+=f.getPath();
                files+=";";
                ImageProcessingJob ipj = new ImageProcessingJob(f);
                selFiles.add(ipj);
            }            
            textFieldFiles.setText(files);            
            tableViewFilesList.setItems(selFiles);
        }
    }
    
    @FXML private void buttonStartHandle(){
        if(selFiles == null){
            labelWarning.setText("Proszę wybrać pliki!");
            return;
        }
        if(saveDirectory == null){
            labelWarning.setText("Proszę wybrać katalog docelowy!");
            return;
        }    
        
        Runnable task = getConvertTask();
        
        if(processMode.getSelectionModel().getSelectedItem()=="sekwencyjny"){
            Thread th1 = new Thread(task);
            th1.start(); 
        }
        else if(processMode.getSelectionModel().getSelectedItem()=="współbierzny"){
            int threadCount = getThreadPool();
            if(threadCount == 0) return;
            else{
                ForkJoinPool pool = new ForkJoinPool(threadCount); //pożądana liczba wątków
                pool.submit(task);
            }
       }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableColumnName.setCellValueFactory(
        p -> new SimpleStringProperty(p.getValue().getFile().getName()));      
        
        tableColumnStatus.setCellValueFactory( //status przetwarzania
        p -> p.getValue().getStatusProperty());        
        
        tableColumnProgress.setCellValueFactory( //postęp przetwarzania
        p -> p.getValue().getProgressProperty().asObject());
        
        tableColumnProgress.setCellFactory( //wykorzystanie paska postępu
        ProgressBarTableCell.<ImageProcessingJob>forTableColumn());
        
        selFiles = FXCollections.observableArrayList();
        processMode.getItems().addAll("sekwencyjny", "współbierzny");
        processMode.getSelectionModel().select("sekwencyjny");
    }    
    
    private void convertToGrayscale(
        File originalFile, //oryginalny plik graficzny
        File outputDir, //katalog docelowy
        DoubleProperty progressProp//własność określająca postęp operacji
    ) {
        try {
            //wczytanie oryginalnego pliku do pamięci
            BufferedImage original = ImageIO.read(originalFile);
            //przygotowanie bufora na grafikę w skali szarości
            BufferedImage grayscale = new BufferedImage(
            original.getWidth(), original.getHeight(), original.getType());
            //przetwarzanie piksel po pikselu
            for (int i = 0; i < original.getWidth(); i++) {
                for (int j = 0; j < original.getHeight(); j++) {
                    //pobranie składowych RGB
                    int red = new Color(original.getRGB(i, j)).getRed();
                    int green = new Color(original.getRGB(i, j)).getGreen();
                    int blue = new Color(original.getRGB(i, j)).getBlue();
                    //obliczenie jasności piksela dla obrazu w skali szarości
                    int luminosity = (int) (0.21*red + 0.71*green + 0.07*blue);
                    //przygotowanie wartości koloru w oparciu o obliczoną jaskość
                    int newPixel =
                    new Color(luminosity, luminosity, luminosity).getRGB();
                    //zapisanie nowego piksela w buforze
                    grayscale.setRGB(i, j, newPixel);
                }
                //obliczenie postępu przetwarzania jako liczby z przedziału [0, 1]
                double progress = (1.0 + i) / original.getWidth();
                //aktualizacja własności zbindowanej z paskiem postępu w tabeli
                Platform.runLater(() -> progressProp.set(progress));
            }
            //przygotowanie ścieżki wskazującej na plik wynikowy
            Path outputPath =
            Paths.get(outputDir.getAbsolutePath(), originalFile.getName());
            //zapisanie zawartości bufora do pliku na dysku
            ImageIO.write(grayscale, "jpg", outputPath.toFile());
        } catch (IOException ex) {
            //translacja wyjątku
            throw new RuntimeException(ex);
        }
    }
    
    private Runnable getConvertTask(){
        Runnable task = new Runnable(){      
               @Override
               public void run(){     
                   long start = System.currentTimeMillis();   
                   if(processMode.getSelectionModel().getSelectedItem()=="sekwencyjny"){
                        selFiles.stream().forEach(i -> convertToGrayscale(
                            i.getFile(), //oryginalny plik graficzny
                            saveDirectory, //katalog docelowy
                            i.getProgressProperty()//własność określająca postęp operacji
                        ));
                   }
                   else if(processMode.getSelectionModel().getSelectedItem()=="współbierzny"){
                       selFiles.parallelStream().forEach(i -> convertToGrayscale(
                            i.getFile(), //oryginalny plik graficzny
                            saveDirectory, //katalog docelowy
                            i.getProgressProperty()//własność określająca postęp operacji
                        ));
                   }
                   long end = System.currentTimeMillis();
                   long duration = end-start;
                   System.out.println(duration);
                   String time = Double.toString((double)duration/1000);
                   
                   Platform.runLater(new Runnable() {
                        @Override public void run() {
                             labelWarning.setText("Czas przetwarzania: "+time+" s.");
                        }
                    });
               }
           };     
        return task;
    }
    
    private int getThreadPool(){
        String threadCountString = textFieldThreadCount.getText();
        int threadCountInt = 1;
        if(threadCountString ==null || threadCountString ==""){
            labelWarning.setText("Proszę wprowadzić prawidłową liczbę wątków. W zakresie 1-8");
            return 0;
        }
        try{
            threadCountInt = Integer.parseInt(threadCountString);
            if(threadCountInt<1 || threadCountInt>8) throw new NumberFormatException();
        }
        catch(NumberFormatException e){
            labelWarning.setText("Liczba wątków. Zakres: 1-8");      
            return 0;
        }
        return threadCountInt;
    }
}
