import java.io.*;
import java.util.*;

public class N {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        //String cnt = br.readLine();
        //String input = br.readLine();

        wr.write("");
        Solution(4,128);
        wr.flush();
        wr.close();
        br.close();
    }
    static int answer = Integer.MAX_VALUE;
    public static int Solution(int N, int number)
    {
        String exp = "";
        exp = Integer.toString(N);
        Calc(N,number,1,N, exp);

        exp = Integer.toString(N*10+N);
        Calc(N,number,2,N*10+N, exp);

        exp = Integer.toString(N*100+N*10+N);
        Calc(N,number,3,N*100+N*10+N, exp);

        exp = Integer.toString(N*1000+N*100+N*10+N);
        Calc(N,number,4,N*1000+N*100+N*10+N, exp);

        exp = Integer.toString(N*10000+N*1000+N*100+N*10+N);
        Calc(N,number,5,N*10000+N*1000+N*100+N*10+N, exp);

        exp = Integer.toString(N*100000+N*10000+N*1000+N*100+N*10+N);
        Calc(N,number,6,N*100000+N*10000+N*1000+N*100+N*10+N, exp);

        exp = Integer.toString(N*1000000+N*100000+N*10000+N*1000+N*100+N*10+N);
        Calc(N,number,7,N*1000000+N*100000+N*10000+N*1000+N*100+N*10+N, exp);

        if(answer==Integer.MAX_VALUE)
        {
            answer = -1;
        }
        return answer;
    }
    public static void Calc(int N, int number, int cnt, int val, String exp)
    {
        if(cnt>8)
        {
            return;
        }
        if(val==number)
        {
            answer = Math.min(answer,cnt);
            System.out.println(exp);
            return;
        }
        cnt++;
        Calc(N,number,cnt,val+N, exp+"+"+N);
        Calc(N,number,cnt,val-N, exp+"-"+N);
        Calc(N,number,cnt,val*N, exp+"*"+N);
        Calc(N,number,cnt,val/N, exp+"/"+N);
    }
}