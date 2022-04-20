import java.io.*;
import java.util.*;

public class FuncDevelop {
    public static void main(String[] args) throws IOException
    {
        int[] progresses = {95, 90, 99, 99, 80, 99} ;
        int[] speeds = {1,1,1,1,1,1} ;
        solution(progresses, speeds);
    }
    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList =new ArrayList<>();
        List<Integer> duringday = new ArrayList<>();

        for(int i=0;i<progresses.length;i++){
            int work = 100-progresses[i];
            duringday.add(work/speeds[i]);
            if(work%speeds[i]>0){
                duringday.set(i, duringday.get(i)+1);
            }
        }
        int cnt = 0;
        int day=duringday.get(0);
        for (int val : duringday) {
            if(day>=val){
                cnt++;
            }
            else{
                answerList.add(cnt);
                cnt=1;
                day=val;
            }
        }
        answerList.add(cnt);
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}

