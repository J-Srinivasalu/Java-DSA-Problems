import java.util.Arrays;

public class RecursionEasy {
    public static void main(String[] args) {
        System.out.println(Character.MIN_VALUE);
    }

    //    Sum Triangle from Array GFG
    static int[] sumTriangle(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return new int[]{arr[0]};
        }
        int[] ans = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            ans[i] = arr[i] + arr[i + 1];
        }
        return sumTriangle(ans);
    }

    //    Maximum and Minimum value in an array GFG
    static int arrayMin(int[] arr, int n) {
        if (n == 1) return arr[0];
        return Math.min(arr[n - 1], arrayMin(arr, n - 1));
    }

    static int arrayMax(int[] arr, int n) {
        if (n == 1) return arr[0];
        return Math.max(arr[n - 1], arrayMax(arr, n - 1));
    }

    //    Binary Search using recursion leetcode
    static int binarySearch(int[] arr, int target, int start, int end) {
        int mid = start + (end - start) / 2;
        if (start > end) return -1;
        else if (arr[mid] == target) return mid;
        else if (arr[mid] > target) return binarySearch(arr, target, start, mid - 1);
        else return binarySearch(arr, target, mid + 1, end);
    }

    //    First Uppercase Letter in a String GFG
    static char firstUppercase(String s, int i) {
        if (s.length() == i) return '0';
        if (Character.isUpperCase(s.charAt(i))) return s.charAt(i);
        return firstUppercase(s, i + 1);
    }

    //    Reverse String leetcode
    public void reverseString(char[] s) {
        reverse(s, 0);
    }

    public void reverse(char[] s, int i) {
        if (i >= s.length - i - 1) return;
        char temp = s[i];
        s[i] = s[s.length - i - 1];
        s[s.length - i - 1] = temp;
        reverse(s, i + 1);
    }

    //    Print 1 To N Without Loop GFG
    public static void printTillN(int n) {
        if (n == 0) {
            return;
        }
        printTillN(n - 1);
        System.out.print(n + " ");
    }

    //    Fibonacci Number leetcode
    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    //    Special Fibonacci CodeChef
    public static int fibonacci(int a, int b, int n) {
        if (n == 0) return a;
        if (n == 1) return b;
        return fibonacci(a, b, n - 1) ^ fibonacci(a, b, n - 2);
    }

    //    Length of string using Recursion GFG
    static int stringLength(String s) {
        if (s.equals("")) return 0;
        return stringLength(s.substring(1)) + 1;
    }

    //    Geek-onacci Number GFG
    static int geekonacci(int a, int b, int c, int n) {
        if (n == 1) return a;
        if (n == 2) return b;
        if (n == 3) return c;
        return geekonacci(a, b, c, n - 1) + geekonacci(a, b, c, n - 2) + geekonacci(a, b, c, n - 3);
    }

    //    Recursive Bubble Sort GFG
    static void bubbleSort(int[] arr, int r, int c) {
        if (r < 0) {
            return;
        }
        if (c < r) {
            if (arr[c] > arr[c + 1])
                swap(arr, c, c + 1);
            bubbleSort(arr, r, c + 1);
        } else {
            bubbleSort(arr, r - 1, 0);
        }
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    //    Recursive Insertion Sort GFG
    static void insertionSort(int[] arr, int r, int c) {
        if (r > arr.length - 2) {
            return;
        }
        if (c > 0 && arr[c] < arr[c - 1]) {
            swap(arr, c, c - 1);
            insertionSort(arr, r, c - 1);
        } else {
            insertionSort(arr, r + 1, r + 2);
        }
    }

    //    Sum of digit of a number using Recursion GFG
    static int digitSum(int num) {
        if (num <= 9) {
            return num;
        }
        return num % 10 + digitSum(num / 10);
    }

    //    Product of two numbers using Recursion GFG
    static int product(int x, int y) {
        if (x < y) {
            return product(y, x);
        } else if (y != 0) {
            return x + product(x, y - 1);
        } else {
            return 0;
        }
    }

    //    Check Prime or not GFG
    static boolean isPrime(int n, int i) {
        if (n <= 2) return n == 2;
        if (n % i == 0) return false;
        if (i * i > n) return true;
        return isPrime(n, i + 1);
    }

    //    Sum of Natural numbers using Recursion GFG
    static int sumTillN(int n) {
        if (n <= 1) {
            return n == 1 ? 1 : 0;
        }
        return n + sumTillN(n - 1);
    }

    //    Power of Two leetcode
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        if (n == 1) return true; // since 1 = 2 pow 0
        if (n % 2 == 0) return isPowerOfTwo(n / 2);
        else return false;
    }

    //    Power of Three leetcode
    public boolean isPowerOfThree(int n) {
        if (n == 0) return false;
        if (n == 1) return true; // since 1 = 2 pow 0
        if (n % 3 == 0) return isPowerOfThree(n / 3);
        else return false;
    }

    //    Power of Four leetcode
    public boolean isPowerOfFour(int n) {
        if (n == 0) return false;
        if (n == 1) return true; // since 1 = 2 pow 0
        if (n % 4 == 0) return isPowerOfFour(n / 4);
        else return false;
    }
//    Write a recursive function for given n and a to determine x:
//    n = a ^ x
//            a = 2, 3, 4
//            (2 ^ -31) <= n <= (2 ^ 31) - 1


    //    Write a recursive function that returns the factorial of a number. HackerRank
    public static int factorial(int n) {
        // Write your code here
        if (n == 0) return 1;
        if (n == 1) return 1;
        return n * factorial(n - 1);
    }

    //    Write a recursive function to check whether an array is sorted or not. GFG
    static boolean isSorted(int[] arr, int i) {
        if (i == arr.length - 1) return true;
        if (arr[i] > arr[i + 1]) return false;
        return isSorted(arr, i + 1);
    }

    //    Number of Steps to Reduce a Number to Zero. leetcode
    public int numberOfSteps(int num) {
        return helper(num, 0);
    }

    public int helper(int num, int i) {
        if (num == 0) return i;
        if (num % 2 == 0) return helper(num / 2, i + 1);
        else return helper(num - 1, i + 1);
    }
//    Check for balanced paranthesis using recursion without stack. GFG

//    Remove consecutive duplicate characters from a string. GFG

//    Print all possible palindromic partitions of a string. GFG

//    Power Set of permutations of a string in Lexicographic order. GFG

}
