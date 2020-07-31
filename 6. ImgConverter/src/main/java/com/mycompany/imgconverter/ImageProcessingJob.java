package com.mycompany.imgconverter;

import java.io.File;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class ImageProcessingJob {
    private File file;
    private SimpleStringProperty status;
    private DoubleProperty progress;
    
    public ImageProcessingJob(File file){
        this.file = file;
        status = new SimpleStringProperty();
        progress = new SimpleDoubleProperty();
    }
    
    public ImageProcessingJob(File file, SimpleStringProperty status, DoubleProperty progress){
        this.file = file;
        this.status = status;
        this.progress = progress;
    }
    
    public File getFile(){
        return file;
    }
    
    public SimpleStringProperty getStatusProperty(){
        return status;
    }
    
    public DoubleProperty getProgressProperty(){
        return progress;
    }
    
    public void setStatusProperty(SimpleStringProperty text){
        status = text;
    }
    
    public void setProgressProperty(DoubleProperty val){
        progress = val;
    }
}
