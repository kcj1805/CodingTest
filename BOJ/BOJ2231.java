import java.io.*;
import java.util.*;

public class BOJ2231 {
    //분해합
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        int answer = Integer.parseInt(input);
        for(int i=1;i<=1000000;i++){
            int temp = Calc(i);
            if(temp==Integer.parseInt(input)){
                answer = i;
                break;
            }
        }
        answer = answer==Integer.parseInt(input) ? 0 : answer;
        wr.write(Integer.toString(answer));
        wr.flush();
        wr.close();
        br.close();
    }
    public static int Calc(int N)
    {
        int answer=N;
        String[] strArr = Integer.toString(N).split("");

        for(int i=0;i<strArr.length;i++){
            answer += Integer.parseInt(strArr[i]);
        }
        
        return answer;
    }
}