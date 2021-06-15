import java.io.*;
import java.util.*;

public class BOJ1149 {
    //RGB거리
    static int[][] town;
    static int N;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        town = new int[N][3];
        for(int i=0;i<N;i++){
            for(int j=0;j<3;j++){
                town[i][j] = sc.nextInt();
            }
        }

        //백트래킹
        BackTracking(0,4,0);
        //동적 프로그래밍
        DynamicProgramming();
        for(int i=0;i<3;i++){
            answer = Math.min(town[N-1][i],answer);
        }

        System.out.println(answer);
        sc.close();
    }
    public static void BackTracking(int cnt, int except, int val)
    {
        if(cnt == N){
            answer = Math.min(answer,val);
            return;
        }
        for(int i=0;i<3;i++)
        {
            if(i != except){
                val += town[cnt][i];
                BackTracking(cnt+1, i, val);
                val -= town[cnt][i];
            }
        }
    }
    public static void DynamicProgramming()
    {
        for(int i=1;i<N;i++){
            for(int j=0;j<3;j++)
            {
                int val = Integer.MAX_VALUE;
                for(int k=0;k<3;k++){
                    if(j != k){
                        int tmp = town[i][j] + town[i-1][k];
                        val = Math.min(val,tmp);
                    }
                }
                town[i][j] = val;
            }
        }
    }
}
