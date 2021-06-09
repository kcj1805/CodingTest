import java.io.*;
import java.util.*;

public class BOJ9184 {
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int answer = 0;
        wArr = new int[20][9];
        while(true){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if(a==-1 && b==-1 && c==-1){
                break;
            }
            if(a <= 0 || b <= 0 || c <= 0){
                answer = 1;
            }
            else{
                if(a > 20 || b > 20 || c > 20){
                    a = b = c = 20;
                }
                answer = w(a, b, c);
            }
                
            sb.append("w("+a+", "+b+", "+c+") = ");
            sb.append(answer+"\n");
        }
        System.out.println(sb.toString());
        sc.close();
    }
    //a,b,c,ab,ac,bc,abc
    static int[][] wArr;
    public static int w(int a, int b, int c)
    {
        if(a<b && b<c){
            wArr[0][7] = wArr[0][2] + wArr[0][5] - wArr[0][1];
        }
        else{
            wArr[0][8] = wArr[0][0] + wArr[0][3] + wArr[0][4] - wArr[0][6];
        }
    }
}
