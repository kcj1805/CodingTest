import java.io.*;
import java.util.*;

public class BOJ1003 {
    //피보나치 함수
    static int[] zero;
    static int[] one;
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for(int i=0;i<T;i++){
            int N = sc.nextInt();
            zero = new int[N+1];
            one = new int[N+1];
            Solution(N);
            sb.append(zero[N] + " " + one[N] + "\n");
        }

        System.out.println(sb.toString());
        sc.close();
    }
    public static void Solution(int N) 
    {
        for(int i=0;i<=N;i++){
            if(i==0){
                zero[i] = 1;
                one[i] = 0;
            }
            else if(i==1){
                zero[i] = 0;
                one[i] = 1;
            }
            else{
                zero[i] = zero[i-1]+zero[i-2];
                one[i] = one[i-1]+one[i-2];
            }
        }
    }
}
