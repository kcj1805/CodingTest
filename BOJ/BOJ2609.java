import java.io.*;
import java.util.*;

public class BOJ2609 {
    //최대공약수와 최소공배수
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int min = a>b ? b:a;
        int max = a>b ? a:b;
        int least = Integer.MAX_VALUE;
        for(int i=min*max;i>=max;i-=min){
            if(i%max==0 && i%min==0){
                least = Math.min(least,i);
            }
        }
        if(least == Integer.MAX_VALUE){
            least = Math.min(least,min);
        }

        while(true){
            int val = max%min;
            if(val==0){
                break;
            }
            else{
                max = min;
                min = val;
            }
        }
        System.out.println(min +"\n"+ least);
        sc.close();
    }
}
