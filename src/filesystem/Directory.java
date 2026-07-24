package filesystem;

import java.util.ArrayList;
import java.util.List;

public class Directory {

    private String name;
    private Directory parent;

    private List<Directory> directories;
    private List<VirtualFile> files;

    public Directory(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
        this.directories = new ArrayList<>();
        this.files = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Directory getParent() {
        return parent;
    }

    public List<Directory> getDirectories() {
        return directories;
    }

    public List<VirtualFile> getFiles() {
        return files;
    }
}