import java.io.*;
import java.util.*;

public class BOJ1037 {
    //약수
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0;i<N;i++){
            int input = sc.nextInt();
            min = Math.min(min,input);
            max = Math.max(max,input);
        }

        System.out.println(min * max);

        sc.close();
    }
}
