package assigment_problems;
public class Assignment4 {
    static class Coach {
        String name;
        Coach prev, next;
        Coach(String name) { this.name = name; }
    }
    static Coach head, tail;
    static void addAtEnd(String name) {
        Coach c = new Coach(name);
        if (head == null) { head = tail = c; return; }
        tail.next = c;
        c.prev = tail;
        tail = c;
    }
    static void addAtFront(String name) {
        Coach c = new Coach(name);
        if (head == null) { head = tail = c; return; }
        c.next = head;
        head.prev = c;
        head = c;
    }
    static void remove(String name) {
        for (Coach cur = head; cur != null; cur = cur.next) {
            if (cur.name.equals(name)) {
                if (cur.prev != null) cur.prev.next = cur.next; else head = cur.next;
                if (cur.next != null) cur.next.prev = cur.prev; else tail = cur.prev;
                return;
            }
        }
    }
    static void printForward() {
        StringBuilder sb = new StringBuilder("Engine -> ");
        for (Coach c = head; c != null; c = c.next) sb.append(c.name).append(" -> ");
        System.out.println(sb + "End");
    }
    static void printBackward() {
        StringBuilder sb = new StringBuilder("End -> ");
        for (Coach c = tail; c != null; c = c.prev) sb.append(c.name).append(" -> ");
        System.out.println(sb + "Engine");
    }
    public static void main(String[] args) {
        addAtEnd("C1");
        addAtEnd("C2");
        addAtEnd("C3");
        addAtFront("C0");
        printForward();
        printBackward();
        remove("C2");
        printForward();
        printBackward();
    }
}