import java.util.*;

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

        for (int i = nums.length - 1; i > 1; i--) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }
        return 0;
    }

    //    Squares of a Sorted Array
    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int[] ans = new int[nums.length];

        for (int k = nums.length - 1; k >= 0; k--) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                ans[k] = nums[i] * nums[i];
                i++;
            } else {
                ans[k] = nums[j] * nums[j];
                j--;
            }
        }
        return ans;
    }

    //    Matrix Cells in Distance Order
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] coordinates = new int[cols * rows][2];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int k = i * cols + j;
                coordinates[k][0] = i;
                coordinates[k][1] = j;
            }
        }
        Arrays.sort(coordinates, (a, b) -> {
            int d1 = Math.abs(rCenter - a[0]) + Math.abs(cCenter - a[1]);
            int d2 = Math.abs(rCenter - b[0]) + Math.abs(cCenter - b[1]);
            return d1 - d2;
        });

        return coordinates;
    }

    //    Height Checker
    public int heightChecker(int[] heights) {
        int[] expected = Arrays.copyOf(heights, heights.length);
        Arrays.sort(expected);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        return count;
    }

    //    Relative Sort Array
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int largest = 0;
        // get the largest element from arr1
        for (int j : arr1) largest = Math.max(j, largest);

        // create an array of size (largest+1) to store frequencies of elements in arr1
        int[] frequencies = new int[largest + 1];
        for (int j : arr1) frequencies[j]++;

        int index = 0;
        for (int j : arr2) {
            // insert the current element of arr2 till freqeuncy of this element in arr1 becomes 0
            while ((frequencies[j]--) > 0)
                arr1[index++] = j;
        }

        // insert the remaining elements of arr1 as per their frequencies  which were not present in arr2
        for (int i = 1; i < frequencies.length; i++) {
            while ((frequencies[i]--) > 0)
                arr1[index++] = i;
        }
        return arr1;
    }

    //    Minimum Absolute Difference
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList();
        //sort elements
        Arrays.sort(arr);
        //init our min difference value
        int min = Integer.MAX_VALUE;
        //start looping over array to find real min element. Each time we found smaller difference
        //we reset resulting list and start building it from scratch. If we found pair with the same
        //difference as min - add it to the resulting list
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff < min) {
                min = diff;
                res.clear();
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            } else if (diff == min) {
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        return res;
    }

    public List<List<Integer>> minimumAbsDifference2(int[] arr) {
        Arrays.sort(arr);
        int minDif = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            if (Math.abs(arr[i + 1] - arr[i]) < minDif)
                minDif = Math.abs(arr[i + 1] - arr[i]);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (Math.abs(arr[i + 1] - arr[i]) == minDif)
                result.add(Arrays.asList(arr[i], arr[i + 1]));
        }
        return result;
    }

    //    Rank Transform of an Array
    public int[] arrayRankTransform(int[] arr) {

        int[] arrCopy = arr.clone();
        Arrays.sort(arrCopy);
        Map<Integer, Integer> map = new HashMap<>();


        for(int i: arrCopy){
            map.putIfAbsent(i, map.size()+1);
        }
        for(int i=0;i<arr.length;i++){
            arrCopy[i] = map.get(arr[i]);
        }
        return arrCopy;
    }
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
