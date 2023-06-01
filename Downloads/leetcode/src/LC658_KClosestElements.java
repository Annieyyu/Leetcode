import java.util.ArrayList;
import java.util.List;

public class LC658_KClosestElements {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        int k = 4;
        int x = 3;
        LC658_KClosestElements m = new LC658_KClosestElements();
        List<Integer> result = m.findClosestElements(arr,k,x);
        System.out.println(result);
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0) return null;
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left + 1 < right){
            mid = left + (right - left) / 2;
            if (x > arr[mid]){
                left = mid;
            } else{
                right = mid;
            }
        }
        for (int i = 0; i < k; i++){
            if (left >= 0 && right <= arr.length -1){
                if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)){
                    left--;
                } else{
                    right++;
                } //target正好落在array里面并且指针都没有出界
            } else if(left < 0){
                right++;
            } else {
                left--;
            }
        }
        int start = left < 0 ? 0 : left + 1; //left跳出之后是在起始位置的左边一个值
        for (int i = 0; i < k; i++){
            res.add(arr[start+i]);
        }
        return res;
    }
}