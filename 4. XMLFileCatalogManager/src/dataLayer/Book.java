package dataLayer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name="book")
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {
    @XmlAttribute(name = "title")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    private String title;
    
    @XmlAttribute(name = "pages")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    private String pages;
    
    public Book(){
    }
    
    public Book(String title, String author, String pages){
        this.title = title;
        this.pages = pages;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getPages(){
        return pages;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public void setPages(String pages){
        try{
            int tmp = Integer.parseInt(pages);
            this.pages = Integer.toString(tmp);
        } 
        catch (NumberFormatException e) {
            this.pages = "0";
        }
    }
}
