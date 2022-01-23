import java.util.Arrays;

public class RecursionEasy {
    public static void main(String[] args) {
        System.out.println(geekonacci(1, 3, 2, 4));
        System.out.println(geekonacci(1, 3, 2, 5));
        System.out.println(geekonacci(1, 3, 2, 6));
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
    static int stringLength(String s){
        if(s.equals("")) return 0;
        return stringLength(s.substring(1))+1;
    }
//    Geek-onacci Number GFG
    static int geekonacci(int a, int b, int c, int n){
        if(n==1) return a;
        if(n==2) return b;
        if(n==3) return c;
        return geekonacci(a,b,c,n-1)+geekonacci(a,b,c,n-2)+geekonacci(a,b,c,n-3);
    }
//    Recursive Bubble Sort GFG
//    Recursive Insertion Sort GFG
//    Sum of digit of a number using Recursion GFG
//    Product of two numbers using Recursion GFG
//    Check Prime or not GFG
//    Sum of Natural numbers using Recursion GFG
//    Power of Two leetcode
//    Power of Three leetcode
//    Power of Four leetcode
//    Write a recursive function for given n and a to determine x:
//    n = a ^ x
//            a = 2, 3, 4
//            (2 ^ -31) <= n <= (2 ^ 31) - 1
//    Write a recursive function that returns the factorial of a number. HackerRank
//    Write a recursive function to check whether an array is sorted or not. GFG
//    Number of Steps to Reduce a Number to Zero. leetcode
//    Check for balanced paranthesis using recursion without stack. GFG
//    Remove consecutive duplicate characters from a string. GFG
//    Print all possible palindromic partitions of a string. GFG
//    Power Set of permutations of a string in Lexicographic order. GFG
}
