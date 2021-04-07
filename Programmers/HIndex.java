import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class HIndex {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        //String cnt = br.readLine();
        //String input = br.readLine();

        int[] input = {3, 0, 6, 1, 5};
        
        wr.write(Integer.toString(Solution(input)));
        
        wr.flush();
        wr.close();
        br.close();
    }
    public static int Solution(int[] citations)
    {
        int answer=0;
        Integer[] test = Arrays.stream(citations).boxed().toArray(Integer[]::new);

        Arrays.sort(test,Comparator.reverseOrder());

        while(answer < test.length)
        {
            if(test[answer] <= answer) break;
            answer++;
        }
        return answer;
    }
}
