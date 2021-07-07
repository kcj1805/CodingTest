import java.io.*;
import java.util.*;

public class BOJ11053 {
    //가장 긴 증가하는 부분 수열
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] val = new int[N];
        for(int i=0;i<N;i++){
            val[i] = sc.nextInt();
        }
        System.out.println(Solution(val));

        sc.close();
    }
    public static int Solution(int[] val)
    {
        int answer = 0;
        int[] dp = new int[val.length];
        for(int i=0;i<dp.length;i++){
            if(i==0){
                dp[i] = 1;
            }
            else{
                for(int j=0;j<i;j++){
                    if(val[j]<val[i]){
                        dp[i] = Math.max(dp[i],dp[j]+1);
                    }
                    else{
                        dp[i] = Math.max(dp[i],1);
                    }
                }
            }
            answer = Math.max(answer,dp[i]);
        }
        return answer;
    }
}
