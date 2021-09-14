import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class BOJ1010 {
    public static void main(String[] args) throws IOException
    {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0;i<T;i++){
            double A=1;
            double B=1;
            int N=sc.nextInt();
            int M=sc.nextInt();
            if(M/2<N) N=M-N;
            for(int j=0;j<N;j++){
                A*=M--;
            }
            for(int j=1;j<=N;j++){
                B*=j;
            }
            
            sb.append(new BigDecimal(A/B).toString()+"\n");
        }
        System.out.println(sb.toString());
        sc.close();
    }
}