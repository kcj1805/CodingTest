import java.io.*;
import java.util.*;

public class BOJ10950 {
    //A+B - 3
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

        for (int i : outArr) 
        {
            System.out.println(i);
        }
        sc.close();
    }
}
