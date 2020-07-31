package receiverapp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javafx.concurrent.Task;

public class ReceiveTask extends Task<Void>{
    
    private ServerSocket server;
    FXMLDocumentController parent;
    List<DownloadFileRunnable> runnables;
    
    public ReceiveTask(FXMLDocumentController parent){
        this.parent = parent;
        runnables = new ArrayList<>();
    }
    
    @Override
    protected Void call() {
        Thread messagesTh = new Thread(() -> manageMessages());
        messagesTh.start();
        
        try{
            server = new ServerSocket(9876);
            while(parent.isReadyToReceive()){
                Socket socket = server.accept();
                if(socket!=null){
                    DownloadFileRunnable downloadFile = new DownloadFileRunnable(socket, parent.getFilePath());
                    runnables.add(downloadFile);
                    Thread th = new Thread(downloadFile);
                    th.start();
                }
            }
        }
        catch(IOException e){
            updateMessage("Błąd połączenia!");
        }
        System.out.println("zakonczono");
        
        return null;
    }
    
    private void manageMessages(){
        while(true){
            try{
                Thread.sleep(100);
            }
            catch(InterruptedException e){ 
                System.out.println(e.getMessage());
            }
            int countOfRunnables = 0;
            for (DownloadFileRunnable runnable : runnables) {
                if (runnable.isRunning) {
                    countOfRunnables++;
                }
            }
            if(countOfRunnables == 0){
                updateMessage("Oczekuję na pliki...");
            }
            else{
                updateMessage("Pobieranie plików... ("+countOfRunnables+")");
            }
        }
    }
    
}
