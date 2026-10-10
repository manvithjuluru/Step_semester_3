package class_problems;
public class Problem4 {
    public static void main(String[] args) {
        String[] input = {
                "Asha [78, 85, 90]",
                "Ravi [88, 92, 79]",
                "Neha [65, 70, 95]"
        };
        int n = input.length;
        String[] names = new String[n];
        int[][] marks = new int[n][3];
        for (int i = 0; i < n; i++) {
            int bracket = input[i].indexOf('[');
            names[i] = input[i].substring(0, bracket).trim();
            String[] nums = input[i].substring(bracket + 1, input[i].indexOf(']')).split(",");
            for (int j = 0; j < 3; j++) {
                marks[i][j] = Integer.parseInt(nums[j].trim());
            }
        }
        int[] totals = new int[n];
        int[] subjectSums = new int[3];
        int topper = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                totals[i] += marks[i][j];
                subjectSums[j] += marks[i][j];
            }
            if (totals[i] > totals[topper]) topper = i;
        }
        StringBuilder sb = new StringBuilder("Totals ");
        for (int i = 0; i < n; i++) {
            sb.append(names[i]).append(" ").append(totals[i]);
            if (i < n - 1) sb.append(", ");
        }
        System.out.println(sb);
        StringBuilder avg = new StringBuilder("averages ");
        for (int j = 0; j < 3; j++) {
            avg.append(String.format("%.2f", subjectSums[j] / (double) n));
            if (j < 2) avg.append(", ");
        }
        System.out.println(avg);
        System.out.println("topper " + names[topper] + " (" + totals[topper] + ")");
    }
}