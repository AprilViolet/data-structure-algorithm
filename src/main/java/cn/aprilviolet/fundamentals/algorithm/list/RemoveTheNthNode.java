package cn.aprilviolet.fundamentals.algorithm.list;

/**
 * 19. 删除链表的倒数第 N 个结点
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2021.01.28 星期四 22:49
 * @since V1.0.0
 */
public class RemoveTheNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        while (n-- > 0) {
            fast = fast.next;
        }
        // 如果此时快指针已经走到尽头，则需要移除的就是第一个节点
        if (fast == null) {
            return head.next;
        }

        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
