import java.io.*;

public class BOJ1436 {
    //영화감독 숌
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int input = Integer.parseInt(br.readLine());

        int cnt=0;
        for(int i=666;i<Integer.MAX_VALUE;i++){
            if(Integer.toString(i).contains("666")){
                cnt++;
                if(cnt==input){
                    wr.write(Integer.toString(i));
                    break;
                }
            }
        }
        
        wr.flush();
        wr.close();
        br.close();
    }
}
