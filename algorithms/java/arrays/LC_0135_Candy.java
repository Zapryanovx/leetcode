package arrays;

import java.util.Arrays;

public class LC_0135_Candy {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        for (int i = 0; i < candies.length; i++) {

            if (i > 0) {
                if (ratings[i] > ratings[i - 1]) {
                    candies[i] = Math.max(candies[i], candies[i - 1] +  1);
                }
            }
        }

        int total = 0;
        for (int i = candies.length - 1; i >= 0; i--) {

            if (i < ratings.length - 1) {
                if (ratings[i] > ratings[i + 1]) {
                    candies[i] = Math.max(candies[i], candies[i + 1] + 1);
                }
            }

            total += candies[i];
        }

        return total;
    }
}
