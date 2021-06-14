import java.io.*;
import java.util.*;

public class BOJ9663 {
    //N-Queen
    static int N, ans;

    static boolean[] col, slash, backslash;

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        col = new boolean[N];
        slash = new boolean[2 * N - 1];
        backslash = new boolean[2 * N - 1];

        ans = 0;
        solve(0);
        System.out.println(ans);
        sc.close();
    }

    public static void solve(int r) {
        if (r == N) {
            ans++;
            return;
        }
        for (int c = 0; c < N; c++) {
            if (check(r, c)) {
                col[c] = slash[r + c] = backslash[r - c + N - 1] = true;
                solve(r + 1);
                col[c] = slash[r + c] = backslash[r - c + N - 1] = false;
            }
        }
    }
    public static boolean check(int r, int c) {
        if (col[c] || slash[r + c] || backslash[r - c + N - 1])
            return false;
        return true;
    }
}
