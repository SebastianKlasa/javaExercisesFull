package discmanager;

import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;


public class DiskFile implements Comparable<DiskFile>, Serializable {
    static int maxFileNameLength = 0;
    static int maxDepth = 0;
    private final String fileName;
    private final Set<DiskFile> files;
    private Date lastModified;
    FileType fileType;
    int depth;
    boolean isSorted;
    boolean isReccurent;
    
    public DiskFile(boolean isReccurent, boolean isSorted, String fileName,
            int depth){
        this.isReccurent = isReccurent;
        this.isSorted = isSorted;
        this.fileName = fileName;
        if(this.fileName.length()>maxFileNameLength){
            maxFileNameLength = this.fileName.length();
        }
        this.depth = depth;
        if(this.depth>maxDepth){
            maxDepth = this.depth;
        }
        if(isSorted){
            files = new TreeSet();
        }
        else{
            files = new HashSet();
        }
        initializeFile();
    }
    
    public String getFileName(){
        return this.fileName;
    }

    @Override
    public int compareTo(DiskFile o) {
        return fileName.compareTo(o.getFileName());
    }
    
    @Override
    public boolean equals(Object o){
        DiskFile other = (DiskFile)o;
        System.out.println(other.getFileName());
        if(this.fileName.equals(other.getFileName())){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.fileName);
        hash = 71 * hash + Objects.hashCode(this.files);
        hash = 71 * hash + Objects.hashCode(this.lastModified);
        hash = 71 * hash + Objects.hashCode(this.fileType);
        hash = 71 * hash + this.depth;
        hash = 71 * hash + (this.isSorted ? 1 : 0);
        hash = 71 * hash + (this.isReccurent ? 1 : 0);
        return hash;
    }
    
    public int initializeFile(){
        File thisFileData = new File(fileName);
        boolean isDirectory = thisFileData.isDirectory();
        boolean isFile = thisFileData.isFile();
        if(isDirectory){
            fileType = FileType.DIRECTORY;
            File[] childrenFiles = thisFileData.listFiles();
            for (File childrenFile : childrenFiles) {
                DiskFile newFile = new DiskFile(isReccurent, isSorted, childrenFile.getAbsolutePath(), depth+1);
                files.add(newFile);
            }
        }
        else if (isFile) fileType = FileType.FILE;
        else fileType = FileType.UNKNOWN;
        long lastModifiedMS = thisFileData.lastModified();
        lastModified = new Date(lastModifiedMS);
        return 1;
    }
    
    public void print(){
        String outputString = "";
        for(int i=0;i<depth;i++){
            outputString+="-";
        }
        outputString+=fileName;
        int layout = maxFileNameLength+2+maxDepth-depth;
        for(int i=this.fileName.length(); i<layout; i++){
            outputString+=" ";            
        }
        if(fileType == FileType.DIRECTORY){
            outputString+="K";
        }
        else if(fileType == FileType.FILE){
            outputString+="P";
        }
        else outputString+="?";
        outputString+="   ";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        outputString+=sdf.format(lastModified);
        System.out.println(outputString);
    }
    
    public void printAllChildren(){
        files.stream().forEach((df) -> {
            df.print();
            if(isReccurent){
                df.printAllChildren();
            }
        });
    }
   
}
