package class_problems;

public class Problem5 {

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    // Time: O(n), Space: O(1)
    // Odd length: first half gets the extra middle node.
    static Node splitListInHalf(Node head) {
        if (head == null || head.next == null) return null;

        Node slow = head, fast = head;
        // fast.next.next stops slow at the END of the first half
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node second = slow.next;
        slow.next = null;
        return second;
    }

    static Node build(int... values) {
        Node head = null, tail = null;
        for (int v : values) {
            Node n = new Node(v);
            if (head == null) head = tail = n;
            else { tail.next = n; tail = n; }
        }
        return head;
    }

    static String str(Node head) {
        if (head == null) return "(empty)";
        StringBuilder sb = new StringBuilder();
        for (Node cur = head; cur != null; cur = cur.next) {
            sb.append(cur.data);
            if (cur.next != null) sb.append(" -> ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Node h1 = build(1, 2, 3, 4, 5);
        Node second1 = splitListInHalf(h1);
        System.out.println("First half: " + str(h1) + " Returned: " + str(second1));
        // First half: 1 -> 2 -> 3 Returned: 4 -> 5

        Node h2 = build(1, 2, 3, 4);
        Node second2 = splitListInHalf(h2);
        System.out.println("First half: " + str(h2) + " Returned: " + str(second2));
        // First half: 1 -> 2 Returned: 3 -> 4
    }
}