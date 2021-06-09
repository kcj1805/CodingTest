import java.io.*;
import java.util.*;

public class BOJ9461 {
    //파도반 수열
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<T;i++){
            int N = sc.nextInt();
            sb.append(Solution(N) + "\n");
        }
        System.out.println(sb.toString());
        sc.close();
    }
    public static Long Solution(int N)
    {
        Long answer = Long.valueOf(0);
        if(N==1) return Long.valueOf(1);
        if(N==2) return Long.valueOf(1);
        if(N==3) return Long.valueOf(1);
        Long A = Long.valueOf(1);
        Long B = Long.valueOf(1);
        Long C = Long.valueOf(1);
        for(int i=4;i<=N;i++){
            answer = A+B;
            A = B;
            B = C;
            C = answer;
        }

        return answer;
    }
}
