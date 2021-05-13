import java.io.*;
import java.util.*;

public class BOJ17219 {
    //비밀번호 찾기
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        HashMap<String, String> hm = new HashMap<>();
        for(int i=0;i<N;i++){
            String[] N_Data = br.readLine().split(" ");
            hm.put(N_Data[0],N_Data[1]);
        }
        for(int i=0;i<M;i++){
            wr.write(hm.get(br.readLine())+"\n");
        }
        wr.flush();
        wr.close();
        br.close();
    }
}
