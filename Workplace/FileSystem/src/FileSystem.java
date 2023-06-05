public class FileSystem {
    // fields
    Directory root;

    // methods
    FileSystem() {
        root = new Directory("anyName", null, 777);
        root.setParent(root);
    }

    public void mkDir(String path){
      traverse(path, 0);
    }


    public void createFile(String path, long size){//a/b/c.java
        //不能走到最底，走到倒数第二个，对相同文件做处理
        String[] pathNames = path.split("/");
        Node cur =  traverse(path, 1);
        if (cur instanceof Directory ) {
            File file = new File(pathNames[pathNames.length - 1], (Directory) cur, size, 777);
            ((Directory) cur).getContent().add(file);
        }else{
            throw new RuntimeException("is a file");
        }
    }

    public boolean cd(String path){
        if (path == null || path.length() == 0) return false;
        String[] pathNames = path.split("/"); //a/b/c
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
                return false;
            }
        }
        return true;
    }

    public boolean delete(String path){//a/b/c/d
        if (!cd(path)) {
            return false;
        }
        Node deleteNode = traverse(path, 0);
        Directory directory = (Directory) traverse(path, 1);
        directory.deleteNode(deleteNode);
        return true;
    }

    public int countFiles(){
        return root.countFiles();
    }

    public long getSize(){
        return root.getSize();
    }



    private Node traverse(String path, int lastLine) {
        if (path == null || path.length() == 0) return root;
        String[] pathNames = path.split("/");
        Directory cur = root;
        boolean flag = false;
        for (int i = 0; i < pathNames.length - lastLine; i++) {
            String name = pathNames[i];
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
        return cur;
    }
}

