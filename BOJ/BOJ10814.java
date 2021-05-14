import java.io.*;
import java.util.*;

public class BOJ10814 {
    //나이순 정렬
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[][] strArr = new String[N][2];

        for(int i=0;i<N;i++){
            String input = br.readLine();
            strArr[i][0] = input.split(" ")[0];
            strArr[i][1] = input.split(" ")[1];
        }

        Arrays.sort(strArr, (a,b)-> Integer.parseInt(a[0]) - Integer.parseInt(b[0]));

        for (String[] strings : strArr) {
            wr.write(strings[0] + " " + strings[1] + "\n");
        }
        wr.flush();
        wr.close();
        br.close();
    }
}
