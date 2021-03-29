import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//주식 가격
public class StockPrice {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        //String input = br.readLine();
        int[] input = {1,2,3,2,3};
        int[] output = Solution(input);
        
        wr.write("[");
        for(int i=0;i<output.length;i++)
        {
            wr.write(Integer.toString(output[i]));
            if(i==output.length-1)
            {
                wr.write("]");
            }
            else
            {
                wr.write(", ");
            }
        }
        wr.flush();
        wr.close();
        br.close();
    }

    public static int[] Solution(int[] prices)
    {
        int[] answer = new int[prices.length];
        for(int i=0;i<prices.length;i++)
        {
            int sec = 0;
            for(int j=i+1;j<prices.length;j++)
            {
                if(prices[i]>prices[j])
                {
                    if(i!=prices.length-1)
                    {
                        sec++;
                    }
                    else
                    {
                        sec--;
                    }
                    break;
                }
                else
                {
                    sec++;
                }
            }
            answer[i]=sec;
        }
        return answer;
    }
}
