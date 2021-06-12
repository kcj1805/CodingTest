import java.io.*;
import java.util.*;

public class BOJ9184 {
    //신나는 함수 실행
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int answer = 0;
        wArr = new int[51][51][51];
        while(true){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if(a==-1 && b==-1 && c==-1){
                break;
            }
            answer = w(a, b, c);
                
            sb.append("w("+a+", "+b+", "+c+") = ");
            sb.append(answer+"\n");
        }
        System.out.println(sb.toString());
        sc.close();
    }
    static int[][][] wArr;
    public static int w(int a, int b, int c)
    {
        if(a <= 0 || b <= 0 || c <= 0){
            return 1;
        }
        if(a > 20 || b > 20 || c > 20){
            return w(20,20,20);
        }
        if(wArr[a][b][c] != 0){
            return wArr[a][b][c];
        }
        if(a<b && b<c){
            return wArr[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        }
        else{
            return wArr[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        }
    }
}
