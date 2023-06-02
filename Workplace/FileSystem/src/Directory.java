import java.util.ArrayList;
import java.util.List;

public class Directory extends Node {
    private List<Node> content;

    public Directory(String n, Node p, int pm) {
        super(n,p);
        permission = pm; //protected
        content = new ArrayList<Node>();
    }
    public void addNode(Node node) {
        content.add(node);
    }
    public void deleteNode(Node node) {
        content.remove(node);
    }
    //@Override
    public List<Node> getContent() {
        return content;
    }

    @Override
    public long getSize() { // 必须实现
        long size = 0;
        for (Node n : content) {
            size += n.getSize(); // recursion return case1 leaf file case2 leaf empty
        }
        return size;
    }

    public int countFiles() {
        int count = 0;
        for (Node child : content) {
            if (child instanceof Directory) {
                Directory d = (Directory) child;
                count += d.countFiles();
            } else {
                count++;
            }
        }
        return count;
    }
}


