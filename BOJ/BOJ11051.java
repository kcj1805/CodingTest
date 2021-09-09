import java.io.*;
import java.util.*;

public class BOJ11051 {
    //이항계수 2
    static int[][] dp = new int[1001][1001];
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int answer = Comb(N,K);
        System.out.println(answer);
        sc.close();
    }
    public static int Comb(int N, int K)
    {
        if(N==K || K==0){
            dp[N][K]=1;
        }
        else if(dp[N][K] == 0){
            dp[N][K] = (Comb(N-1, K-1) + Comb(N-1, K))%10007;
        }
        return dp[N][K];
    }
}
