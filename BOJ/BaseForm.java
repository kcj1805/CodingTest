import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;

public class BaseForm {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        String cnt = br.readLine();
        String input = br.readLine();

        wr.write("");
        
        wr.flush();
        wr.close();
        br.close();
    }
    public static int Solution(int[] min)
    {
        int answer=0;

        return answer;
    }
}
