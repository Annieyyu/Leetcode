public class File extends Node {
    private String content;
    private long size;

    public File(String name, Directory parent, long size, int pm) {
        super(name, parent);
        this.size = size;
        permission = pm; // protected
    }

    public String getContent() {
        return content;
    }

    public String setContent(String content, long size) {
        this.size = size;
        this.content = content;
        return content;
    }

    @Override
    public long getSize() {
        return size;
    }
}
