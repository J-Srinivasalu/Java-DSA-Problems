import java.util.ArrayList;
import java.util.Arrays;

public class SearchingEasy {

    //Square root
    public int mySqrtBinarySearch(int x) {
        int s = 1;
        int e = x;
        if (x == 0) {
            return 0;
        }
        while (true) {
            int mid = s + (e - s) / 2;
            if (mid > x / mid) {
                e = mid - 1;
            } else {
                if ((mid + 1) > x / (mid + 1)) {
                    return mid;
                }
                s = mid + 1;
            }
        }
    }

    public int mySqrtNewton(int x) {
        long r = x;
        while (r * r > x)
            r = (r + x / r) / 2;
        return (int) r;
    }

    //Guess Number Higher or Lower
    public int guessNumber(int n) {
        int s = 1;
        int e = n;
        while (true) {
            int mid = s + (e - s) / 2;
            int t = guess(mid);
            if (t == 0) return mid;
            if (t == -1) e = mid - 1;
            else s = mid + 1;
        }
    }

    private static int guess(int n) {
        return Integer.compare(n, 6);
    }

    //    First Bad Version
    public int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;
        int mid = 0;
        int res = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)) {
                hi = mid - 1;
                res = mid;
            } else {
                lo = mid + 1;
            }
        }
        return res;
    }

    private boolean isBadVersion(int n) {
        boolean[] arr = {true, true, true, true, false, false};
        return !arr[n];
    }

    //    Two Sum II - Input array is sorted
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                return new int[]{start + 1, end + 1};
            } else if (numbers[start] + numbers[end] > target) {
                end--;
            } else {
                start++;
            }
        }
        return new int[]{-1, -1};
    }

    //    Valid Perfect Square
    public boolean isPerfectSquare(int num) {
        int start = 1;
        int end = num;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int res = num / mid;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                start = mid + 1;
            } else end = mid - 1;
        }
        return false;
    }

    //    Arranging Coins(Easy)
    public int arrangeCoins(int n) {
        int ans = 0;
        int i = 1;
        long sum = 0;
        while (true) {
            if (sum == n) {
                return ans;
            }
            sum += i;
            i++;
            if (sum > n) return ans;
            ans++;

        }
    }

    public int arrangeCoinsBinarySearch(int n) {
        if (n <= 1) {
            return n;
        }
        if (n <= 3) {
            return n == 3 ? 2 : 1;
        }
        long s = 2;
        long e = n / 2;
        while (s <= e) {
            long m = s + (e - s) / 2;
            long coinfilled = m * (m + 1) / 2;
            if (coinfilled == n) return (int) m;
            if (coinfilled < n) s = m + 1;
            else e = m - 1;

        }
        return (int) e;
    }

    public int arrangeCoinsOneLiner(int n) {
        return (int) (Math.sqrt(2 * (long) n + 0.25) - 0.5);
    }

    //    Find Smallest Letter Greater Than Target
    public char nextGreatestLetter(char[] letters, char target) {
        int s = 0;
        int e = letters.length - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (letters[m] > target) e = m - 1;
            else s = m + 1;
        }
        return letters[s % letters.length];
    }

    //    Kth Missing Positive Number
    public static int findKthPositive(int[] arr, int k) {
        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (arr[m] - m - 1 < k) s = m + 1;
            else e = m - 1;
        }
        return e + k;
    }

    //    Search Insert Position
    public int searchInsert(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;

        if (target > nums[e]) return e + 1;
        if (target < nums[s]) return s;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) {
                if (nums[mid - 1] < target) return mid;
                else e = mid - 1;
            } else {
                if (nums[mid + 1] > target) return mid + 1;
                else s = mid + 1;
            }
        }
        return 0;
    }

    //    Peak Index in a Mountain Array
    public static int findPeak(int[] mountain) {
        int start = 0;
        int end = mountain.length - 1;
        if (mountain[end] > mountain[end - 1]) {
            return end;
        }
        if (mountain[start] > mountain[start + 1]) {
            return start;
        }
        while (start != end) {
            int mid = start + (end - start) / 2;
            if (mountain[mid] < mountain[mid + 1]) start = mid + 1;
            else end = mid;
        }
        return start;
    }

    //    Count Negative Numbers in a Sorted Matrix
    public int countNegatives(int[][] grid) {
        int ans = 0;
        int r = 0;
        int c = grid[0].length - 1;
        while (r < grid.length && c >= 0) {
            if (grid[r][c] < 0) {
                ans = ans + (grid.length - r);
                c--;
            } else {
                r++;
            }
        }
        return ans;
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

    //    Fair Candy Swap
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumAlice = 0;
        int sumBob = 0;
        for (int i : aliceSizes) sumAlice += i;
        for (int i : bobSizes) sumBob += i;
        int difference = (sumAlice - sumBob) / 2;

        Arrays.sort(aliceSizes); // N log N
        for (int i : bobSizes) {
            if (binarySearch(aliceSizes, difference + i) >= 0) return new int[]{difference + i, i};
        }
        return null;
    }

    //    Check If N and Its Double Exist
    public boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j] * 2) return true;
                if (arr[j] == arr[i] * 2) return true;
            }
        }
        return false;
    }

    public boolean checkIfExistBinarySearch(int[] arr) {
        Arrays.sort(arr);

        for (int i = 0, n = arr.length; i < n; i++)
            if (arr[i] == 0) {
                if (i + 1 < n && arr[i + 1] == 0)
                    return true;
            } else if (Arrays.binarySearch(arr, arr[i] * 2) >= 0) {
                return true;
            }

        return false;
    }

    //    Special Array With X Elements Greater Than or Equal X
    private static final int NUM_MAX = 1001;

    public int specialArray(int[] nums) {
        var numCounts = new int[NUM_MAX];
        for (var num : nums)
            numCounts[num]++;

        var n = nums.length;
        for (var i = 0; i < NUM_MAX; i++) {
            if (n == i)
                return i;
            n -= numCounts[i];
        }
        return -1;
    }

    //    Binary Search
    public int binarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] < target) start = mid + 1;
            else if (array[mid] > target) end = mid - 1;
            else return mid;
        }
        return -1;
    }
}
