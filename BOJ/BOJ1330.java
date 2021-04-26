import java.io.*;
import java.util.*;

public class BOJ1330 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        String a = input.split(" ")[0];
        String b = input.split(" ")[1];
        
        int val = Integer.parseInt(a)-Integer.parseInt(b);
        String rtn="";
        if(val<0){
            rtn = "<";
        }
        else if(val>0){
            rtn=">";
        }
        else{
            rtn="==";
        }
        wr.write(rtn);
        
        wr.flush();
        wr.close();
        br.close();
    }
}
