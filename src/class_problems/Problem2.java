package class_problems;
public class Problem2 {
    static class DNode {
        int data;
        DNode prev, next;
        DNode(int data) { this.data = data; }
    }
    static DNode insertAtTailDoubly(DNode head, int value) {
        DNode newNode = new DNode(value);
        if (head == null) return newNode;
        DNode tail = head;
        while (tail.next != null) tail = tail.next;
        tail.next = newNode;
        newNode.prev = tail;
        return head;
    }
    static DNode build(int... values) {
        DNode head = null;
        for (int v : values) head = insertAtTailDoubly(head, v);
        return head;
    }
    static void print(DNode head) {
        StringBuilder sb = new StringBuilder();
        for (DNode cur = head; cur != null; cur = cur.next) {
            sb.append(cur.data);
            if (cur.next != null) sb.append(" <-> ");
        }
        System.out.println(sb);
    }
    public static void main(String[] args) {
        print(insertAtTailDoubly(build(1, 2, 3), 4)); // 1 <-> 2 <-> 3 <-> 4
        print(insertAtTailDoubly(null, 7));           // 7
    }
}