package linkedtable;

public class ReverseLinkedTable {

    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.nextNode;
            head.nextNode = pre;
            head.lastNode = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
