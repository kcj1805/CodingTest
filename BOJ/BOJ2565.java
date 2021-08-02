import java.io.*;
import java.util.*;

public class BOJ2565 {
    //전깃줄
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] val = new int[N][2];
        int[] dp = new int[N];
        int answer = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<2;j++){
                val[i][j] = sc.nextInt();
            }
        }
        Arrays.sort(val, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        for(int i=0;i<N;i++){
            dp[i]=1;
            for(int j=i-1;j>=0;j--){
                if(val[i][1]>val[j][1]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            answer = Math.max(answer,dp[i]);
        }
        System.out.println(N-answer);
        sc.close();
    }
}
