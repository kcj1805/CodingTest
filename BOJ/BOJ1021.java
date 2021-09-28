import java.io.*;
import java.util.*;

public class BOJ1021 {
    //회전하는 큐
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Deque<Integer> dq = new LinkedList<>();
        Deque<Integer> dq1 = new LinkedList<>();
        int answer=0;
        for(int i=0;i<N;i++){
            dq.add(i+1);
            dq1.add(i+1);
        }

        for(int i=0;i<M;i++){
            int input = sc.nextInt();
            int cnt=0;
            while(input!=dq.peekFirst()){
                dq.addLast(dq.pollFirst());
                cnt++;
            }
            int cnt1=0;
            while(input!=dq1.peekFirst()){
                dq1.addFirst(dq1.pollLast());
                cnt1++;
            }
            
            if(cnt>cnt1){
                answer += cnt1;
            }
            else{
                answer += cnt;
            }
            dq.pop();
            dq1.pop();
        }

        System.out.println(answer);
        sc.close();
    }
}
