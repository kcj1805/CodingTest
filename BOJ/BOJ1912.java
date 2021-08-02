import java.io.*;
import java.util.*;

public class BOJ1912 {
    //연속합
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N];
        int answer = Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            int input = sc.nextInt();
            if(i==0){
                dp[i] = input;
            }
            else if(dp[i-1]<0){
                dp[i] = input;
            }
            else{
                dp[i] = dp[i-1]+input;
            }
            answer = Math.max(answer,dp[i]);
        }

        System.out.println(answer);
        sc.close();
    }
}
