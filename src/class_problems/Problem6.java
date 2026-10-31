package class_problems;

public class Problem6 {

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    // Time: O(k), Space: O(1)
    static Node reverseFirstKNodes(Node head, int k) {
        Node prev = null, current = head, next = null;
        for (int i = 0; i < k && current != null; i++) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        // head is now the k-th node; connect it to the (k+1)-th node
        head.next = current;
        return prev;
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

    static void print(Node head) {
        StringBuilder sb = new StringBuilder();
        for (Node cur = head; cur != null; cur = cur.next) {
            sb.append(cur.data);
            if (cur.next != null) sb.append(" -> ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        print(reverseFirstKNodes(build(1, 2, 3, 4, 5), 3)); // 3 -> 2 -> 1 -> 4 -> 5
        print(reverseFirstKNodes(build(1, 2, 3, 4, 5), 5)); // 5 -> 4 -> 3 -> 2 -> 1
    }
}