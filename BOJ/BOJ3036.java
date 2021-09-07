import java.io.*;
import java.util.*;

public class BOJ3036 {
    //링
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int first = sc.nextInt();
        for(int i=0;i<N-1;i++){
            int input = sc.nextInt();
            int gcd = getGCD(first,input);
            sb.append(first/gcd+"/"+input/gcd+"\n");
        }
        System.out.println(sb.toString());
        sc.close();
    }
    public static int getGCD(int A, int B)
    {
        while(true){
            int val = A%B;
            if(val==0){
                return B;
            }
            else{
                A = B;
                B = val;
            }
        }
    }
}
