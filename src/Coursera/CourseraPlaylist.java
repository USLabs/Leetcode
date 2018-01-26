package Coursera;

/**
 * Created by uslabs on 1/3/18.
 */
public class CourseraPlaylist {
    public static void solution() {

        int output = numOfPlaylist(1, 1, 3);
        int answer = output % 1000000007;

        System.out.print(output);
    }

    static int numOfPlaylist(int N, int K, int L) {
        int answer = factorial(N) / factorial(N - K - 1);
        answer *= Math.pow(N, L - K - 1);
        return answer;
    }

    static int factorial(int n) {
        if (n == 0)
            return 1;
        else
            return (n * factorial(n - 1));
    }
}
