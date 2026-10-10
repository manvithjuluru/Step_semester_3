package assigment_problems;
public class Assignment1 {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }
    static Node head;
    static void addFirst(int token) {
        Node n = new Node(token);
        n.next = head;
        head = n;
    }
    static void addLast(int token) {
        Node n = new Node(token);
        if (head == null) { head = n; return; }
        Node cur = head;
        while (cur.next != null) cur = cur.next;
        cur.next = n;
    }
    static void insertAt(int index, int token) {
        if (index == 0) { addFirst(token); return; }
        Node prev = head;
        for (int i = 0; i < index - 1; i++) prev = prev.next;
        Node n = new Node(token);
        n.next = prev.next;
        prev.next = n;
    }
    static void print() {
        StringBuilder sb = new StringBuilder();
        for (Node cur = head; cur != null; cur = cur.next) sb.append(cur.data).append(" -> ");
        System.out.println(sb + "null");
    }
    public static void main(String[] args) {
        addLast(101);
        addLast(102);
        addLast(103);

        addFirst(100);
        addLast(104);
        insertAt(2, 150);
        print();
    }
}