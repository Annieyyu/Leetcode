public class Main {
    public static void main(String[] args) {

        FileSystem fs = new FileSystem();
        String path1 = "/Users/jyu/Downloads";
        String path2 = "/Users/jyu/Downloads/c.java";
        fs.mkDir(path1);
        fs.createFile(path2, 78965);
        boolean res = fs.cd(path1);
        int res1 = fs.countFiles();
        long res2 = fs.getSize();
        boolean res3 = fs.delete(path2);
        System.out.println(res);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);

    }
}