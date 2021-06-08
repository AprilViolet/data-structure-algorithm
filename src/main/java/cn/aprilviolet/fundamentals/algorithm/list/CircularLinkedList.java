package cn.aprilviolet.fundamentals.algorithm.list;

/**
 * 141. 环形链表
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2021.01.28 星期四 22:44
 * @since V1.0.0
 */
public class CircularLinkedList {
    /**
     * 快慢指针
     *
     * @param head 初始节点
     * @return 是否含有环
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
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
