import java.io.*;
import java.util.*;

public class BOJ1427 {
    //소트인사이드
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] NumArr = input.split("");
        List<String> strList = Arrays.asList(NumArr);

        //Collections.sort(strList, new Comparator<String>(){
        //    @Override
        //    public int compare(String a, String b){
        //        return b.compareTo(a);
        //    }
        //});

        Collections.sort(strList, (a,b)->b.compareTo(a));

        for (String string : strList) {
            System.out.print(string);
        }
        sc.close(); 
    }
}
