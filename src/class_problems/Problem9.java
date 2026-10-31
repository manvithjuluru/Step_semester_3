package class_problems;

public class Problem9 {

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    // Time: O(n), Space: O(1)
    static Node insertAtEndCircular(Node head, int value) {
        Node newNode = new Node(value);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        Node last = head;
        while (last.next != head) last = last.next;

        last.next = newNode;
        newNode.next = head;
        return head;
    }

    static void print(Node head) {
        if (head == null) {
            System.out.println("(empty)");
            return;
        }
        StringBuilder sb = new StringBuilder();
        Node cur = head;
        do {
            sb.append(cur.data).append(" -> ");
            cur = cur.next;
        } while (cur != head);
        System.out.println(sb + "(back to " + head.data + ")");
    }

    public static void main(String[] args) {
        Node head = null;
        for (int v : new int[]{1, 2, 3}) head = insertAtEndCircular(head, v);

        print(insertAtEndCircular(head, 4));    // 1 -> 2 -> 3 -> 4 -> (back to 1)
        print(insertAtEndCircular(null, 9));    // 9 -> (back to 9)
    }
}