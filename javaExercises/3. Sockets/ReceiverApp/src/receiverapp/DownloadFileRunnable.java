package receiverapp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DownloadFileRunnable implements Runnable{

    private Socket socket;
    private String path;
    
    public boolean isRunning;
    
    public DownloadFileRunnable(Socket socket, String path){
        this.socket = socket;
        this.path = path;
        isRunning = true;
    }
   
    
    @Override
    public void run() {
        FileOutputStream fop = null;
        InputStream is = null;
        try {
            byte[] buffer = new byte[1024];
            is = this.socket.getInputStream();
            
            //read file name
            byte[] fileNameBytes = new byte[64];
            is.read(fileNameBytes);
            String fileName = new String(fileNameBytes);
            String fn = fileName.replace("|", "");
            
            System.out.println(fn);
            
            fop = new FileOutputStream(path+"/"+fn);
            System.out.println("przesylanie zakonczone");
            while(is.read(buffer) > -1){
                fop.write(buffer);
            }            
        } 
        catch (IOException ex) {
            Logger.getLogger(DownloadFileRunnable.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(fop != null){
                try{
                    fop.close();
                }
                catch(IOException e){
                    System.out.println(e.getMessage());
                }
            }
            if(is!=null){
                try{
                    is.close();
                }
                catch(IOException e){
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("przeslano");
            isRunning = false;
        }
    }
}
