import java.io.*;
import java.util.*;

public class BOJ2750 {
    //2750,2751,10989
    //수 정렬하기 - 1,2,3
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());

        int[] inputArr = new int[input];
        for(int i=0;i<input;i++){
            inputArr[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(inputArr);

        for(int i=0;i<input;i++){
            wr.write(Integer.toString(inputArr[i])+"\n");
        }

        wr.flush();
        wr.close();
        br.close();
    }
}
