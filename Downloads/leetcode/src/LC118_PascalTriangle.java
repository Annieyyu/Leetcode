import java.util.ArrayList;
import java.util.List;

public class LC118_PascalTriangle {

    public static void main(String[] args) {;
        int numRows = 5;
        LC118_PascalTriangle m = new LC118_PascalTriangle();
        List<List<Integer>> result = m.generate(numRows);
        System.out.print(result);

    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0) return res;
        for(int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < i + 1; j++) {
                if(j == 0 || j == i) {
                    list.add(1);
                }else {
                    list.add(res.get(i- 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(list);
        }

        return res;

    }

}
