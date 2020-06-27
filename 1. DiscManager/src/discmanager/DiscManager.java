package discmanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;

public class DiscManager {

    /**
     * @param args the command line arguments
     */
    
    public static void printHelp(){
        System.out.println("DiscManager <path> - display disk content");
        System.out.println("-h - display help");
        System.out.println("-r <path> - display reccurent disk content");
        System.out.println("-s <path> - display sorted disk content");
        System.out.println("-w <path> <path to save> <file name> - display reccurent disk content");
        System.out.println("-z <path> - display serialized content");
    }
    
    public static int writeToFile(String newFilePath, String newFileName, Object o){
       try{
        File file = new File(newFilePath, newFileName+".xyz");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(o);
       }
       catch(IOException e){
           System.out.println("Error during file saving");
           return -1;
       }
        return 1;
    }
    
    public static int readFromFile(String fileName){
       try{
           File file = new File(fileName);
           ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
           DiskFile df1 = (DiskFile)ois.readObject();
           df1.print();
           df1.printAllChildren();
       }
       catch(IOException e){
           System.out.println("Error during file saving");
           return -1;
       }
       catch(ClassNotFoundException e){
           System.out.println(e.getMessage());
       }
        return 1;
    }
    
    public static void main(String[] args) throws IOException {
        if(args.length > 0){
            boolean isSorted = false;
            boolean isReccurent = false;
            boolean toSave = false;
            DiskFile df1;
            if(args[0].charAt(0)=='-'){
                if(args[0].charAt(1)=='h'){
                    printHelp();
                }
                if(args[0].charAt(1)=='z'){
                    if(args.length==2){
                        File f = new File(args[1]);
                        if(f.exists() && f.isFile()){
                            readFromFile(args[1]);
                        }
                        else{
                            System.out.println("File does not exists");
                        }
                    }
                    else{
                        System.out.println("Invalid input, use -z <file path>");                        
                    }
                }
                else{
                    if(args[0].contains("s")){
                        isSorted = true;
                    }
                    if(args[0].contains("r")){
                        isReccurent = true;
                    }
                    if(args[0].contains("w")){
                        toSave = true;
                    }
                    if(args.length >= 2){
                        df1 = new DiskFile(isReccurent, isSorted, args[1], 1);
                        df1.print();
                        df1.printAllChildren();
                        if(toSave){
                            if(args.length!=4){
                                      System.out.println("Invalid input, use -w <path> <path to save> <file name>");
                            }
                            else{
                                File f = new File(args[2]);
                                if(f.exists() && f.isDirectory()){
                                    writeToFile(args[2], args[3], df1);
                                }
                                else{
                                    System.out.println("Directory does not exists");
                                }
                            }
                        }
                    }
                    else{
                        System.out.println("Invalid input, use -s <path>");            
                    }
                }
            }
            else{
                df1 = new DiskFile(isReccurent, isSorted, args[0], 1);
                df1.print();
                df1.printAllChildren();
            }
        }
        else{
            System.out.println("Invalid input, use -h parameter to help");            
        }
    }
    
}
