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
//    Counting Bits
//    Binary Watch
//    Hamming Distance
//    Number Complement
//    Set Mismatch
//    Binary Number with Alternating Bits
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
