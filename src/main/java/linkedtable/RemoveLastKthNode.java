package linkedtable;

public class RemoveLastKthNode {

    /**
     * 单向链表删除倒数第k个元素
     *
     * @param head
     * @param lastKth
     * @return
     */
    public static Node removeLastKthNode(Node head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }
        Node cur = head;
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0) {
            head = head.next;
        }
        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }


    /**
     * 双向链表删除倒数第k个元素
     *
     * @param head
     * @param lastKth
     * @return
     */
    public static DoubleNode removeLastKthNode(DoubleNode head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }
        DoubleNode cur = head;
        while (cur != null) {
            lastKth--;
            cur = cur.nextNode;
        }
        if (lastKth == 0) {
            head = head.nextNode;
            head.lastNode = null;
        }
        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.nextNode;
            }
            DoubleNode newNext = cur.nextNode.nextNode;
            cur.nextNode = newNext;
            if (newNext != null) {
                newNext.lastNode = cur;
            }

        }
        return head;


    }
}
