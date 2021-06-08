package cn.aprilviolet.fundamentals.algorithm.list;

/**
 * 142. 环形链表 II
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2021.01.28 星期四 22:45
 * @since V1.0.0
 */
public class CircularLinkedListTwo {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        // 快慢指针第一次相遇
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        // 可能是没有环的情况
        if (fast == null || fast.next == null) {
            return null;
        }

        fast = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
