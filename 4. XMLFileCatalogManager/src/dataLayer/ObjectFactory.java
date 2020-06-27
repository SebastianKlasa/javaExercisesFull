package dataLayer;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {
    
    public ObjectFactory() {}
    
    public Catalog createCatalog() {
        return new Catalog();
    }
    
    public Book createBook(){
        return new Book();
    }
}
