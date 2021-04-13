import java.io.*;
import java.util.*;

public class Country124 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        //String cnt = br.readLine();
        //String input = br.readLine();

        Solution(22);

        wr.write("");

        wr.flush();
        wr.close();
        br.close();
    }
    public static String Solution(int input)
    {
        String answer="";
        StringBuilder a = new StringBuilder();
        a = Calc(input, a);
        answer = a.toString();
        return answer;
    }
    public static StringBuilder Calc(int val, StringBuilder rtn)
    {
        int mok = val/3;
        int nam = val%3;
        if(nam==0)
        {
            mok--;
            nam=4;
        }
        if(mok!=0)
        {
            return new StringBuilder(Calc(mok , rtn).append(nam)); 
        }
        else
        {
            if(val==3) val=4;
            return new StringBuilder(Integer.toString(val));
        }
    }
}
