public class FileSystem {
    // fields
    Directory root;

    // methods
    FileSystem() {
        root = new Directory("anyName", null, 777);
        root.setParent(root);
    }

    public void mkDir(String path){}

    public void createFile(String path){}

    public void cd(String path){}

    public void delete(String path){}

    public void countFiles(){}

    public void getSize(){}


    public void mkdir(String path) {
        if (path == null || path.length() == 0) return;
        String[] pathNames = path.split("/");
        Directory cur = root;
        boolean flag = false;
        for (String name : pathNames) {
            // reset flag; ?
            for (Node child : cur.getContent()) {
                if (child instanceof Directory && child.name.equals(name)) {
                    cur = (Directory) child;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                Directory newDir = new Directory(name, cur, 777);
                cur.getContent().add(newDir);
                cur = newDir;
            }
        }
    }
}

