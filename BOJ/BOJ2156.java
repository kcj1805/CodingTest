import java.io.*;
import java.util.*;

public class BOJ2156 {
    //6
    //1000
    //1000
    //1
    //1
    //1000
    //1000

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
                dp[i] = wine[i];
            }
            else if(i==1){
                dp[i] = dp[i-1]+wine[i];
            }
            else if(i==2){
                dp[i] = Math.max(wine[i-2]+wine[i], wine[i-1]+wine[i]);
            }
            else{
                dp[i] = Math.max(Math.max(dp[i-2]+wine[i],dp[i-3]+wine[i-1]+wine[i]),dp[i-3]+wine[i]);
            }
            answer = Math.max(answer,dp[i]);
        }
        System.out.println(answer);
    }
}
