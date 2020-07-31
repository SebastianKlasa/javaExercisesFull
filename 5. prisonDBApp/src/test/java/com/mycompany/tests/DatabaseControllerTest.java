package com.mycompany.tests;

import com.mycompany.prisondbapp.DatabaseController;
import entities.Sektory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DatabaseControllerTest {
    
    DatabaseController dbController;
    
    public DatabaseControllerTest() {
    }
   
    @Before
    public void setUp() {
        dbController = new DatabaseController();
    }
    
    //Sektor adding completed successfully
     @Test
     public void testSektorAdd() {
         Sektory newSektor = new Sektory("P", 10);
         dbController.operationSektory(newSektor, DatabaseController.OPERATION.ADD);
         boolean flag = dbController.sektorExists("P");         
         assertEquals(flag, true);
     }
     
     //Sektor updating completed successfully
     @Test
     public void testSektorUpdate(){
         Sektory newSektor = new Sektory("P", 15);
         dbController.operationSektory(newSektor, DatabaseController.OPERATION.UPDATE);
         Sektory editedSektor = dbController.getSektorById("P");         
         assertEquals(editedSektor.getIloscCel(), 15);         
     }
     
     //test removing element
     @Test
     public void testSektorRemove() {
         Sektory newSektor = new Sektory("P", 10);
         dbController.operationSektory(newSektor, DatabaseController.OPERATION.REMOVE);
         boolean flag = dbController.sektorExists("P");         
         assertEquals(flag, false);
     }
}
