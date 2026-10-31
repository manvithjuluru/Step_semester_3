package assigment_problems;
public class Problem1 {
    static int[] bubbleStats(int[] scores) {
        int passes = 0, swaps = 0;
        int n = scores.length;
        while (true) {
            boolean swapped = false;
            passes++;
            for (int i = 0; i < n - 1; i++) {
                if (scores[i] > scores[i + 1]) {
                    int temp = scores[i];
                    scores[i] = scores[i + 1];
                    scores[i + 1] = temp;
                    swaps++;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return new int[]{passes, swaps};
    }
    static void run(int[] scores) {
        int[] stats = bubbleStats(scores);
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < scores.length; i++) {
            sb.append(scores[i]);
            if (i < scores.length - 1) sb.append(", ");
        }
        sb.append("] passes = ").append(stats[0]).append(", swaps = ").append(stats[1]);
        System.out.println(sb);
    }
    public static void main(String[] args) {
        run(new int[]{5, 1, 4, 2, 8}); // [1, 2, 4, 5, 8] passes = 3, swaps = 4
        run(new int[]{1, 2, 3, 4});    // [1, 2, 3, 4] passes = 1, swaps = 0
    }
}