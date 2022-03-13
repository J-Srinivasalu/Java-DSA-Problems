import java.util.ArrayList;
import java.util.List;

public class LinkedListEasy {
    private static ListNode head = null;
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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode mid = middleNodePalindrome(head);
        mid = reverseList(mid);
        while (mid != null && head != null) {
            if (mid.val == head.val) {
                mid = mid.next;
                head = head.next;
            } else return false;
        }
        return true;
    }

    public ListNode middleNodePalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        return slow;
    }

    //    Intersection of Two Linked Lists leetcode
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;
        ListNode list1 = headA;
        ListNode list2 = headB;

        while (list1 != list2) {
            list1 = list1 == null ? headB : list1.next;
            list2 = list2 == null ? headA : list2.next;
        }
        return list1;
    }

    //    Linked List Cycle leetcode Samsung
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head.next;
        if (slow == null) return false;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            if (fast == slow) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    //    Remove Duplicates from Sorted Listleetcode
    public ListNode deleteDuplicates(ListNode head) {
        ListNode first = head;
        if (first == null || head.next == null) return head;
        ListNode second = head.next;
        while (second != null) {
            if (first.val == second.val) {
                first.next = second.next;
                second = second.next;
            } else {
                first = first.next;
                second = second.next;
            }
        }
        return head;
    }

    //    Find All Numbers Disappeared in an Array leetcode
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        cyclicSort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    public void cyclicSort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }
    }

    public void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    //    Remove Linked List Elements leetcode
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp = head;

        while (temp != null) {
            if (head != null && head.val == val) {
                head = head.next;
                continue;
            }
            if (temp.next != null) {
                if (temp.next.val == val) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            } else {
                break;
            }
        }
        return head;
    }
}
