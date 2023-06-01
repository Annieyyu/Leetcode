
public class LC275_HIndex {

    public static void main(String[] args) {
        int[] citations = new int[]{0,1,3,5,6};
        LC275_HIndex m = new LC275_HIndex();
        int result = m.hIndex(citations);
        System.out.println(result);
    }
    public int hIndex(int[] citations) {
        // c.c.
        int len = citations.length;
        int start = 0;
        int end = len - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (citations[mid] == len - mid) {
                return len - mid;
            } else if (citations[mid] < len - mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return len - start;
    }
}