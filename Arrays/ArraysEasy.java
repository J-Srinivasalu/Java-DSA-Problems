import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysEasy {

    //    Build Array from Permutation
    public static int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }

    //    Concatenation of Array
    public static int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            ans[i] = nums[i % n];
        }
        return ans;
    }

    //    Running Sum of 1d Array
    public static int[] runningSum(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            nums[i + 1] += nums[i];
        }
        return nums;
    }

    //    Richest Customer Wealth
    public static int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    //    Shuffle the Array
    public static int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        int j = 0;
        int k = n;
        for (int i = 0; i < 2 * n; i++) {
            if (i % 2 != 0) {
                ans[i] = nums[k];
                k++;
            } else {
                ans[i] = nums[j];
                j++;
            }
        }
        return ans;
    }

    //    Kids With the Greatest Number of Candies
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<Boolean>();
        int max = candies[0];
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;

    }

    //    Number of Good Pairs
    public int numIdenticalPairs(int[] nums) {
        int ans = 0;
        int[] count = new int[101];

        for (int n : nums)
            count[n]++;

        for (int n : count)
            ans += (n * (n - 1)) / 2;

        return ans;
    }

    //    How Many Numbers Are Smaller Than the Current Number
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[i])
                    count++;
            }
            ans[i] = count;
        }

        return ans;
    }

    //    Create Target Array in the Given Order
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] ans = new int[index.length];
        for (int i = 0; i < index.length; i++) {
            for (int j = i; j >= index[i]; j--) {
                if (index[i] < j) ans[j] = ans[j - 1];
                else {
                    ans[j] = nums[i];
                }
            }
        }
        return ans;
    }

    //    Check if the Sentence Is Pangram
    public boolean checkIfPangram(String sentence) {
        int[] charCount = new int[26];
        for (int i = 0; i < sentence.length(); i++) {
            int n = sentence.charAt(i) - 'a';
            charCount[n]++;
        }
        for (int i = 0; i < 26; i++) {
            if (charCount[i] == 0) {
                return false;
            }
        }
        return true;
    }

    //    Count Items Matching a Rule
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        for (List<String> item : items) {
            switch (ruleKey) {
                case "type":
                    if (item.get(0).equals(ruleValue)) {
                        count++;
                    }
                    break;
                case "color":
                    if (item.get(1).equals(ruleValue)) {
                        count++;
                    }
                    break;
                case "name":
                    if (item.get(2).equals(ruleValue)) {
                        count++;
                    }
                    break;
                default:
                    System.out.println("wrong input");
                    break;
            }
        }
        return count;
    }

    //    Find the Highest Altitude
    public int largestAltitude(int[] gain) {
        int max = 0;
        int contSum = 0;
        for (int i = 0; i < gain.length; i++) {

            contSum += gain[i];
            if (contSum > max) {
                max = contSum;
            }
        }
        return max;
    }

    //    Flipping an Image
    public int[][] flipAndInvertImage(int[][] image) {
        int[][] ans = new int[image.length][image[0].length];
        for (int i = 0; i < image.length; i++) {
            int k = 0;
            for (int j = image[i].length - 1; j >= 0; j--) {
                if (image[i][j] == 0) {
                    ans[i][k] = 1;
                } else {
                    ans[i][k] = 0;
                }
                k++;
            }
        }
        return ans;
    }

    //    Cells with Odd Values in a Matrix
    public int oddCells(int m, int n, int[][] indices) {
        int[][] ans = new int[m][n];
        for (int i = 0; i < indices.length; i++) {
            for (int j = 0; j < ans[indices[i][0]].length; j++) {
                ans[indices[i][0]][j]++;
            }
            for (int k = 0; k < ans.length; k++) {
                ans[k][indices[i][1]]++;
            }
        }
        int count = 0;
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                if (ans[i][j] % 2 != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    //    Matrix Diagonal Sum
    public int diagonalSum(int[][] mat) {
        int s = 0;
        int e = mat.length - 1;
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            if (s == e) {
                sum += mat[i][s];
                s++;
                e--;
            } else {
                sum += mat[i][s] + mat[i][e];
                s++;
                e--;
            }

        }
        return sum;
    }

    //    Find Numbers with Even Number of Digits
    public int findNumbers(int[] nums) {
        int counter = 0;
        for (int i : nums) {
            if (Integer.toString(i).length() % 2 == 0) {
                counter++;
            }
        }
        return counter;
    }

    //    Transpose Matrix
    public int[][] transpose(int[][] matrix) {
        int[][] ans = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }

    //    Add to Array-Form of Integer
    public List<Integer> addToArrayForm(int[] A, int K) {
        int carry = 0;
        int index = A.length - 1;
        while (K > 0 && index >= 0) {
            carry += K % 10 + A[index];
            A[index] = carry % 10;
            carry = carry / 10;
            K = K / 10;
            index--;
        }
        List<Integer> res = new ArrayList<Integer>();
        if (K > 0) {
            while (K > 0) {
                carry += K % 10;
                res.add(0, carry % 10);
                carry /= 10;
                K = K / 10;
            }
        } else if (index >= 0) {
            while (index >= 0) {
                carry += A[index];
                A[index] = carry % 10;
                carry = carry / 10;
                index--;
            }
        }
        if (carry > 0) {
            res.add(0, carry);
        }
        for (int i = 0; i < A.length; i++) {
            res.add(A[i]);
        }
        return res;
    }

    //    Maximum Population Year
    public int maximumPopulation(int[][] logs) {
        int[] years = new int[2051];


        for (int i = 0; i < logs.length; i++) {
            years[logs[i][0]]++;
            years[logs[i][1]]--;
        }
        int maxNum = years[1950], maxYear = 1950;

        for (int i = 1951; i < years.length; i++) {
            years[i] += years[i - 1];

            if (years[i] > maxNum) {
                maxNum = years[i];
                maxYear = i;
            }
        }

        return maxYear;


    }

    //    Determine Whether Matrix Can Be Obtained By Rotation
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;

        int[][] r1 = new int[target.length][target.length];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                r1[i][j] = mat[n - j - 1][i];
            }
        }
        int[][] r2 = new int[target.length][target.length];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                r2[i][j] = r1[n - j - 1][i];
            }
        }
        int[][] r3 = new int[target.length][target.length];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                r3[i][j] = r2[n - j - 1][i];
            }
        }
        if (Arrays.deepEquals(r1, target) || Arrays.deepEquals(r2, target) || Arrays.deepEquals(r3, target) || Arrays.deepEquals(mat, target)) {
            return true;
        }
        return false;
    }

    //    Two Sum
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] + nums[i] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }
            }
        }
        return ans;
    }

    //    Find N Unique Integers Sum up to Zero
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int t = n / 2;

        for (int i = 0; i < n; i++) {
            ans[i] = t--;
            if (t == 0 && n % 2 == 0) {
                t--;
            }
        }
        return ans;
    }

    //    Lucky Number In a Matrix
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            int min = matrix[i][0];
            int index = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (min > matrix[i][j]) {
                    min = matrix[i][j];
                    index = j;
                }
            }
            int max = min;
            int k = 0;
            while (k != matrix.length) {
                if (matrix[k][index] > max) {
                    break;
                }
                k++;
            }
            if (k == matrix.length) {
                ans.add(matrix[i][index]);
            }
        }
        return ans;
    }

    //    Maximum Subarray
    public int maxSubArray(int[] nums) {

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    //    Reshape the Matrix
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        if (r * c != m * n)
            return nums;
        int[][] reshaped = new int[r][c];
        for (int i = 0; i < r * c; i++)
            reshaped[i / c][i % c] = nums[i / n][i % n];
        return reshaped;
    }

    //    Plus One
    public int[] plusOne(int[] digits) {
        boolean check = false;
        int n = digits.length - 1;
        for (int i = n; i >= 0; i--) {
            int temp = digits[i] + 1;
            if (temp >= 10) {
                check = true;
                digits[i] = temp % 10;
            } else {
                check = false;
                digits[i] = temp;
                break;
            }
        }
        if (check) {
            int[] c = new int[digits.length + 1];

            System.arraycopy(new int[]{1}, 0, c, 0, 1);
            System.arraycopy(digits, 0, c, 1, digits.length);
            return c;
        }
        return digits;
    }

    //    Remove Duplicates from Sorted Array
    public int removeDuplicates(int[] nums) {
        int pos = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[pos] != nums[i] && ++pos != i) {
                nums[pos] = nums[i];
            }
        }

        int i = 1;
        for (i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]) {
                break;
            }
        }
        return i;
    }

    //    Minimum Cost to Move Chips to The Same Position
    public int minCostToMoveChips(int[] position) {
        if (position.length == 1) return 0;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < position.length; i++) {
            int iPosCost = 0;
            for (int j = 0; j < position.length; j++) {
                iPosCost += Math.abs(i - (position[j] - 1)) % 2;
            }
            minValue = Math.min(iPosCost, minValue);
        }
        return minValue;
    }
}
