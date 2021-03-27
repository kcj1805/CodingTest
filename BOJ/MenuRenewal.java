import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MenuRenewal 
{
    static HashMap<String,Integer> hm = new HashMap<>();
    static List<String> comb = new ArrayList<>();
    public static void main(String[] args) 
    {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};
        String[] result = solution(orders,course);

        System.out.print("[");
        for (int i=0;i<result.length;i++) 
        {  
            System.out.print("\""+result[i]+"\"");
            if(i!=result.length-1)
            {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        for(int i=0;i<orders.length;i++)
        {
            char[] temp = orders[i].toCharArray();
            Arrays.sort(temp);
            for(int n=0;n<temp.length-1;n++)
            {
                for(int j=0;j<course.length;j++)
                {
                    dfs(temp, n, 1, course[j], String.valueOf(temp[n]));
                }
            }
        }
        for(int i=0;i<comb.size();i++)
        {
            char[] temp = comb.get(i).toCharArray();
            Arrays.sort(temp);

            if(hm.containsKey(new String(temp))==false)
            {
                hm.put(new String(temp), 1);
            }
            else
            {
                hm.put(new String(temp), hm.get(new String(temp))+1);
            }
            
        }

        List<String> res = new ArrayList<>();
        List<String> keySetList = new ArrayList<>(hm.keySet());
        Collections.sort(keySetList, (o1, o2) -> (hm.get(o2).compareTo(hm.get(o1))));
        for(int j=0;j<course.length;j++)
        {
            int max_value = 0;
            for (String key : keySetList) 
            {
                if(hm.get(key)>1 && key.length()==course[j])
                {
                    if (hm.get(key) >= max_value) {
                        res.add(key);
                        max_value = hm.get(key);
                    }
                }
            }
        }
        Collections.sort(res);
        answer = new String[res.size()];
        res.toArray(answer);
        return answer;
    }

    public static void dfs(char[] arr, int index, int length, int course, String str)
    {
        if(length == course)
        {
            comb.add(str);
        }
        for(int i=index+1;i<arr.length;i++)
        {
            dfs(arr, i, length+1, course, str+arr[i]);
        }
    }
}
