package xmlfilecatalogmanager;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBContext;
import dataLayer.Book;
import dataLayer.Catalog;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javax.xml.bind.Marshaller;

public class FXMLDocumentController implements Initializable {
    
    @FXML private Button fileChooserButton;
    @FXML private Label fileChooserLabel;
    @FXML private TableView tableView;
    @FXML private TableColumn titleColumn;
    @FXML private TableColumn pagesColumn;
    @FXML private Button saveButton;
    @FXML private Button addElementButton;
    @FXML private Button removeElementButton;
    
    private File file;
    private ObservableList<Book> booksOL;
    private List<Book> books;
    private Catalog catalog;
    
    @FXML
    private void chooseFileButtonAction(ActionEvent event) {
        JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.FILES_ONLY); 
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "xml");
        f.setFileFilter(filter);
        
        f.showSaveDialog(null);  
        file = f.getSelectedFile();
        
        if(file == null){
            System.out.println("not directory selected!");
        }else{
            if(file.isFile()){
                fileChooserLabel.setText(file.getPath());
                loadXMLContent();
            }
            else System.out.println("not file");
        }
    }
    
    private void loadXMLContent(){
        books.clear();
        booksOL.clear();
        try {    
            File XMLfile = new File(file.getPath());    
            JAXBContext jaxbContext = JAXBContext.newInstance("dataLayer");       
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();    
            catalog =(Catalog) jaxbUnmarshaller.unmarshal(XMLfile);   
            
            books.addAll(catalog.getBook());
            booksOL.setAll(books);
            tableView.setItems(booksOL);
            
            for(dataLayer.Book b: books){
                System.out.println(b.getTitle()+" "+b.getPages());
            }
              
          } catch (JAXBException e) {
              e.printStackTrace(); 
          }   
    }
    
    @FXML
    public void saveButtonAction(){
        if(catalog == null) return;
        catalog.setBook(booksOL);
        try{
            JAXBContext context = JAXBContext.newInstance("dataLayer");
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(catalog, file);
        }
        catch(JAXBException e){
            e.printStackTrace();
        }
    }
    
    @FXML
    public void addElementButtonAction(){
        Book b = new Book();
        b.setPages("");
        b.setTitle("");
        books.add(b);
        booksOL.add(b);
    }
    
    @FXML
    public void removeElementButtonAction(){
		if(books.size()<1) return;
        int book = tableView.getSelectionModel().getSelectedIndex();
        books.remove(book);
        booksOL.remove(book);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        books = new ArrayList<Book>(); 
        booksOL = FXCollections.observableArrayList();
        tableView.setItems(booksOL);
        
        titleColumn.setCellValueFactory(new PropertyValueFactory("title")); 
        pagesColumn.setCellValueFactory(new PropertyValueFactory("pages"));
        
        tableView.setEditable(true);
        titleColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        pagesColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        titleColumn.setOnEditCommit(new EventHandler<CellEditEvent<Book, String>>() {
            @Override
            public void handle(CellEditEvent<Book, String> t) {
                Book book = t.getRowValue();
                String newTitle = t.getNewValue();
                book.setTitle(newTitle);
            }
        });
        pagesColumn.setOnEditCommit(new EventHandler<CellEditEvent<Book, String>>() {
            @Override
            public void handle(CellEditEvent<Book, String> t) {
                Book book = t.getRowValue();
                String newPages = t.getNewValue();
                book.setPages(newPages);
            }
        });
    }    
    
}
