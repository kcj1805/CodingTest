import java.io.*;
import java.util.*;

public class BOJ8958 {
    //OX퀴즈
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] ansArr = new int[N];
        for(int i=0;i<N;i++){
            ansArr[i] = Solution(sc.next());
        }
        for (int i : ansArr) {
            System.out.println(i);
        }
        sc.close();
    }
    public static int Solution(String OX)
    {
        int answer=0;
        String[] OXArr = OX.split("X");
        for(int i=0;i<OXArr.length;i++){
            if(!OXArr[i].isEmpty()){
                int score = OXArr[i].length();
                answer += score*(score+1)/2;
            }
        }
        return answer;
    }
}
