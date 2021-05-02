import java.io.*;
import java.util.*;

public class BOJ9498 {
    //시험 성적
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        if(input >= 90 && input <= 100)
        {
            System.out.println("A");
        }
        else if(input >= 80 && input <= 89)
        {
            System.out.println("B");
        }
        else if(input >= 70 && input <= 79)
        {
            System.out.println("C");
        }
        else if(input >= 60 && input <= 69)
        {
            System.out.println("D");
        }
        else
        {
            System.out.println("F");
        }
        sc.close();
    }
}
