import java.io.*;
import java.util.*;

public class BOJ9251 {
    //LCS
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] strArr1 = br.readLine().split("");
        String[] strArr2 = br.readLine().split("");
        int size = Math.max(strArr1.length,strArr2.length);
        int[][] dp = new int[size][size];

        for (int i=0;i<strArr1.length;i++) {
            for (int j=0;j<strArr2.length;j++) {
                if(strArr1[i].equals(strArr2[j])){
                    if(i==0 || j==0){
                        dp[i][j] = 1;
                    }
                    else{
                        dp[i][j] = dp[i-1][j-1]+1;
                    }
                }
                else{
                    if(i==0 && j==0){
                        dp[i][j] = 0;
                    }
                    else if(i==0){
                        dp[i][j] = Math.max(0,dp[i][j-1]);
                    }
                    else if(j==0){
                        dp[i][j] = Math.max(dp[i-1][j],0);
                    }
                    else{
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
        }
        wr.write(Integer.toString(dp[strArr1.length-1][strArr2.length-1]));
        wr.flush();
        wr.close();
        br.close();
    }
}
