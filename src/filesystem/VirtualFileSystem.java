package filesystem;

public class VirtualFileSystem {

    private Directory root;
    private Directory currentDirectory;

    public VirtualFileSystem() {

        root = new Directory("root", null);
        currentDirectory = root;

    }

    // -----------------------------
    // Create Directory
    // -----------------------------
    public void mkdir(String directoryName) {

    for (Directory directory : currentDirectory.getDirectories()) {
        if (directory.getName().equals(directoryName)) {
            System.out.println("Directory already exists.");
            return;
        }
    }

    currentDirectory.getDirectories().add(
            new Directory(directoryName, currentDirectory));

    System.out.println("Directory created.");
}

    // -----------------------------
    // List Files & Directories
    // -----------------------------
    public void ls() {

        for (Directory directory :
                currentDirectory.getDirectories()) {

            System.out.println("[DIR] " + directory.getName());

        }

        for (VirtualFile file :
                currentDirectory.getFiles()) {

            System.out.println("[FILE] " + file.getName());

        }

    }

    // -----------------------------
    // Print Working Directory
    // -----------------------------
    public String pwd() {

        if (currentDirectory == root)
            return "/";

        StringBuilder path = new StringBuilder();

        Directory temp = currentDirectory;

        while (temp != root) {

            path.insert(0, "/" + temp.getName());

            temp = temp.getParent();

        }

        return path.toString();

    }

    // -----------------------------
    // Change Directory
    // -----------------------------
   public boolean cd(String directoryName) {

    // Go to parent directory
    if (directoryName.equals("..")) {

        if (currentDirectory.getParent() != null) {
            currentDirectory = currentDirectory.getParent();
        }

        return true;
    }

    // Go to child directory
    for (Directory directory : currentDirectory.getDirectories()) {

        if (directory.getName().equals(directoryName)) {

            currentDirectory = directory;
            return true;
        }
    }

    return false;
}

    // -----------------------------
    // Create File
    // -----------------------------
    public void touch(String fileName) {

        VirtualFile file =
                new VirtualFile(fileName);

        currentDirectory
                .getFiles()
                .add(file);

    }

    // -----------------------------
    // Display File Content
    // -----------------------------
    public void cat(String fileName) {

        for (VirtualFile file :
                currentDirectory.getFiles()) {

            if (file.getName().equals(fileName)) {

                System.out.println(file.getContent());

                return;

            }

        }

        System.out.println("File not found.");

    }

    // -----------------------------
    // Write File
    // -----------------------------
    public void write(String fileName,
                      String content) {

        for (VirtualFile file :
                currentDirectory.getFiles()) {

            if (file.getName().equals(fileName)) {

                file.setContent(content);

                return;

            }

        }

        System.out.println("File not found.");

    }

}