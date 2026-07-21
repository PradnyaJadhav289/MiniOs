package filesystem;

import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import exceptions.InvalidCommandException;
import logger.Logger;

import java.nio.file.Path;

public class FileManager {

    public FileManager() {
        // Constructor
        Logger.Info("File Manager initialized.");

    }

    public void initialize() {
        File storage = new File("storage");
        if (!storage.exists()) {
            storage.mkdir();
            Logger.Info("Storage directory created.");
        } else {
            Logger.Error("Storage directory already exists.");
        }
    }

    public void  createFile(String fileName) throws InvalidCommandException  {
        // Logic to create a file
        
        try {
            File storage = new File("storage");
            File file = new File(storage, fileName);
            if (file.exists()) {
                throw new IOException("File already exists.");
            }
            file.createNewFile();
        } catch (IOException e) {
throw new InvalidCommandException(e.getMessage());
     }
    }

   

    public File[] listFiles() {
        File storage = new File("storage");
        return storage.listFiles();
    }

    public String openFile(String fileName) throws InvalidCommandException {
        File file = new File("storage", fileName);
        if (!file.exists()) {
            return null;
        }
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new InvalidCommandException(e.getMessage());
        }
        return content.toString();
    }

    public boolean fileExists(String fileName) {
        File file = new File("storage", fileName);
        return file.exists();
    }

    public void writeFile(String fileName, String content) throws InvalidCommandException {
        File file = new File("storage", fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new InvalidCommandException(e.getMessage());
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(content);
        } catch (IOException e) {
            throw new InvalidCommandException(e.getMessage());
        }
    }

    public void  deleteFile(String fileName) throws InvalidCommandException {
        File file =new File("storage", fileName);
        if(!file.exists()){
            throw new InvalidCommandException("File not found.");
        }
        file.delete();
    }
   
    public void  renameFile(String oldName, String newName) throws InvalidCommandException {
        File oldfile =new File("storage",oldName);
        File newfile =new File("storage",newName);
        if(!oldfile.exists()){
            throw new InvalidCommandException("File not found.");
        }   
        oldfile.renameTo(newfile);
    }

    public void copyFile(String sourceName,String destiName) throws InvalidCommandException {

        try{
            Path source = Paths.get("storage",sourceName);
            Path destination = Paths.get("storage",destiName);
            
            if(!Files.exists(source)){
                throw new InvalidCommandException("Source file not found.");
            }
            
            if(Files.exists(destination)){
                throw new InvalidCommandException("Destination file already exists.");
            }
            Files.copy(source, destination);
        } catch (IOException e) {
            throw new InvalidCommandException("Error copying file.");
        }
    }
}

