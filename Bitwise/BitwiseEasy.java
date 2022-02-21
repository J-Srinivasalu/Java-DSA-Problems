import java.util.*;

public class BitwiseEasy {
    //    Add Binary
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;

            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';

            carry = sum > 1 ? 1 : 0;

            ans.append(sum % 2);
        }
        if (carry == 1) ans.append(carry);
        return ans.reverse().toString();
    }

    //    Single Number
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i : nums) {
            ans ^= i;
        }
        return ans;
    }

    //    Reverse Bits
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans <<= 1; //left shift to append the next bit to last position
            ans += n & 1; // append or add next bit from n
            n >>= 1; //right shift to eliminate last digit
        }
        return ans;
    }

    //    Number of 1 Bits
    public int hammingWeight(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans += n & 1; // add if the bit value is 1
            n >>= 1; // shift right to remove last checked bit
        }
        return ans;
    }

    //    Counting Bit
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            ans[i] = bitCount(i);
        }

        return ans;
    }

    public int bitCount(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt += (n & 1);
            n = n >> 1;
        }

        return cnt;
    }

    //using previous ans - optimized
    public int[] countBitsOptimized(int n) {
        int[] ans = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }

        return ans;
    }

    //    Binary Watch
    public List<String> readBinaryWatch(int num) {
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == num) {

                    String str = "" + i + ":";
                    if (j < 10) str += "0";
                    str += "" + j;
                    ans.add(str);
                }
            }
        }
        return ans;
    }

    //    Hamming Distance
    public int hammingDistance(int x, int y) {
        int count = 0;
        int temp = x ^ y;                  // take the xor of two numbers
        while (temp != 0) {                // count the no of "1"s
            if ((temp & 1) == 1)
                count++;
            temp = temp >> 1;
        }
        return count;
    }

    //    Number Complement

    //https://leetcode.com/problems/number-complement/discuss/1649516/Java-or-0-ms-or-1-liner-or-Explained
    public int findComplement(int num) {
        var nBits = (int) Math.floor((Math.log(num) / Math.log(2)) + 1);
        var mask = (1 << nBits) - 1;
        return ~num & mask;
    }

    public int findComplementOneLiner(int num) {
        return ~num & (Integer.highestOneBit(num) - 1);
    }

    //    Set Mismatch
    public int[] findErrorNums(int[] nums) {
        cyclicSort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[]{nums[i], i + 1};
            }
        }
        return new int[]{-1, -1};
    }

    public void cyclicSort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == nums[nums[i] - 1]) {
                i++;
            } else {
                swap(nums, i, nums[i] - 1);
            }
        }
    }

    public void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    //    Binary Number with Alternating Bits
    boolean hasAlternatingBits(int n) {
        /*
        n =         1 0 1 0 1 0 1 0
        n >> 1      0 1 0 1 0 1 0 1
        n ^ n>>1    1 1 1 1 1 1 1 1
        n           1 1 1 1 1 1 1 1
        n + 1     1 0 0 0 0 0 0 0 0
        n & (n+1)   0 0 0 0 0 0 0 0
        */

        n = n ^ (n >> 1);
        return (n & n + 1) == 0;
    }

    //    Prime Number of Set Bits in Binary Representation
    //    Binary Gap
    public int binaryGap(int N) {
        int indexOne = -1, longestDistance = 0;
        for (int i = 0; i < 32; ++i) { // 32 bit number so 32 iterations, could also use Integer.toBinaryString(N).length() but the time it takes to convert to binary string is longer than just doing extra iterations for numbers smaller than 32 bits in size
            if (((N >> i) & 1) == 1) { // take the right most bit, use the bitwise 'AND' operator, if result is 1 then bit was a 1
                if (indexOne != -1) // only the first 1 will not trigger this conditional
                    longestDistance = Math.max(longestDistance, i - indexOne); // greedy
                indexOne = i; // update the index of the most recently seen '1'
            }
        }

        return longestDistance;
    }

    //    Number of Steps to Reduce a Number to Zero
    public int numberOfStepsRecursive(int num) {
        return helper(num, 0);
    }

    public int helper(int num, int i) {
        if (num == 0) return i;
        if (num % 2 == 0) return helper(num / 2, i + 1);
        else return helper(num - 1, i + 1);
    }

    public int numberOfStepsIterative(int num) {
        int i = 0;
        while (num != 0) {
            if (num % 2 == 0) num /= 2;
            else num -= 1;
            i++;
        }
        return i;
    }
//    Sort Integers by The Number of 1 Bits

    //    XOR Operation in an Array
    //Bruteforce
    public int xorOperation(int n, int start) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = start + 2 * i;
        }
        int ans = nums[0];
        for (int i = 1; i < n; i++) {
            ans ^= nums[i];
        }
        return ans;
    }

    //    Count the Number of Consistent Strings
    public int countConsistentStrings(String allowed, String[] words) {
        int ans = words.length;
        boolean[] alpha = new boolean[123];
        for (int i = 0; i < allowed.length(); i++) {
            alpha[allowed.charAt(i)] = true;
        }
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (!alpha[word.charAt(i)]) {
                    ans--;
                    break;
                }
            }
        }
        return ans;
    }

    //    Decode XORed Array
    public int[] decode(int[] encoded, int first) {
        int[] ans = new int[encoded.length + 1];
        ans[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            ans[i + 1] = ans[i] ^ encoded[i];
        }
        return ans;
    }

    //    Sum of All Subset XOR Totals
    //Easy to understand
    public static int subsetXORSum(int[] nums) {
        List<Integer> list = new ArrayList<>();
        helper(nums, 0, new Stack<>(), list);
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum;
    }

    public static void helper(int[] nums, int i, Stack<Integer> s, List<Integer> list) {
        if (i == nums.length) {
            int res = 0;
            for (Integer x : s) {
                res ^= x;
            }
            list.add(res);
            return;
        }
        helper(nums, i + 1, s, list);
        s.push(nums[i]);
        helper(nums, i + 1, s, list);
        s.pop();
    }

    //fast solution as stack and list is removed
    public int subsetXORSum2(int[] nums) {
        return helper(nums, 0, 0);
    }

    public int helper(int[] nums, int i, int cur) {
        if (i == nums.length) {
            return cur;
        }
        return (helper(nums, i + 1, cur ^ nums[i]) + helper(nums, i + 1, cur));
    }

    //    The Longest Nice Substring
    public String longestNiceSubstring(String s) {
        if (s.length() < 2) return "";
        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c : arr) set.add(c);
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (set.contains(Character.toUpperCase(c)) && set.contains(Character.toLowerCase(c))) continue;
            String sub1 = longestNiceSubstring(s.substring(0, i));
            String sub2 = longestNiceSubstring(s.substring(i + 1));
            return sub1.length() >= sub2.length() ? sub1 : sub2;
        }
        return s;
    }
}
