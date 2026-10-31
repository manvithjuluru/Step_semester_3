package class_problems;

public class Problem7 {

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    // Time: O(n), Space: O(1)
    static int countNodes(Node head) {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(15);

        System.out.println(countNodes(head)); // 3
        System.out.println(countNodes(null)); // 0
    }
}