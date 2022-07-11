import java.util.HashMap;
import java.util.Map;

public class leetcode001TwoSum{
    public static int[] solution1(int[] nums, int target) {
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static int[] solution2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }

    public static int[] solution3(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        merge_sort(nums, l, r);
        while(l <= r) {
            if(nums[l] + nums[r] == target) {
                return new int[]{l, r};
            } else if(nums[l] + nums[r] < target) {
                l++;
            } else{                
                r--;
            }            
        }
        return null;
    }

    /* Divide and Conquer */
    private static void merge_sort(int[] arr, int l, int r) {
        if(l < r) {
            int m = l + (r - l) / 2;
            merge_sort(arr, l, m);
            merge_sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    /* Merge two subarrays */
    private static void merge(int[] arr, int l, int m, int r) {
        int[] L = new int[m - l + 1];
        int[] R = new int[r - m];
        for(int i = 0; i < L.length; i++) {
            L[i] = arr[l + i];
        }

        for(int i = 0; i < R.length; i++) {
            R[i] = arr[m + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while(i < L.length && j < R.length) {
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

         //copy remaining elements of L[] if any
         while (i < L.length) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        //copy remaining elements of R[] if any
        while (j < R.length) {
            arr[k] = R[j];
            j++;
            k++;
        }

    }

    public static void main(String[] args) {
        int[] nums1 = {2,7,11,15};
        int target1 = 9;
        System.out.printf("Answer for Solution 1 = [%d, %d]\n", solution1(nums1, target1)[0], solution1(nums1, target1)[1]);   
        System.out.printf("Answer for Solution 2 = [%d, %d]\n", solution2(nums1, target1)[0], solution2(nums1, target1)[1]);     
        System.out.printf("Answer for Solution 3 = [%d, %d]\n", solution3(nums1, target1)[0], solution3(nums1, target1)[1]);     

        int[] nums2 = {3,2,4};
        int target2 = 6;
        System.out.printf("Answer for Solution 1 = [%d, %d]\n", solution1(nums2, target2)[0], solution2(nums2, target2)[1]);  
        System.out.printf("Answer for Solution 2 = [%d, %d]\n", solution2(nums2, target2)[0], solution2(nums2, target2)[1]);  
        System.out.printf("Answer for Solution 3 = [%d, %d]\n", solution3(nums2, target2)[0], solution3(nums2, target2)[1]);  

        int[] nums3 = {3,3};
        int target3 = 6;
        System.out.printf("Answer for Solution 1 = [%d, %d]\n", solution1(nums3, target3)[0], solution1(nums3, target3)[1]);  
        System.out.printf("Answer for Solution 2 = [%d, %d]\n", solution2(nums3, target3)[0], solution2(nums3, target3)[1]);  
        System.out.printf("Answer for Solution 3 = [%d, %d]\n", solution3(nums3, target3)[0], solution3(nums3, target3)[1]);  
    }
}