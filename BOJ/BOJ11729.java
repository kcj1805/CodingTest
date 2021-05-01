import java.io.*;
import java.util.*;

public class BOJ11729 {
    //하노이 탑 이동순서
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();

        int N = Integer.parseInt(input);
        int cnt = (int)(Math.pow(2,N)-1);
        wr.write(Integer.toString(cnt)+"\n");
        Calc(N,1,2,3);

        for (String string : strList) {
            wr.write(string + "\n");
        }
        wr.flush();
        wr.close();
        br.close();
    }
    static List<String> strList = new ArrayList<>();
    public static void Calc(int N, int from, int mid, int to)
    {
        if(N!=0)
        {
            Calc(N-1,from,to,mid);
            strList.add(from + " " + to);
            Calc(N-1,mid,from,to);
        }
    }
}
