package assigment_problems;
public class Assignment3 {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }
    static Node reverse(Node head) {
        Node prev = null, current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
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
        for (Node cur = head; cur != null; cur = cur.next) sb.append(cur.data).append(" -> ");
        System.out.println(sb + "null");
    }
    public static void main(String[] args) {
        print(reverse(build(1, 2, 3, 4)));
        print(reverse(build(9)));
    }
}