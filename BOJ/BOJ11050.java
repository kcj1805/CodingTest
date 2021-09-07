import java.io.*;
import java.util.*;

public class BOJ11050 {
    //이항계수 1
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int answer = getFactorial(N)/(getFactorial(K)*getFactorial(N-K));
        System.out.println(answer);
        sc.close();
    }
    public static int getFactorial(int val)
    {
        int res = 1;
        for(;val>0;val--){
            res *= val;
        }
        return res;
    }
}
