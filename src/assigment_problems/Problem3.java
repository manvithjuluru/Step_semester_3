package assigment_problems;
public class Problem3 {
    static long countInversions(int[] roll) {
        int[] a = roll.clone();          // keep the caller's array unchanged
        int[] temp = new int[a.length];
        return mergeSort(a, temp, 0, a.length - 1);
    }
    static long mergeSort(int[] a, int[] temp, int left, int right) {
        if (left >= right) return 0;
        int mid = left + (right - left) / 2;
        long count = mergeSort(a, temp, left, mid)
                + mergeSort(a, temp, mid + 1, right);
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
                count += (mid - i + 1);
            }
        }
        while (i <= mid) temp[k++] = a[i++];
        while (j <= right) temp[k++] = a[j++];
        for (int x = left; x <= right; x++) a[x] = temp[x];
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countInversions(new int[]{2, 4, 1, 3, 5})); // 3
        System.out.println(countInversions(new int[]{5, 4, 3, 2, 1})); // 10
    }
}