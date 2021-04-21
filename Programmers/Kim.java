import java.io.*;
import java.util.*;

public class Kim {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        //String cnt = br.readLine();
        //String input = br.readLine();
        String[] input = {"Jane", "Kim"};
        String output = Solution(input);
        wr.write(output);
        
        wr.flush();
        wr.close();
        br.close();
    }
    public static String Solution(String[] seoul)
    {
        String answer = "";
        for(int i =0;i<seoul.length;i++)
        {
            //seoul[i]=="Kim" 은 프로그래머스에서 실패한다..?
            if(seoul[i].equals("Kim"))
            {
                answer = "김서방은 "+i+"에 있다";
                break;
            }
        }
        return answer;
    }
}
