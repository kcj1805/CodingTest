import java.io.*;
import java.util.*;

public class BOJ9375 {
    public static void main(String[] args) throws IOException
    {
        StringBuilder sb = new StringBuilder();
        HashMap<String,LinkedList<String>> hm = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0;i<T;i++){
            int N = sc.nextInt();
            int res = N;
            for(int j=0;j<N;j++){
                String name = sc.next();
                String type = sc.next();
    
                if(hm.containsKey(type)){
                    hm.get(type).add(name);
                }
                else{
                    LinkedList<String> tmplist = new LinkedList<>();
                    tmplist.add(name);
                    hm.put(type,tmplist);
                }
            }

            //if(hm.keySet().size()>1)
            {
                int tmp=1;
                for (String key : hm.keySet()) {
                    tmp *= hm.get(key).size();
                    res += tmp;
                }
    
                hm.clear();
            }
            sb.append(res + "\n");
        }
        System.out.println(sb.toString());
        sc.close();
    }
}
