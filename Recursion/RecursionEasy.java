import java.util.*;

public class RecursionEasy {
    public static void main(String[] args) {
        System.out.println(powerSetLex("abc"));
    }

    static void backtracking(int[] arr, int n) {
        if (arr[n] == 3) {
            return;
        }
        if (n == 0) {
            return;
        }
        int x = arr[n];
        arr[n] = 0;
        System.out.println(Arrays.toString(arr));
        backtracking(arr, n - 1);
        arr[n] = x;
        backtracking(arr, n - 1);
        arr[n] = x;
        System.out.println(Arrays.toString(arr));
    }

    static void maze(int r, int c, String ans) {
        if (r == 1 && c == 1) {
            System.out.println(ans);
            return;
        }
        if (r > 1) {
            maze(r - 1, c, ans + "R");
        }
        if (c > 1) {
            maze(r, c - 1, ans + "D");
        }
    }

    static void mazeWithObstacles(int[][] arr, int r, int c, String ans) {
        if (arr[r][c] == 1) {
            return;
        }
        if (r == 0 && c == 0) {
            System.out.println(ans);
            return;
        }
        if (r > 0) {
            mazeWithObstacles(arr, r - 1, c, ans + "R");
        }
        if (c > 0) {
            mazeWithObstacles(arr, r, c - 1, ans + "D");
        }
    }

    static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    /**
     * dice sum
     **/
    static ArrayList<Integer> diceSum(ArrayList<Integer> p, int up) {
        if (up == 0) {
            return new ArrayList<>(p);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            if (up - i < 0) {
                break;
            }
            p.add(i);
            list.addAll(diceSum(p, up - i));
            p.clear();
        }
        return list;
    }

    static List<String> letterCombinations(String up) {
        return letterCombination("", up);
    }

    //letter combination
    static final HashMap<Character, String> digitLetterMap = new HashMap<>(Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz"
    ));

    static List<String> letterCombination(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        char number = up.charAt(0);
        String letters = digitLetterMap.get(number);
        for (int i = 0; i < letters.length(); i++) {
            ans.addAll(letterCombination(p + letters.charAt(i), up.substring(1)));
        }
        return ans;
    }

    //subsets of a given string
    static void powerSetString(String p, String up) {
        if (p.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        powerSetString(p, up.substring(1));
        powerSetString(p + ch, up.substring(1));
    }

    //permutations of a string
    static void permutation(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i);
            permutation(f + ch + s, up.substring(1));
        }
    }

    static int permutationCount(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }
        int ans = 0;
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i);
            ans += permutationCount(f + ch + s, up.substring(1));
        }
        return ans;
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

    //    Check for balanced parenthesis using recursion without stack. GFG

    static boolean ispar(String x) {
        // add your code here
        return check(x.toCharArray(), x.length());
    }

    // copied
    static char findClosing(char c) {
        if (c == '(')
            return ')';
        if (c == '{')
            return '}';
        if (c == '[')
            return ']';
        return Character.MIN_VALUE;
    }

    // function to check if parenthesis are
    // balanced.
    static boolean check(char expr[], int n) {
        // Base cases
        if (n == 0)
            return true;
        if (n == 1)
            return false;
        if (expr[0] == ')' || expr[0] == '}' || expr[0] == ']')
            return false;

        // Search for closing bracket for first
        // opening bracket.
        char closing = findClosing(expr[0]);

        // count is used to handle cases like
        // "((()))". We basically need to
        // consider matching closing bracket.
        int i, count = 0;
        for (i = 1; i < n; i++) {
            if (expr[i] == expr[0])
                count++;
            if (expr[i] == closing) {
                if (count == 0)
                    break;
                count--;
            }
        }

        // If we did not find a closing
        // bracket
        if (i == n)
            return false;

        // If closing bracket was next
        // to open
        if (i == 1)
            return check(Arrays.copyOfRange(expr, i + 1, n), n - 2);
        // If closing bracket was somewhere
        // in middle.
        return check(Arrays.copyOfRange(expr, 1, n), i - 1) && check(Arrays.copyOfRange(expr, (i + 1), n), n - i - 1);
    }
//    Remove consecutive duplicate characters from a string. GFG

    static String removeConsecutiveDuplicates(String p, String up) {
        if (up.isEmpty()) {
            return p;
        }
        char ch = up.charAt(0);
        if (!p.isEmpty()) {
            if (ch == p.charAt(p.length() - 1)) {
                return removeConsecutiveDuplicates(p, up.substring(1));
            }
        }
        return removeConsecutiveDuplicates(p + ch, up.substring(1));
    }

    //    Print all possible palindromic partitions of a string. GFG
    // copied
    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        // code here
        int n = S.length();

        // To Store all palindromic partitions
        ArrayList<ArrayList<String>> allPart = new ArrayList<>();

        // To store current palindromic partition
        Deque<String> currPart = new LinkedList<String>();

        // Call recursive function to generate
        // all partitions and store in allPart
        allPalPartitonsUtil(allPart, currPart, 0, n, S);
        return allPart;
    }


    // Recursive function to find all palindromic
    // partitions of input[start..n-1] allPart --> A
    // ArrayList of Deque of strings. Every Deque
    // inside it stores a partition currPart --> A
    // Deque of strings to store current partition
    private static void allPalPartitonsUtil(ArrayList<ArrayList<String>> allPart,
                                            Deque<String> currPart, int start, int n, String input) {
        // If 'start' has reached len
        if (start >= n) {
            allPart.add(new ArrayList<>(currPart));
            return;
        }

        // Pick all possible ending points for substrings
        for (int i = start; i < n; i++) {

            // If substring str[start..i] is palindrome
            if (isPalindrome(input, start, i)) {

                // Add the substring to result
                currPart.addLast(input.substring(start, i + 1));

                // Recur for remaining remaining substring
                allPalPartitonsUtil(allPart, currPart, i + 1, n, input);

                // Remove substring str[start..i] from current
                // partition
                currPart.removeLast();
            }
        }
    }

    // A utility function to check
    // if input is Palindrome
    private static boolean isPalindrome(String input,
                                        int start, int i) {
        while (start < i) {
            if (input.charAt(start++) != input.charAt(i--))
                return false;
        }
        return true;
    }

//    Power Set of permutations of a string in Lexicographic order. GFG

    static ArrayList<String> powerSetLex(String s){
        ArrayList<String> ans = new ArrayList<>(powerSet("", s));
        Collections.sort(ans);
        return ans;
    }
    static ArrayList<String> powerSet(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        char ch = up.charAt(0);
        ans.addAll(powerSet(p, up.substring(1)));
        ans.addAll(powerSet(p+ch, up.substring(1)));

        return ans;
    }
}
