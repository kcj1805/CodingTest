import java.io.*;
import java.util.*;

public class BOJ1764 {
    //듣보잡
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0;i<N+M;i++){
            String input = sc.next();
            if(hm.containsKey(input)){
                hm.put(input,hm.get(input)+1);
            }
            else{
                hm.put(input, 1);
            }
        }
        List<String> list = new ArrayList<>(hm.keySet());
        List<String> anslist = new ArrayList<>();
        for (String str : list) {
            if(hm.get(str)>1){
                anslist.add(str);
            }
        }
        Collections.sort(anslist);
        System.out.println(anslist.size());
        for (String ans : anslist) {
            System.out.println(ans);
        }
        sc.close();
    }
}
