package arrays;

public class LC_0274_HIndex {
    public int hIndex(int[] citations) {
        int[] count = new int[1001];

        for (int c: citations) {
            for (int i = c; i >= 0; i--) {
                count[i]++;
            }
        }

        for (int i = 1000; i >= 0; i--) {
            if (count[i] >= i) {
                return i;
            }
        }

        return -1;
    }
}
