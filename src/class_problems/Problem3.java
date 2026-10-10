package class_problems;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
class ClubMember {
    String rollNumber;
    String name;
    ClubMember(String rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClubMember)) return false;
        return rollNumber.equals(((ClubMember) o).rollNumber);}
    @Override
    public int hashCode() {
        return Objects.hash(rollNumber);
    }
}
public class Problem3 {
    public static void main(String[] args) {
        String[] input = {
                "ADD 21CS01 Asha",
                "ADD 21CS01 Asha",
                "ADD 21CS02 Ravi",
                "CONTAINS 21CS02 Ravi",
                "CONTAINS 21CS03 Priya"
        };
        Set<ClubMember> members = new HashSet<>();
        boolean countPrinted = false;
        for (String line : input) {
            String[] p = line.split(" ");
            if (p[0].equals("ADD")) {
                System.out.println(members.add(new ClubMember(p[1], p[2])) ? "Added" : "duplicate rejected");
            } else if (p[0].equals("CONTAINS")) {
                if (!countPrinted) {
                    System.out.println("member count " + members.size());
                    countPrinted = true;
                }
                System.out.println("contains: " + members.contains(new ClubMember(p[1], p[2])));
            }
        }
    }
}