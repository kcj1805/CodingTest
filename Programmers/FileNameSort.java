import java.io.*;
import java.util.*;

public class FileNameSort {
    //[3차]파일명 정렬
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] strings = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        String[] ansList;
        ansList = solution(strings);
        for (String string : ansList) {
            wr.write(string+"\n");
        }
        wr.flush();
        wr.close();
        br.close();
    }
    public static String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                String Head = a.split("[0-9]")[0].toUpperCase();
                String str = a.substring(Head.length(),a.length());
                String NUMBERstr = str.split("[^0-9]")[0];
                int NUMBER = Integer.parseInt(NUMBERstr);

                String bHead = b.split("[0-9]")[0].toUpperCase();;
                String bstr = b.substring(bHead.length(),b.length());
                String bNUMBERstr = bstr.split("[^0-9]")[0];
                int bNUMBER = Integer.parseInt(bNUMBERstr);

                int res1 = Head.compareTo(bHead);
                if(res1==0){
                    return NUMBER-bNUMBER;
                }
                else{
                    return res1;
                }
            }
        });
        return files;
    }
}
