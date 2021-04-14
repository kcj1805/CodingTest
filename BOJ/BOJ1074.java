import java.io.*;
import java.util.*;

public class BOJ1074 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();

        int N = Integer.parseInt(input.split(" ")[0]);
        int r = Integer.parseInt(input.split(" ")[1]);
        int c = Integer.parseInt(input.split(" ")[2]);

        wr.write(Integer.toString(Solution(N,r,c)));

        wr.flush();
        wr.close();
        br.close();
    }
    public static int Solution(int N, int r, int c)
    {
        int pow = (int)Math.pow(2,N);
        Calc(pow,0,0,r,c);
        return ans;
    }
    static int val=0;
    static int ans=0;
    static boolean stop = false;
    public static void Calc(int pow, int i, int j, int r, int c)
    {
        if(pow==1)
        {
            val++;
            return;
        }
        for(int k=0;k<2;k++)
        {
            for(int l=0;l<2;l++)
            {
                if(i+(k*(pow/2))==r && j+(l*(pow/2))==c)
                {
                    ans = val;
                    stop=true;
                }
                if(!stop)
                {
                    Calc(pow/2,i+((pow/2)),j+((pow/2)),r,c);
                }
                else
                {
                    return;
                }
            }
        }
    }
}
