import java.io.*;
import java.util.*;


public class BOJ7662 {
    //이중 우선순위 큐
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        TreeMap<Integer, Integer> map = new TreeMap<>();
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int K = Integer.parseInt(br.readLine());
            for(int j=0;j<K;j++){
                Solution(map,br.readLine());
            }
            if(map.isEmpty()){
                sb.append("EMPTY\n");
            }
            else{
                sb.append(map.lastKey() + " " + map.firstKey() + "\n");
            }
            map.clear();
        }

        wr.write(sb.toString());
        wr.flush();
        wr.close();
        br.close();

    }
    public static void Solution(TreeMap<Integer, Integer> map, String str)
    {
        StringTokenizer st = new StringTokenizer(str);

        String command = st.nextToken();
        int val = Integer.parseInt(st.nextToken());
        switch(command){
            case "I":{
                if(map.containsKey(val)){
                    map.put(val, map.get(val)+1);
                }
                else{
                    map.put(val,1);
                }
                break;
            }
            case "D":{
                if(!map.isEmpty()){
                    int key=0;
                    if(val == 1){
                        key = map.lastKey();
                    }
                    else if(val == -1){
                        key = map.firstKey();
                    }
                    if(map.get(key)>1){
                        map.put(key, map.get(key)-1);
                    }
                    else{
                        map.remove(key);
                    }
                }
                break;
            }
        }
    }
}
