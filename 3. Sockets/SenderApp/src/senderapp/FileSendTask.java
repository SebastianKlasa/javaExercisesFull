package senderapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import javafx.concurrent.Task;

public class FileSendTask extends Task<Void>{
    
    File file;
    String ip;
    int port;
    
    public FileSendTask(File file, String ip, int port){
        this.file = file;
        this.ip = ip;
        this.port = port;
    }
    
    public Socket connect(){
        Socket socket = null;
        try{
            socket = new Socket(ip, port);
        }
        catch(UnknownHostException e){
            System.out.println(e.getMessage());
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        return socket;
    }
    
    @Override
    protected Void call() {
        System.out.println(ip + ":"+port);
        updateMessage("Próbuję nawiązać połączenie...");
        Socket socket = connect();
        if(socket==null){
            updateMessage("Próba nawiązania połączenia zakończona niepowodzeniem!");            
            return null;
        }
        updateMessage("Nawiązano połączenie...");
        
        byte[] buffor = new byte[1024];
        FileInputStream fis = null;
        OutputStream os = null;
        //DataOutputStream dos = null;
        try{
            fis = new FileInputStream(file.getPath());
            os = socket.getOutputStream();
            //send file name
            String fileName = file.getName();
            byte[] fileNameBytes = new byte[64];
            //fileNameBytes = fileName.getBytes();  
            for(int i = 0; i<64; i++){
                if(i<fileName.length()) fileNameBytes[i] = (byte)fileName.charAt(i);
                else fileNameBytes[i] = '|';
            }  
            String s = new String(fileNameBytes);
            System.out.println(s);
            os.write(fileNameBytes);
            
            //send file
            int dataSize;
            long totalFileSize = file.length();
            long progress = 0;
            updateMessage("Wysyłanie pliku...");
            while((dataSize = fis.read(buffor)) > -1){
                //sending
                progress+=dataSize;
                os.write(buffor);
               // System.out.println(progress+" - "+totalFileSize);
                updateProgress(progress, totalFileSize);
            }
            updateMessage("Wysyłanie zakończone!");
        }
        catch(FileNotFoundException e){
            updateMessage("Błąd podczas wysyłania pliku!");
            System.out.println(e.getMessage());
        }
        catch(IOException e){
            updateMessage("Błąd podczas wysyłania pliku!");
            System.out.println(e.getMessage());
        }
        finally{
            if(fis != null){
                try{
                    fis.close();
                }
                catch(IOException e){
                    System.out.println(e.getMessage());
                }
            }
            if(os!=null){
                try{
                    os.close();
                }
                catch(IOException e){
                    System.out.println(e.getMessage());
                }
            }
            /*if(dos!=null){
                try{
                    dos.close();
                }
                catch(IOException e){
                    System.out.println(e.getMessage());
                }
            }*/
        }
        return null;
    }
}
