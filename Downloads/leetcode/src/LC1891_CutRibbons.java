
public class LC1891_CutRibbons {

    public static void main(String[] args) {
        int[] nums = new int[]{9,7,5};
        int k = 3;
        LC1891_CutRibbons n = new LC1891_CutRibbons();
        int result = n.maxLength(nums,k);
        System.out.println(result);
    }
    public int maxLength(int[] ribbons, int k) {
        int l = 1;
        int r = Integer.MIN_VALUE;
        long sum = 0;
        for (int ribbon : ribbons) {
            r = Math.max(ribbon, r);
            sum += ribbon;
        }
        //r = Math.min(sum/k, r);
        int maxCanCut = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canCut(ribbons, k, sum, mid)) {
                maxCanCut = Math.max(maxCanCut, mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }


        return maxCanCut;
    }

    private boolean canCut(int[] ribbons, int k, long sum, int len) {
        if (sum / len < k) return false;

        for (int ribbon : ribbons) {
            k -= ribbon / len;
            if (k <= 0) return true;
        }

        return false;
    }
}