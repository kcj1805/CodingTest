import java.io.*;
import java.util.*;

public class BOJ1107 {
    //리모컨
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        List<Integer> NumList = new ArrayList<>();
        List<Integer> ansList = new ArrayList<>();
        for(int i=0;i<10;i++){
            NumList.add(i);
        }
        for(int i=0;i<M;i++){
            NumList.remove((Object)sc.nextInt());
        }

        RemoteControl(N,NumList,ansList,0);

        //100에서 +/- 했을때의 값과 answer비교
        int diff = Math.abs(N-100);
        if(diff<answer){
            answer = diff;
        }

        System.out.println(answer);
        sc.close();
    }
    static int answer=Integer.MAX_VALUE;

    public static void RemoteControl(int N, List<Integer> NumList, List<Integer> ansList, int cnt)
    {
        //카운트 계산
        if(!ansList.isEmpty()){
            StringBuilder sb = new StringBuilder();
            for (int ans : ansList) {
                sb.append(ans);
            }
            int finalint = Integer.parseInt(sb.toString());
            answer = Math.min(answer, Math.abs(N-finalint)+cnt);
        }

        //자리수 초과시 리턴
        if(ansList.size()==Integer.toString(N).length()+1){
            return;
        }
        
        //DFS
        for (int num : NumList) {
            ansList.add(num);
            cnt++;
            RemoteControl(N, NumList, ansList, cnt);
            cnt--;
            ansList.remove(ansList.size()-1);
        }
    }
}
