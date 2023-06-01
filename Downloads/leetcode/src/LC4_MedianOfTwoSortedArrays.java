public class LC4_MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,4};
        int[] nums2 = new int[]{5,6,7,8};
        LC4_MedianOfTwoSortedArrays m = new LC4_MedianOfTwoSortedArrays();
        double res = m.findMedianSortedArrays(nums1,nums2);
        System.out.print(res);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        return (getKth(nums1, 0,  nums2, 0, left) + getKth(nums1, 0,  nums2, 0, right)) * 0.5;
    }

    private int getKth(int[] nums1, int left1, int[] nums2, int left2,  int k) {
        int len1 = nums1.length - left1;
        int len2 = nums2.length - left2;
        if (len1 > len2) return getKth(nums2, left2, nums1, left1, k);
        if (len1 == 0) return nums2[left2 + k - 1];

        if (k == 1) return Math.min(nums1[left1], nums2[left2]);
        int k1 = Math.min(len1, k / 2);
        int k2 = Math.min(len2, k - k1);
        int index1 = left1 + k1 - 1;
        int index2 = left2 + k2 - 1;

        if (nums1[index1] > nums2[index2]) {
            return getKth(nums1, left1,  nums2, index2 + 1,  k - k2);
        }
        else {
            return getKth(nums1, index1 + 1,  nums2, left2,  k - k1);
        }
    }
}
