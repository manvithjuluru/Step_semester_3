package class_problems;
abstract class Staff {
    String name;
    Staff(String name) { this.name = name; }
    abstract double calculatePay();
    abstract String getType();
}
class FullTime extends Staff {
    double salary;
    FullTime(String name, double salary) { super(name); this.salary = salary; }
    double calculatePay() { return salary; }
    String getType() { return "FullTime"; }
}
class PartTime extends Staff {
    double hours, rate;
    PartTime(String name, double hours, double rate) { super(name); this.hours = hours; this.rate = rate; }
    double calculatePay() { return hours * rate; }
    String getType() { return "PartTime"; }
}
class Intern extends Staff {
    double stipend;
    Intern(String name, double stipend) { super(name); this.stipend = stipend; }
    double calculatePay() { return stipend; }
    String getType() { return "Intern"; }
}
class Payslip {
    String name, type;
    long pay;
    Payslip(Staff s) {
        this.name = s.name;
        this.type = s.getType();
        this.pay = (long) s.calculatePay();
    }
    @Override
    public String toString() {
        return "Payslip[name=" + name + ", type=" + type + ", pay=" + pay + "]";
    }
}
public class Problem5 {
    public static void main(String[] args) {
        String[] input = {
                "FullTime Asha 50000",
                "PartTime Ravi 80 300",
                "Intern Neha 15000"
        };
        Payslip[] payslips = new Payslip[input.length];
        for (int i = 0; i < input.length; i++) {
            String[] p = input[i].split(" ");
            Staff s;
            switch (p[0]) {
                case "FullTime": s = new FullTime(p[1], Double.parseDouble(p[2])); break;
                case "PartTime": s = new PartTime(p[1], Double.parseDouble(p[2]), Double.parseDouble(p[3])); break;
                default:         s = new Intern(p[1], Double.parseDouble(p[2]));
            }
            payslips[i] = new Payslip(s);
        }
        long total = 0;
        Payslip top = payslips[0];
        for (Payslip ps : payslips) {
            System.out.println(ps);
            total += ps.pay;
            if (ps.pay > top.pay) top = ps;
        }
        System.out.println("Total " + total);
        System.out.println("top earner " + top.name);
    }
}