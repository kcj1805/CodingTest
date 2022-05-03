import java.io.*;
import java.util.*;

public class MoreSpicy {
    public static void main(String[] args) throws IOException
    {
        int[] scoville = {12, 2, 3, 9, 10, 2};
        solution(scoville, 7);
    }
    public static int solution(int[] scoville, int K) {
        int answer=0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : scoville) {
            pq.add(val);
        }

        while(pq.peek()<K){
            int A = pq.poll();
            int B = pq.poll();

            int val = A + (B * 2);
            pq.add(val);
            answer++;
        }
        
        return answer;
    }
}
