import java.io.*;
import java.util.*;

public class BOJ2438 {
    //별찍기 - 1
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<i+1;j++)
            {
                System.out.printf("*");
            }
            System.out.println();
        }
        sc.close();
    }
}
