import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingEasy {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        String s = "234";
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    //    Merge Sorted Array
    public static void mergeSort(int[] arr, int s, int e) {
        if (s < e) {
            int m = s + (e - s) / 2;

            mergeSort(arr, s, m);
            mergeSort(arr, m + 1, e);
            merge(arr, s, m, e);
        }
    }

    public static void merge(int[] arr, int s, int m, int e) {
        int i = s;
        int j = m + 1;
        int k = 0;
        int[] mix = new int[e - s + 1];
        while (i <= m && j <= e) {
            if (arr[i] < arr[j]) {
                mix[k++] = arr[i++];
            } else {
                mix[k++] = arr[j++];
            }
        }
        while (i <= m) {
            mix[k++] = arr[i++];
        }
        while (j <= e) {
            mix[k++] = arr[j++];
        }
        k = s;
        for (int value : mix) {
            arr[k++] = value;
        }
    }

    //    Majority Element
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int l = nums.length;
        return nums[l / 2];
    }

    //    Contains Duplicate
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (prev == nums[i]) {
                return true;
            }
            prev = nums[i];
        }
        return false;
    }

    //    Missing Number
    public int missingNumber(int[] nums) {
        int n = nums.length;
        cyclicSortZeroValued(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) return i;
        }
        return n;
    }

    void cyclicSortZeroValued(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i];
            if (arr[i] < arr.length && arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }
    }

    void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    //    Intersection of Two Arrays
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int[] map = new int[1001];
        for (int i : nums1) map[i]++;
        for (int i : nums2)
            if (map[i] != 0) {
                map[i]--;
                if (!ans.contains(i)) ans.add(i);
            }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    //    Intersection of Two Arrays II
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int[] map = new int[1001];
        for (int i : nums1) map[i]++;
        for (int i : nums2)
            if (map[i] != 0) {
                map[i]--;
                ans.add(i);
            }

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    //    Third Maximum Number
    public int thirdMax(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length -1;
        int max = nums[n];
        int count = 0;
        int thirdMax = Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            if(nums[i] != max){
                count++;
                if(count == 2){
                    thirdMax = nums[i];
                    break;
                }
                max = nums[i];
            }
        }
        if(count<2){
            return nums[n];
        }
        return thirdMax;
    }
//    Assign Cookies
//    Array Partition I
//    Maximum Product of Three Numbers
//    Sort Array By Parity
//    Sort Array By Parity II
//    Largest Perimeter Triangle
//    Squares of a Sorted Array
//    Matrix Cells in Distance Order
//    Height Checker
//    Relative Sort Array
//    Minimum Absolute Difference
//    Rank Transform of an Array
//    Sort Integers by The Number of 1 Bits
//    How Many Numbers Are Smaller Than the Current Number
//    Maximum Product of Two Elements in an Array
//    Average Salary Excluding the Minimum and Maximum Salary
//    Make Two Arrays Equal by Reversing Sub-arrays
//    Can Make Arithmetic Progression From Sequence
//    Sort Array by Increasing Frequency
//    Special Array With X Elements Greater Than or Equal X
    //    Find all numbers disappeared in an array
    public List<Integer> missingNumbers(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        cyclicSortOneValued(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i - 1) {
                ans.add(arr[i]);
            }
        }
        return ans;
    }

    public void cyclicSortOneValued(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] < arr.length && arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }
    }
//    Set Mismatch
//    2Sum


}
