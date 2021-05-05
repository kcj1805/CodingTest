import java.io.*;
import java.util.*;

public class BOJ2798 {
    //블랙잭
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        String input2 = br.readLine();
        int N = Integer.parseInt(input.split(" ")[0]);
        int M = Integer.parseInt(input.split(" ")[1]);

        int[] valArr = Arrays.stream(input2.split(" ")).mapToInt(Integer::parseInt).toArray();
        
        wr.write(Integer.toString(Solution(N,M,valArr)));
        wr.flush();
        wr.close();
        br.close();
    }
    public static int Solution(int N, int M, int[] input)
    {
        int answer=0;
        for(int i=0;i<input.length;i++)
        {
            for(int j=i+1;j<input.length;j++)
            {
                for(int k=j+1;k<input.length;k++)
                {
                    int val = input[i]+input[j]+input[k];
                    if(val<=M){
                        answer = Math.max(val, answer);
                    }
                }   
            }
        }
        return answer;
    }
}
