import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.io.InputStreamReader;

public class KNumber {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        //String cnt = br.readLine();
        //String input = br.readLine();
        int[] in = {1, 5, 2, 6, 3, 7, 4};
        int[][] com = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        
        Solution(in,com);

        wr.write("");
        
        wr.flush();
        wr.close();
        br.close();
    }
    public static int[] Solution(int[] array, int[][] commands)
    {
        int[] answer = new int[commands.length];

        for(int a=0;a<commands.length;a++)
        {
            int i=commands[a][0];
            int j=commands[a][1];
            int k=commands[a][2];
            int[] cutarray= new int[j-i+1];
            //cutarray = Arrays.copyOfRange(array, i-1, j);
            for(int b=0;b<cutarray.length;b++)
            {
                cutarray[b]=array[i++-1];
            }
            Arrays.sort(cutarray);
            answer[a] = cutarray[k-1];
        }
        return answer;
    }
}
