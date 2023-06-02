import java.util.Date;

public abstract class Node {
    protected String name;
    protected int permission;
    protected Node parent;
    protected final Date created;
    protected Date modified;

    protected Node(String n, Node p) {
        name = n;
        parent = p;
        long millis = System.currentTimeMillis();
        created = new java.util.Date(millis);

    }

    //protected abstract String getContent();

    public Date getCreated() {
        return created;
    }

    public Date getModified() {
        return modified;
    }

    public Date setModified(Date time) {
        modified = time;
        return modified;
    }
    public void reName(String n) {
        name = n;

    }


    protected abstract long getSize(); // 所有derived class必须实现，并且实现不一样

    public String getCurrentPath() {
        if (parent == null ) return "c:/";
        return parent.getCurrentPath() + "/" + name;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }
}
