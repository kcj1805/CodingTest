import java.io.*;
import java.util.*;

public class BOJ8393 {
    //합
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        int output = 0;
        for(int i=1;i<=N;i++)
        {
            output += i;
        }
        System.out.println(output);
    }
}
