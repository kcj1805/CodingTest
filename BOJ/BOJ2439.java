import java.io.*;
import java.util.*;

public class BOJ2439 {
    //별찍기 - 2
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(j>=N-i-1)
                {
                    System.out.printf("*");
                }
                else{
                    System.out.printf(" ");
                }
            }
            System.out.println();
        }
        sc.close();
    }
}
