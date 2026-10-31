package class_problems;

public class Problem4 {

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    // Time: O(n), Space: O(1)
    static Node deleteNthNode(Node head, int n) {
        if (n == 1) return head.next;

        Node current = head;
        for (int i = 0; i < n - 2; i++) current = current.next;
        current.next = current.next.next;
        return head;
    }

    static Node build(int... values) {
        Node head = null, tail = null;
        for (int v : values) {
            Node node = new Node(v);
            if (head == null) head = tail = node;
            else { tail.next = node; tail = node; }
        }
        return head;
    }

    static void print(Node head) {
        StringBuilder sb = new StringBuilder();
        for (Node cur = head; cur != null; cur = cur.next) {
            sb.append(cur.data);
            if (cur.next != null) sb.append(" -> ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        print(deleteNthNode(build(10, 20, 30, 40), 3)); // 10 -> 20 -> 40
        print(deleteNthNode(build(10, 20, 30, 40), 1)); // 20 -> 30 -> 40
    }
}