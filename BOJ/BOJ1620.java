import java.io.*;
import java.util.*;

public class BOJ1620 {
    //나는야 포켓몬 마스터 이다솜
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt(input.split(" ")[0]);
        int M = Integer.parseInt(input.split(" ")[1]);
        HashMap<String,Integer> hm = new HashMap<>();
        String[] strArr = new String[N];
        for(int i=0;i<N;i++){
            String tmp = br.readLine();
            hm.put(tmp,i+1);
            strArr[i] = tmp;
        }
        Object[] ob = new Object[M];
        for(int i=0;i<M;i++){
            String tmp = br.readLine();
            int tmpint = tryparseInt(tmp);
            if(tmpint != -1){
                ob[i] = strArr[tmpint-1];
            }
            else{
                ob[i] = hm.get(tmp);
            }
        }
        for(int i=0;i<M;i++){
            System.out.println(ob[i]);
        }
        br.close();
    }
    public static int tryparseInt(String str){
        try{
            return Integer.parseInt(str);
        }
        catch(NumberFormatException ex){
            return -1;
        }
    }
}
