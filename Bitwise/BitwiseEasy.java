import java.util.ArrayList;
import java.util.List;

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
//    Number of Steps to Reduce a Number to Zero
//    Sort Integers by The Number of 1 Bits
//    XOR Operation in an Array
//    Count the Number of Consistent Strings
//    Decode XORed Array
//    Sum of All Subset XOR Totals
//    Longest Nice Substring
}
