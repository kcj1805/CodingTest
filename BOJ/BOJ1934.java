import java.io.*;
import java.util.*;

public class BOJ1934 {
    //최소공배수
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for(int i=0;i<T;i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int least = Integer.MAX_VALUE;
            for(int j=A*B;j>=B;j-=A){
                if(j%B==0 && j%A==0){
                    least = Math.min(least,j);
                }
            }
            sb.append(least+"\n");
        }
        System.out.println(sb.toString());
        sc.close();
    }
}
