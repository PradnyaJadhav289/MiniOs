package model;

public class JavaFile {

    private String name;
    private String path;
    private long size;
    private boolean directory;
    private boolean exists;

    // Default Constructor
    public JavaFile() {

    }

    // Parameterized Constructor
    public JavaFile(String name, String path, long size, boolean directory, boolean exists) {
        this.name = name;
        this.path = path;
        this.size = size;
        this.directory = directory;
        this.exists = exists;
    }

    // Getters

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public long getSize() {
        return size;
    }

    public boolean isDirectory() {
        return directory;
    }

    public boolean isExists() {
        return exists;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void setDirectory(boolean directory) {
        this.directory = directory;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }

    @Override
    public String toString() {
        return "JavaFile{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", size=" + size +
                ", directory=" + directory +
                ", exists=" + exists +
                '}';
    }
}