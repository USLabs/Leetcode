package Leetcode;

/**
 * Created by uslabs on 1/14/18.
 */
public class PrimeNumberOfSetBitsInBinaryRepresentation {
    public static void solution() {
        System.out.println(Integer.toBinaryString(567));
        System.out.println(Integer.toBinaryString(607));
        //System.out.println(countPrimeSetBits(567, 607));
    }

    static int countPrimeSetBits(int L, int R) {
        int count = 0;
        for (int i = L; i <= R; i++) {
            if (isPrime(countBits(i)))
                count++;
        }
        return count;
    }

    static int countBits(int n) {
        int bits = 0;
        while (n > 0) {
            bits += n % 2;
            n = n / 2;
        }
        return bits;
    }

    static boolean isPrime(int n) {
        if (n == 1)
            return false;
        if (n == 2)
            return true;
        if (n % 2 == 0)
            return false;
        for (int i = 3; i < n / 2; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
