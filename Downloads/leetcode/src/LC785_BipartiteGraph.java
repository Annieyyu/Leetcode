import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC785_BipartiteGraph {

    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}};
        test(matrix1, "Test Case 1");
        int[][] matrix2 = new int[][]{{1,3},{0,2},{1,3},{0,2}};
        test(matrix2, "Test Case 2");

    }

    private static void test(int[][]graph, String testCase) {
        LC785_BipartiteGraph m = new LC785_BipartiteGraph();
        boolean result = m.isBipartite(graph);
        System.out.println(testCase + ": " + result);
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int start = 0; start < n; start++) {
            if (color[start] == -1) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(start);
                color[start] = 0;

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    for (int neighbor : graph[node]) {
                        if (color[neighbor] == -1) {
                            queue.offer(neighbor);
                            color[neighbor] = color[node] ^ 1;
                        } else if (color[neighbor] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
