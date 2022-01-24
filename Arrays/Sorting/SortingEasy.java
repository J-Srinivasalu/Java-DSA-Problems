import java.util.ArrayList;
import java.util.List;

public class SortingEasy {

//    Merge Sorted Array
//    Majority Element
//    Contains Duplicate
//    Missing Number
public int missingNumber(int[] nums) {
    int n = nums.length;
    cyclicSortZeroValued(nums);
    for(int i=0;i<n;i++){
        if(nums[i]!=i) return i;
    }
    return n;
}
    void cyclicSortZeroValued(int[] arr){
        int i = 0;
        while(i<arr.length){
            int correct = arr[i];
            if(arr[i]<arr.length && arr[i] != arr[correct]){
                swap(arr,i, correct);
            }
            else{
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
//    Intersection of Two Arrays II
//    Third Maximum Number
//    Assign Cookies
//    Array Partition I
//    Maximum Product of Three Numbers
//    Sort Array By Parity
//    Sort Array By Parity II
//    Largest Perimeter Triangle
//    Squares of a Sorted Array
//    Matrix Cells in Distance Order
//    Height Checker
//    Relative Sort Array
//    Minimum Absolute Difference
//    Rank Transform of an Array
//    Sort Integers by The Number of 1 Bits
//    How Many Numbers Are Smaller Than the Current Number
//    Maximum Product of Two Elements in an Array
//    Average Salary Excluding the Minimum and Maximum Salary
//    Make Two Arrays Equal by Reversing Sub-arrays
//    Can Make Arithmetic Progression From Sequence
//    Sort Array by Increasing Frequency
//    Special Array With X Elements Greater Than or Equal X
//    Find all numbers disappeared in an array
//    Set Mismatch
//    2Sum

    public List<Integer> missingNumbers(int[] arr){
        List<Integer> ans = new ArrayList<>();
        cyclicSortOneValued(arr);
        for(int i=0;i<arr.length;i++){
            if(arr[i] != i-1){
                ans.add(arr[i]);
            }
        }
        return ans;
    }
    public void cyclicSortOneValued(int[] arr){
        int i = 0;
        while(i<arr.length){
            int correct = arr[i]-1;
            if(arr[i]<arr.length && arr[i] != arr[correct]){
                swap(arr,i, correct);
            }
            else{
                i++;
            }
        }
    }

}
