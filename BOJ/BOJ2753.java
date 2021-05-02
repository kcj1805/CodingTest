import java.io.*;
import java.util.*;

public class BOJ2753 {
    //윤년
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        sc.close();
        int answer = 0;
        if(input%4==0)
        {
            if(input%100!=0 || input%400==0)
            {
                answer = 1;
            }
        }

        System.out.println(answer);
    }
}
