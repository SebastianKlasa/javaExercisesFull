package dataLayer;

import java.util.Collection;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "catalog")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "book"
})
public class Catalog {
    Collection<Book> book;
    
    public Collection<Book> getBook(){
        return book;
    }    
    
    public void setBook(Collection<Book> books){
        this.book = books;
    }
}
