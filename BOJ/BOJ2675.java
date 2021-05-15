import java.io.*;
import java.util.*;

public class BOJ2675 {
    //문자열 반복
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] ansArr = new String[T];
        for(int i=0;i<T;i++){
            ansArr[i] = Solution(sc.nextInt(), sc.next());
        }
        for (String string : ansArr) {
            System.out.println(string);
        }
        sc.close();
    }
    public static String Solution(int R, String S)
    {
        StringBuilder sb = new StringBuilder();
        String[] strArr = S.split("");
        for(int i=0;i<strArr.length;i++){
            for(int j=0;j<R;j++){
                sb.append(strArr[i]);
            }
        }
        return sb.toString();
    }
}
