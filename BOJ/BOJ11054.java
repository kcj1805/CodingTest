import java.io.*;
import java.util.*;

public class BOJ11054 {
    //가장 긴 바이토닉 부분 수열
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] val = new int[N];
        for(int i=0;i<N;i++){
            val[i] = sc.nextInt();
        }
        System.out.println(Solution(val));

        sc.close();
    }
    public static int Solution(int[] val)
    {
        int answer = 0;
        int[] Ldp = new int[val.length];
        int[] Rdp = new int[val.length];
        int len = val.length-1;
        for(int i=0;i<val.length;i++){
            if(i==0){
                Ldp[i] = 1;
                Rdp[len-i] = 1;
            }
            else{
                for(int j=0;j<i;j++){
                    if(val[j]<val[i]){
                        Ldp[i] = Math.max(Ldp[i],Ldp[j]+1);
                    }
                    else{
                        Ldp[i] = Math.max(Ldp[i],1);
                    }
                    
                    if(val[len-j]<val[len-i]){
                        Rdp[len-i] = Math.max(Rdp[len-i],Rdp[len-j]+1);
                    }
                    else{
                        Rdp[len-i] = Math.max(Rdp[len-i],1);
                    }
                }
            }
        }
        for(int i=0;i<val.length;i++){
            answer = Math.max(answer, Ldp[i]+Rdp[i]-1);
        }
        return answer;
    }
}
