package assigment_problems;
public class Assignment5 {
    static class Player {
        String name;
        Player next;
        Player(String name) { this.name = name; }
    }
    static Player last; // last.next is the first player
    static void addPlayer(String name) {
        Player p = new Player(name);
        if (last == null) {
            last = p;
            p.next = p;
        } else {
            p.next = last.next;
            last.next = p;
            last = p;
        }
    }
    static void removePlayer(String name) {
        if (last == null) return;
        Player prev = last, cur = last.next;
        do {
            if (cur.name.equals(name)) {
                if (cur == prev) { last = null; return; } // only one player left
                prev.next = cur.next;
                if (cur == last) last = prev;
                return;
            }
            prev = cur;
            cur = cur.next;
        } while (prev != last);
    }
    public static void main(String[] args) {
        addPlayer("Asha");
        addPlayer("Ravi");
        addPlayer("Neha");
        Player turn = last.next;
        for (int i = 1; i <= 5; i++) {
            System.out.println("Turn " + i + ": " + turn.name);
            turn = turn.next;
        }
        removePlayer("Ravi");
        System.out.println("Ravi left the game");
        turn = last.next;
        for (int i = 6; i <= 8; i++) {
            System.out.println("Turn " + i + ": " + turn.name);
            turn = turn.next;
        }
    }
}