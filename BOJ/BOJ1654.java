import java.io.*;
import java.util.*;

public class BOJ1654 {
    //랜선 자르기
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
    public static long Solution(int[] lan, int N, int min)
    {
        long top = Integer.MAX_VALUE;
        long low = 1;
        long mid = (top+low)/2;
        long cnt=0;
        while(low<=top){
            cnt=0;
            for(int i=0;i<lan.length;i++){
                cnt += lan[i]/mid;
            }

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
