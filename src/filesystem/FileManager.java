package filesystem;

import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class FileManager {

    public FileManager() {
        // Constructor
        System.out.println("File Manager initialized.");

    }

    public void initialize() {
        File storage = new File("storage");
        if (!storage.exists()) {
            storage.mkdir();
            System.out.println("Storage directory created.");
        } else {
            System.out.println("Storage directory already exists.");
        }
    }

    public boolean createFile(String fileName) {
        // Logic to create a file
        try {
            File storage = new File("storage");
            File file = new File(storage, fileName);
            if (file.exists()) {
                return false;
            }
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

   

    public File[] listFiles() {
        File storage = new File("storage");
        return storage.listFiles();
    }

    public String openFile(String fileName) {
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
            e.printStackTrace();
            return null;
        }
        return content.toString();
    }

    public boolean fileExists(String fileName) {
        File file = new File("storage", fileName);
        return file.exists();
    }

    public boolean writeFile(String fileName, String content) {
        File file = new File("storage", fileName);
        if (!file.exists()) {
            return false;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(content);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteFile(String fileName){
        File file =new File("storage", fileName);
        if(!file.exists()){
            return false;
        }
        return file.delete();
    }
}
