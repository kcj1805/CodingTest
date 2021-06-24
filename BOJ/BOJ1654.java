import java.io.*;
import java.util.*;

public class BOJ1654 {
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();
        int[] lan = new int[K];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<K;i++){
            int input = sc.nextInt();
            min = Math.min(min,input);
            lan[i]=input;
        }
        System.out.println(Solution(lan, N, min));

        sc.close();
    }
    public static int Solution(int[] lan, int N, int min)
    {
        int top = Integer.MAX_VALUE;
        int low = 0;
        int mid = (top+low)/2;
        int cnt=0;
        while(mid<top){
            cnt=0;
            for(int i=0;i<lan.length;i++){
                cnt += lan[i]/mid;
            }

            //if(cnt==N){
            //    mid++;
            //    continue;
            //}
            //else 
            if(cnt<N){
                top = mid-1;
            }
            else if(cnt>=N){
                low = mid+1;
            }
            mid = (top+low)/2;
        }
        return mid;
    }
}
