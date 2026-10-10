package class_problems;
import java.util.LinkedHashMap;
import java.util.Map;
interface Chargeable {
}
abstract class Vehicle {
    String passNumber;
    String owner;
    Vehicle(String passNumber, String owner) {
        this.passNumber = passNumber;
        this.owner = owner;
    }
    abstract int getPassFee();
    abstract String getType();
}
class Bike extends Vehicle {
    Bike(String p, String o) { super(p, o); }
    int getPassFee() { return 300; }
    String getType() { return "Bike"; }
}
class Car extends Vehicle {
    Car(String p, String o) { super(p, o); }
    int getPassFee() { return 1000; }
    String getType() { return "Car"; }
}
class EBike extends Vehicle implements Chargeable {
    EBike(String p, String o) { super(p, o); }
    int getPassFee() { return 300; }
    String getType() { return "EBike"; }
}
class ECar extends Vehicle implements Chargeable {
    ECar(String p, String o) { super(p, o); }
    int getPassFee() { return 1000; }
    String getType() { return "ECar"; }
}
public class Problem2 {
    static Vehicle create(String type, String pass, String owner) {
        switch (type) {
            case "Bike":  return new Bike(pass, owner);
            case "Car":   return new Car(pass, owner);
            case "EBike": return new EBike(pass, owner);
            case "ECar":  return new ECar(pass, owner);
            default: return null;
        }
    }
    public static void main(String[] args) {
        String[] input = {
                "PASS Bike KA01 Asha",
                "PASS ECar KA02 Ravi",
                "CHARGE KA02",
                "CHARGE KA01"
        };
        Map<String, Vehicle> vehicles = new LinkedHashMap<>();
        for (String line : input) {
            String[] p = line.split(" ");
            if (p[0].equals("PASS")) {
                Vehicle v = create(p[1], p[2], p[3]);
                vehicles.put(p[2], v);
                System.out.println(v.passNumber + " (" + v.getType() + ") pass fee " + v.getPassFee());
            } else if (p[0].equals("CHARGE")) {
                Vehicle v = vehicles.get(p[1]);
                if (v == null) {
                    System.out.println("Vehicle not found");
                } else if (v instanceof Chargeable) {
                    System.out.println(v.passNumber + " charging bay allotted");
                } else {
                    System.out.println(v.passNumber + " rejected: charging unsupported");
                }
            }
        }
    }
}