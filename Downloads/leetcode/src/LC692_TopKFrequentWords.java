import java.util.*;

public class LC692_TopKFrequentWords {

    public static void main(String[] args) {
        String[] words = new String[]{"i","love","leetcode","i","love","coding"};
        int k = 2;
        LC692_TopKFrequentWords m = new LC692_TopKFrequentWords();
        List<String> result = m.topKFrequent(words,k);
        System.out.println(result);
    }
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        Queue<String> minHeap = new PriorityQueue<>((a, b) -> map.get(a) == map.get(b) ? b.compareTo(a) : map.get(a) - map.get(b));
        for (String word : map.keySet()) {
            minHeap.add(word);
            if (minHeap.size() > k) minHeap.poll();
        }

        List<String> res = new ArrayList<>();
        while(!minHeap.isEmpty()) {
            res.add(minHeap.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
