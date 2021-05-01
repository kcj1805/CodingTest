import java.io.*;

public class BOJ10872 {
    //팩토리얼
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        //String cnt = br.readLine();
        String input = br.readLine();

        wr.write(Integer.toString(Calc(1, Integer.parseInt(input))));
        
        
        wr.flush();
        wr.close();
        br.close();
    }
    public static int Calc(int cnt, int N)
    {
        if(cnt>N)
        {
            return 1;
        }
        return Calc(cnt+1,N) * cnt;
    }
}
