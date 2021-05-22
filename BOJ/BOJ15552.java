import java.io.*;

public class BOJ15552 {
    //빠른 A+B
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int A,B=0;
        int[] outArr = new int[T];
        for(int i=0;i<T;i++)
        {
            String str = br.readLine();
            A = Integer.parseInt(str.split(" ")[0]);
            B = Integer.parseInt(str.split(" ")[1]);
            outArr[i] = A+B;
        }

        for (int i : outArr) 
        {
            wr.write(Integer.toString(i)+"\n");
        }
        
        wr.flush();
        wr.close();
        br.close();
    }
}
