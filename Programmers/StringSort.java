import java.io.*;
import java.util.*;

public class StringSort {
    //문자열 내 마음대로 정렬하기
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] strings = {"abce", "abcd", "cdx"};
        int n=2;
        String[] ansList;
        ansList = solution(strings,n);
        for (String string : ansList) {
            wr.write(string+"\n");
        }
        wr.flush();
        wr.close();
        br.close();
    }
    public static String[] solution(String[] strings, int n) {
        List<String> strlist = Arrays.asList(strings);
        String[] answer = new String[strlist.size()];
        Collections.sort(strlist, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                char[] aArr = a.toCharArray();
                char[] bArr = b.toCharArray();
                int val = String.valueOf(aArr[n]).compareTo(String.valueOf(bArr[n]));
                if(val == 0){
                    return a.compareTo(b);
                }
                else{
                    return val;
                }
            }
        });
        strlist.toArray(answer);
        return answer;
    }
}
