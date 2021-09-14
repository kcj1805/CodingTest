import java.io.*;
import java.util.*;

public class Program1 {
    public static void main(String[] args) throws IOException
    {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k=2;
        int[] ans = Solution(id_list, report, k);
    }
    public static int[] Solution(String[] id_list, String[] report, int k)
    {
        report = Arrays.stream(report).distinct().toArray(String[]::new);

        Map<String,Integer> IdMap = new HashMap<>();
        Map<String,Integer> IdMailMap = new HashMap<>();
        HashMap<String,List<String>> RepMap = new HashMap<>();

        for (String str : id_list) {
            IdMap.put(str,0);
            IdMailMap.put(str,0);
        }
        for (String str : report) {
            String Reporter = str.split(" ")[0];
            String User = str.split(" ")[1];
            if(RepMap.containsKey(User)){
                RepMap.get(User).add(Reporter);
            }
            else{
                LinkedList<String> ReporterList = new LinkedList<>();
                ReporterList.add(Reporter);
                RepMap.put(User,ReporterList);
            }
            IdMap.put(User,IdMap.get(User)+1);
        }


        for(int i=0;i<IdMap.size();i++){
            String Name = id_list[i];
            int cnt = IdMap.get(Name);
            if(cnt >= k){
                for (String str : RepMap.get(Name)) {
                    IdMailMap.put(str, IdMailMap.get(str)+1);
                }
            }
        }

        int[] answer = new int[id_list.length];
        for (int i=0;i<IdMailMap.values().size();i++) {
            answer[i] = (int)IdMailMap.get(id_list[i]);
        }
        return answer;
    }
}
