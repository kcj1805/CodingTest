import java.io.*;
import java.util.*;

public class BOJ9095 {
    //1,2,3 더하기
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i=0;i<T;i++){
            int N = sc.nextInt();
            System.out.println(Solution(N));
        }
        sc.close();
    }
    public static int Solution(int N)
    {
        int answer=0;
        int index = 0;
        List<List<Integer>> tsList = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        for(int i=1;i<=3;i++){
            if(i<=N){
                first.add(i);
            }
        }
        tsList.add(first);
        
        while(tsList.size() > index){
            List<Integer> ts = new ArrayList<>();
            for (int val : tsList.get(index)) {
                if(val==N){
                    answer++;
                }
                else{
                    for(int i=1;i<=3;i++){
                        int res = val + i;
                        if(res < N){
                            ts.add(res);
                        }
                        else if(res==N){
                            answer++;
                        }
                    }
                }
            }
            if(!ts.isEmpty()){
                tsList.add(ts);
            }
            index++;
        }
        return answer;
    }
}
