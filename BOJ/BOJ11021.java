import java.io.*;
import java.util.*;

public class BOJ11021 {
    //A+B - 7
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int A,B=0;
        int[] outArr = new int[T];
        for(int i=0;i<T;i++)
        {
            A = sc.nextInt();
            B = sc.nextInt();
            outArr[i] = A+B;
        }

        for (int i=0;i<T;i++) 
        {
            System.out.println("Case #"+(i+1)+": "+outArr[i]);
        }
        sc.close();
    }
}
