import java.io.*;
import java.util.*;

public class BOJ12865 {
    //평범한 배낭
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] val = new int[N][2];
        int[][] dp = new int[N+1][K+1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                val[i][j] = sc.nextInt();
            }
        }
        for(int n=1;n<N+1;n++){
            for(int k=1;k<K+1;k++){
                if(k>=val[n-1][0]){
                    dp[n][k] = Math.max( dp[n - 1][k], dp[n - 1][k-val[n-1][0]] + val[n-1][1]);
                }
                else{
                    dp[n][k]=dp[n-1][k];
                }
            }
        }
        System.out.print(dp[N][K]);
        sc.close();
    }
}