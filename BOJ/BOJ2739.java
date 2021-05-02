import java.io.*;
import java.util.*;

public class BOJ2739 {
    //구구단
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        for(int i=0;i<9;i++)
        {
            System.out.println(N + " * " + (i+1) + " = " + N*(i+1));
        }
    }
}
