package Leetcode;

/**
 * Created by uslabs on 1/3/18.
 */
public class CourseraPlaylist {
    public static void solution()
    {

        int output = numOfPlaylist(1,1,3);
        int answer = output % 1000000007;

        System.out.print(answer);
    }

    static int numOfPlaylist(int N, int K, int L) {
        if (K == 0 && N < L) {
            return 1;
        } else if (N < K || (N == K && L > N)) {
            return 0;
        } else if (N == K && N > L) {
            return factorial(N);
        } else if (N == L && K < L) {
            return factorial(L);
        } else if (N < L && K < L) {

            if (N == K + 1 && L > N) {
                return factorial(N);
            } else if (N == K + 1) {
                return N;
            } else if (L - N == 1) {
                return factorial(N) * (N);
            } else {
                return factorial(N) * recur(L - N, N);
            }
        }

        return 0;

    }

    public static int combination(int n, int k) {
        return permutation(n) / (permutation(k) * permutation(n - k));
    }

    public static int permutation(int i) {
        if (i == 1) {
            return 1;
        }
        return i * permutation(i - 1);
    }

    static int recur(int input, int totalSongs) {

        if (input == 1) {
            return (totalSongs * 1);
        } else {
            return (recur(input - 1, totalSongs) * 2) + 1;
        }
    }

    static int factorial(int n) {
        if (n == 0)
            return 1;
        else
            return (n * factorial(n - 1));
    }
}
