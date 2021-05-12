import java.io.*;
import java.util.*;

public class BOJ1927 {
    //최소 힙
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int input = Integer.parseInt(br.readLine());

        int[] intArr = new int[input];

        for(int i=0;i<intArr.length;i++){
            intArr[i] = Integer.parseInt(br.readLine());
        }
        List<Integer> answer = Solution(intArr);
        for (Integer integer : answer) {
            wr.write(integer + "\n");
        }
        
        wr.flush();
        wr.close();
        br.close();
    }
    public static List<Integer> Solution(int[] input)
    {
        PriorityQueue<Integer> pg = new PriorityQueue<>();
        List<Integer> answer = new ArrayList<>();

        for(int i=0;i<input.length;i++){
            if(input[i] != 0){
                //자연수면 큐에 push
                pg.add(input[i]);
            }
            else if(!pg.isEmpty()){
                //0이고 큐가 비어있지않으면 최소값 poll
                answer.add(pg.poll());
            }
            else{
                //0이고 큐가 비어있으면 0 출력
                answer.add(0);
            }
        }

        return answer;
    }
}
