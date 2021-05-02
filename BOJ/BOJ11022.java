import java.io.*;
import java.util.*;

public class BOJ11022 {
    //A+B - 8
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int A,B=0;
        String[] outArr = new String[T];
        for(int i=0;i<T;i++)
        {
            A = sc.nextInt();
            B = sc.nextInt();
            outArr[i] = "Case #" + (i+1) + ": " + A + " + " + B + " = " + (A+B);
        }
        for (String string : outArr) 
        {
            System.out.println(string);
        }
        sc.close();
    }
}
