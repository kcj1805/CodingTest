import java.io.*;
import java.util.*;

public class BOJ10871 {
    //X보다 작은 수
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        int N = Integer.parseInt(input.split(" ")[0]);
        int X = Integer.parseInt(input.split(" ")[1]);
        String[] NArr = br.readLine().split(" ");
        for(int i=0;i<N;i++)
        {
            if(X>Integer.parseInt(NArr[i]))
            {
                System.out.printf(NArr[i]);
                System.out.printf(" ");
            }
        }
        
        wr.flush();
        wr.close();
        br.close();
    }
}
