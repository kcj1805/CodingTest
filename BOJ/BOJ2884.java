import java.io.*;
import java.util.*;

public class BOJ2884 {
    //알람 시계
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int M = sc.nextInt();
        sc.close();

        for(int i=0;i<45;i++)
        {
            if(M==0)
            {
                M=59;
                if(H==0)
                {
                    H=23;
                }
                else
                {
                    H--;
                }
            }
            else
            {
                M--;
            }
        }

        System.out.println(H+" "+M);
    }
}
