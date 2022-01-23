public class LinkedListEasy {
    private static class ListNode{
        int val;
        ListNode next;

        public ListNode(){}

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int val) {
            this.val = val;
        }
    }
    //    Convert Binary Number in a Linked List to Integer leetcode
    public static int getDecimalValue(ListNode head) {
        int size = findSize(head);
        ListNode temp = head;
        int decimalValue = 0;
        while(size!=0){
            decimalValue += temp.val*Math.pow(2,size-1);
            temp = temp.next;
            size--;
        }
        return decimalValue;

    }
    static int findSize(ListNode head){
        int count = 0;
        ListNode temp = head;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }

//    Reverse Linked List leetcode

    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;
        while(present!=null){
            present.next = prev;
            prev = present;
            present = next;
            if(next!=null) {
                next = next.next;
            }
        }
        return prev;
    }

//    Middle of the Linked List leetcode
//    Merge Two Sorted Lists leetcode
//    Delete Node in a Linked List leetcode
//    Palindrome Linked List leetcode Snapdeal
//    Intersection of Two Linked Lists leetcode
//    Linked List Cycle leetcode Samsung
//    Remove Duplicates from Sorted Listleetcode
//    Find All Numbers Disappeared in an Array leetcode
//    Remove Linked List Elements leetcode
}
