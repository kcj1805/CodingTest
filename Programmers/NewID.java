import java.io.*;
import java.util.*;

public class NewID {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        wr.write("");
        wr.flush();
        wr.close();
        br.close();
        solution("=.=");
        Scanner sc = new Scanner(System.in);
        sc.close();
    }
    public static String solution(String new_id) {
        //1단계
        new_id = new_id.toLowerCase();
        //2단계
        new_id = new_id.replaceAll("[^a-z0-9\\-\\_\\.]", "");
        //3단계
        new_id = new_id.replaceAll("\\.{2,}", ".");
        //4단계
        new_id = new_id.startsWith(".") ? new_id.substring(1, new_id.length()) : new_id;
        new_id = new_id.endsWith(".") ? new_id.substring(0, new_id.length()-1) : new_id;
        //5단계
        new_id = new_id.isEmpty() ? "a" : new_id;
        //6단계
        new_id = new_id.length() >= 16 ? new_id.substring(0, 15) : new_id;
        new_id = new_id.endsWith(".") ? new_id.substring(0, new_id.length()-1) : new_id;
        //7단계
        char last = new_id.charAt(new_id.length()-1);
        while(new_id.length()<3){
            new_id = new_id + last;
        }
        return new_id;
    }
}
