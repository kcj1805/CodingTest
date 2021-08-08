import java.io.*;
import java.util.*;

public class BOJ11047 {
    //동전 0
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] coin = new int[N];
        for(int i=0;i<N;i++){
            coin[i] = sc.nextInt();
        }
        sc.close();
        
        int cnt = 0;
        for(int i=N-1;i>=0;i--){
            if(K>=coin[i]){
                K -= coin[i];
                i++;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
