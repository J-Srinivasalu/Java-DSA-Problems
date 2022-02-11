import java.util.Stack;

public class StackQueueEasy {
    //    Next greater element I leetcode
    public static void main(String[] args) {
    }

    public int[] nextGreaterElementBruteForce(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int index = -1;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    index = j;
                }
                if (index != -1) {
                    index++;
                    if (index == nums2.length) {
                        ans[i] = -1;
                        break;
                    }
                    if (nums2[index] > nums1[i]) {
                        ans[i] = nums2[index];
                        break;
                    }
                }
            }
        }
        return ans;
    }

    //    Valid Parentheses leetcode
    public boolean isValid(String s) {
        Stack<Character> parenthesis = new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='('||ch=='{'||ch=='['){
                parenthesis.push(ch);
            }
            else{
                if(parenthesis.isEmpty()){
                    return false;
                }
                if(ch==')'){
                    if(parenthesis.pop() != '('){
                        return false;
                    }
                }
                if(ch==']'){
                    if(parenthesis.pop() != '['){
                        return false;
                    }
                }
                if(ch=='}'){
                    if(parenthesis.pop() != '{'){
                        return false;
                    }
                }
            }
        }
        return parenthesis.isEmpty();
    }
//    Min Stack leetcode
static class MinStack {
    static class Node{
        int val;
        Node prev;
        int min;
        private Node(int val, int min, Node prev){
            this.val = val;
            this.min = min;
            this. prev = prev;
        }

    }

    private Node tail;

    public MinStack() {
        tail = null;
    }

    public void push(int val) {
        if(tail == null){
            tail = new Node(val, val, null);
        }
        else{
            tail = new Node(val, Math.min(val, tail.min), tail);
        }
    }

    public void pop() {
        tail = tail.prev;

    }

    public int top() {
        return tail.val;
    }

    public int getMin() {
        return tail.min;
    }
}
//    Remove Outermost Parentheses leetcode
//    Remove All Adjacent Duplicates In String leetcode
//    Number of Recent Calls leetcode
//    Reverse First K elements of Queue GFG
//    Delete middle element of a stack GFG
//    Inorder Traversal (Iterative) GFG
//    Preorder traversal (Iterative) GFG
//    Flood fill leetcode
//    Implement Queue using Stacks leetcode
}
