package cn.aprilviolet.fundamentals.algorithm.list;

/**
 * 876. 链表的中间结点
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2021.01.28 星期四 22:48
 * @since V1.0.0
 */
public class LinkedListMiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
