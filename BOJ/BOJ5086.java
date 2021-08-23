import java.io.*;
import java.util.*;

public class BOJ5086 {
    //배수와 약수
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while(true){
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(a==0 && b==0){
                break;
            }
            else{
                if(b%a==0){
                    sb.append("factor");
                }
                else if(a%b==0){
                    sb.append("multiple");
                }
                else{
                    sb.append("neither");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
        sc.close();
    }
}
