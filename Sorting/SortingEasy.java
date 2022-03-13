import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingEasy {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 5, 4, 3, 34, 23, 1, 89, 99, 1, 3, 4, 4};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    // quick sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int s = low;
        int e = high;
        int pivot = arr[e];
        while (s <= e) {
            while (arr[s] < pivot) {
                s++;
            }
            while (arr[e] > pivot) {
                e--;
            }
            if (s <= e) {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }
        quickSort(arr, low, e);
        quickSort(arr, s, high);
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
        ArrayList<Integer> ans = new ArrayList<>();
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
        ArrayList<Integer> ans = new ArrayList<>();
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
        int n = nums.length - 1;
        int max = nums[n];
        int count = 0;
        int thirdMax = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] != max) {
                count++;
                if (count == 2) {
                    thirdMax = nums[i];
                    break;
                }
                max = nums[i];
            }
        }
        if (count < 2) {
            return nums[n];
        }
        return thirdMax;
    }

    //    Assign Cookies
    public int findContentChildren(int[] g, int[] s) {
        int sn = s.length;
        int gn = g.length;
        if (gn == 0 || sn == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        int count = 0;

        while (i < gn && j < sn) {
            if (g[i] > s[j]) {
                j++;
            } else {
                i++;
                j++;
                count++;
            }
        }
        return count;
    }

    //    Array Partition I
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i += 2) {
            ans += Math.min(nums[i], nums[i + 1]);
        }
        return ans;
    }

    //    Maximum Product of Three Numbers
    public int maximumProduct(int[] nums) {

        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for (int num : nums) {
//             to find max1 , max2 , max3
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;

            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
//             To find min1 , min2
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }

    //    Sort Array By Parity
    public int[] sortArrayByParity(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            if (nums[i] % 2 != 0) {
                if (nums[j] % 2 == 0) {
                    swap(nums, i, j);
                    i++;
                }
                j--;
            } else {
                i++;
            }
        }
        return nums;

    }

    //    Sort Array By Parity II
    public int[] sortArrayByParityII(int[] nums) {
        int[] ans = new int[nums.length];
        int o = 1;
        int e = 0;
        for (int i : nums) {
            if (i % 2 == 0) {
                ans[e] = i;
                e += 2;
            } else {
                ans[o] = i;
                o += 2;
            }
        }
        return ans;
    }

    //    Largest Perimeter Triangle
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        for(int i=nums.length-1;i>1;i--){
            if(nums[i-2] + nums[i-1] > nums[i]){
                return nums[i-2]+nums[i-1]+nums[i];
            }
        }
        return 0;
    }
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
