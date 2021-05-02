import java.io.*;
import java.util.*;

public class BOJ14681 {
    //사분면 고르기
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.close();
        int output=0;
        if(x*y>0)
        {
            if(x>0)
            {
                output=1;
            }
            else
            {
                output=3;
            }
        }
        else
        {
            if(x>0)
            {
                output=4;
            }
            else
            {
                output=2;
            }
        }
        System.out.println(output);
    }
}
