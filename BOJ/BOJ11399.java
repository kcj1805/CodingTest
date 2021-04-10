import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ11399 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        String cnt = br.readLine();
        String input = br.readLine();

        int[] minArr = new int[Integer.parseInt(cnt)];
        for(int i=0;i<minArr.length;i++)
        {
            minArr[i]=Integer.parseInt(input.split(" ")[i]);
        }
        wr.write(Integer.toString(Solution(minArr)));
        
        wr.flush();
        wr.close();
        br.close();
    }
    public static int Solution(int[] min)
    {
        int answer=0;
        int res=0;
        Arrays.sort(min);

        for(int i=0;i<min.length;i++)
        {
            res += min[i];
            answer += res;
        }
        return answer;
    }
}
