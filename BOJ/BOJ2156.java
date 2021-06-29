import java.io.*;
import java.util.*;

public class BOJ2156 {
    //포도주 시식
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] wine = new int[N];
        int[] dp = new int[N];
        int answer=0;
        for(int i=0;i<N;i++){
            wine[i]=sc.nextInt();
        }
        sc.close();

        for(int i=0;i<N;i++){
            if(i==0){
                dp[i] = wine[0];
            }
            else if(i==1){
                dp[i] = dp[0]+wine[1];
            }
            else if(i==2){
                dp[i] = Math.max(wine[0]+wine[2], wine[1]+wine[2]);
            }
            else if(i==3){
                dp[i] = Math.max(wine[0]+wine[1]+wine[3], wine[0]+wine[2]+wine[3]);
            }
            else{
                dp[i] = Math.max(Math.max(dp[i-2]+wine[i], dp[i-3]+wine[i-1]+wine[i]), dp[i-4]+wine[i-1]+wine[i]);
            }
            answer = Math.max(answer,dp[i]);
        }
        System.out.println(answer);
    }
}
