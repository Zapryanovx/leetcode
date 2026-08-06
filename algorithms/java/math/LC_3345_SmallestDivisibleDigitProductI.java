// https://leetcode.com/problems/smallest-divisible-digit-product-i/description

package math;

public class LC_3345_SmallestDivisibleDigitProductI {
    public int smallestNumber(int n, int t) {
        while(true) {
            if (productOfDigitsOf(n) % t == 0) {
                return n;
            }
            n++;
        }
    }

    private int productOfDigitsOf(int n) {
        int mul = 1;
        while (n > 0) {
            mul *= n % 10;
            n /= 10;
        }
        return mul;
    }
}
