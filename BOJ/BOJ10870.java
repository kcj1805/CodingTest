import java.io.*;
import java.util.*;

public class BOJ10870 {
    //피보나치 수 5
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();

        wr.write(Integer.toString(Solution(Integer.parseInt(input))));
        
        wr.flush();
        wr.close();
        br.close();
    }

    static int[] FibonacciNum;

    public static int Solution(int input)
    {
        //FibonacciNum = new int[input+1];
        //Fibonacci(input,0);
        //return FibonacciNum[input];
        
       return Fibonacci2(input);

    }

    public static void Fibonacci(int n, int cnt)
    {   
        if(cnt==n+1)
        {
            return;
        }
        if(cnt==0)
        {
            FibonacciNum[cnt]=0;
        }
        else if(cnt==1 || cnt==2)
        {
            FibonacciNum[cnt]=1;
        }
        else
        {
            FibonacciNum[cnt] = FibonacciNum[cnt-1]+FibonacciNum[cnt-2];
        }
        Fibonacci(n,++cnt);
        return;
    }
    
    public static int Fibonacci2(int n)
    {   
        if(n==0)
        {
            return 0;
        }
        else if(n==1 || n==2)
        {
            return 1;
        }
        else
        {
            return Fibonacci2(n-1) + Fibonacci2(n-2);
        }
    }
}
