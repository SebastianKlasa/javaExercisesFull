package javafxfilemanagerapp;

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
    private final String filePath;
    private final Set<DiskFile> files;
    private Date lastModified;
    private File file;
    private FileType fileType;
    private int depth;
    private boolean isSorted;
    private boolean isReccurent;
    
    public DiskFile(boolean isReccurent, boolean isSorted, File file,
            int depth){
        this.isReccurent = isReccurent;
        this.isSorted = isSorted;
        this.file = file;
        this.filePath = file.getAbsolutePath();
        if(this.filePath.length()>maxFileNameLength){
            maxFileNameLength = this.filePath.length();
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
    
    public String getFilePath(){
        return this.filePath;
    }
    
    public String getFileName(){
        return this.file.getName();
    }
    
    public String getModified(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(lastModified);
    }
    
    public File getFile(){
        return this.file;
    }
    
    public FileType getFileType(){
        return this.fileType;
    }
    
    public Set<DiskFile> getAllFiles(){
        return files;
    }

    @Override
    public int compareTo(DiskFile o) {
        return filePath.compareTo(o.getFilePath());
    }
    
    @Override
    public boolean equals(Object o){
        DiskFile other = (DiskFile)o;
        System.out.println(other.getFilePath());
        if(this.filePath.equals(other.getFilePath())){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.filePath);
        hash = 71 * hash + Objects.hashCode(this.files);
        hash = 71 * hash + Objects.hashCode(this.lastModified);
        hash = 71 * hash + Objects.hashCode(this.fileType);
        hash = 71 * hash + this.depth;
        hash = 71 * hash + (this.isSorted ? 1 : 0);
        hash = 71 * hash + (this.isReccurent ? 1 : 0);
        return hash;
    }
    
    public int initializeFile(){
        File thisFileData = new File(filePath);
        boolean isDirectory = thisFileData.isDirectory();
        boolean isFile = thisFileData.isFile();
        if(isDirectory){
            fileType = FileType.DIRECTORY;
            File[] childrenFiles = thisFileData.listFiles();
            for (File childrenFile : childrenFiles) {
                DiskFile newFile = new DiskFile(isReccurent, isSorted, childrenFile, depth+1);
                files.add(newFile);
            }
        }
        else if (isFile) fileType = FileType.FILE;
        else fileType = FileType.UNKNOWN;
        long lastModifiedMS = thisFileData.lastModified();
        lastModified = new Date(lastModifiedMS);
        return 1;
    }
    
    public void deleteFile(){
        this.file.delete();        
    }
    
}
