import java.util.ArrayList;
import java.util.List;

public class MathEasy {
    public static void main(String[] args) {
    }

    //    Roman to Integer.
    public static int roman2Int(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != s.length() - 1 && getValue(s.charAt(i)) < getValue(s.charAt(i + 1))) {
                ans -= getValue(s.charAt(i));
            } else {
                ans += getValue(s.charAt(i));
            }
        }
        return ans;
    }

    public static int getValue(Character ch) {

        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    //    Happy Number.
    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
        } while (slow != fast);
        return slow == 1;
    }

    public static int squareSum(int n) {
        int sum = 0;
        while (n != 0) {
            int rem = n % 10;
            sum += rem * rem;
            n /= 10;
        }
        return sum;
    }

    //    Armstrong Numbers
    static String armstrongNumber(int n) {
        // code here
        int temp = n;
        int sum = 0;
        while (n != 0) {
            int rem = n % 10;
            sum += rem * rem * rem;
            n /= 10;
        }
        return temp == sum ? "Yes" : "No";
    }

    //    Power of Four
    public boolean isPowerOfFour(int n) {
        if (n == 0) return false;
        if (n == 1) return true; // since 1 = 4/4
        if (n % 4 == 0) return isPowerOfFour(n / 4);
        else return false;
    }

    //    Factorial
    static long factorial(int N) {
        // code here
        if (N <= 1) return 1;
        return N * factorial(N - 1);
    }

    //    Excel Sheet Column Title
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            n--;
            result.append((char) ('A' + n % 26));
            n /= 26;
        }
        result.reverse();
        return result.toString();
    }

    //    Maximum Product of Three Numbers
    public int maximumProduct(int[] nums) {

        int min1 = Integer.MAX_VALUE,min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE , max2 = Integer.MIN_VALUE , max3 = Integer.MIN_VALUE ;

        for (int num : nums) {
//             to find max1 , max2 , max3 in the array
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
//             To find min1 , min2 in the array
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        return Math.max(max1*max2*max3 , min1*min2*max1);
    }
    //    Climbing Stairs
    public int climbStairs(int n) {

        if (n <= 2) {
            return n;
        }

        int a = 1;
        int b = 2;
        int ans = a + b;

        for (int i = 3; i <= n; i++) {
            ans = a + b;
            a = b;
            b = ans;
        }
        return ans;
    }

    //    Self Dividing Numbers
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumber(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean isSelfDividingNumber(int n) {
        int temp = n;
        while (temp != 0) {
            int rem = temp % 10;
            if (rem == 0) return false;
            if (n % rem != 0) return false;
            temp /= 10;
        }
        return true;
    }

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

    //    Power of Two
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        if (n == 1) return true; // since 1 = 2 pow 0
        if (n % 2 == 0) return isPowerOfTwo(n / 2);
        else return false;
    }
}
