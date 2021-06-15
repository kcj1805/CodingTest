import java.io.*;
import java.util.*;

public class BOJ2579 {
    //계단 오르기
    static int[] stair;
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        stair = new int[N];
        for(int i=0;i<N;i++){
            stair[i] = sc.nextInt();
        }
        Solution(N);
        sc.close();
    }
    public static void Solution(int N)
    {
        for(int i=1;i<N;i++){
            if(i==1){
                //stair[i] += stair[i-1];
            }
            else if(i==2){
                int tmp = stair[i-2] + stair[i];
                int tmp2 = stair[i-1] + stair[i];
                stair[i] = Math.max(tmp,tmp2);
            }
            else{
                int tmp = stair[i-2] + stair[i-1]+ stair[i];
                int tmp2 = stair[i-1] + stair[i];
                stair[i] = Math.max(tmp,tmp2);
            }
        }
        return;
    }
}
