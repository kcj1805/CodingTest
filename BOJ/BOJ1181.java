import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ1181 {
    //단어 정렬
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<String> strList = new ArrayList<>();
        for(int i=0;i<N;i++){
            strList.add(sc.next());
        }
        Comparator<String> cmp = new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                if(a.length()-b.length()==0){
                    return a.compareTo(b);
                }
                else{
                    return a.length()-b.length();
                }
            }
        };
        strList = strList.stream().distinct().sorted(cmp).collect(Collectors.toList());

        for (String string : strList) {
            System.out.println(string);
        }
        sc.close();
    }
}
