public class LinkedListEasy {
    private static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

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
        while (size != 0) {
            decimalValue += temp.val * Math.pow(2, size - 1);
            temp = temp.next;
            size--;
        }
        return decimalValue;

    }

    static int findSize(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

//    Reverse Linked List leetcode

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;
        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }

    //    Middle of the Linked List leetcode
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //    Merge Two Sorted Lists leetcode
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode();
        ListNode temp = ans;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
                temp = temp.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;
            }
        }
        temp.next = list1 != null ? list1 : list2;
        return ans.next;
    }

    //    Delete Node in a Linked List leetcode
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
//    Palindrome Linked List leetcode Snapdeal
//    Intersection of Two Linked Lists leetcode
//    Linked List Cycle leetcode Samsung
//    Remove Duplicates from Sorted Listleetcode
//    Find All Numbers Disappeared in an Array leetcode
//    Remove Linked List Elements leetcode
}
