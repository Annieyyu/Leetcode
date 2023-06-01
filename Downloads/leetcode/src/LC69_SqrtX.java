
public class LC69_SqrtX {

    public static void main(String[] args) {
        int x = 8;
        LC69_SqrtX m = new LC69_SqrtX();
        int result = m.mySqrt(x);
        System.out.println(result);
    }
    public int mySqrt(int x) {
        // c.c.
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int start = 0;
        int end = x;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            } else if ((mid + 1) <= x / (mid + 1)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        throw new RuntimeException();
    }
}