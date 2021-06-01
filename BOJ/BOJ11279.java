import java.io.*;
import java.util.*;

public class BOJ11279 {
    //최대 힙
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<N;i++){
            int x = sc.nextInt();
            if(x==0){
                if(pq.isEmpty()){
                    sb.append(0+"\n");
                }
                else{
                    sb.append(pq.poll()+"\n");
                }
            }
            else{
                pq.add(x);
            }
        }
        System.out.println(sb.toString());
        sc.close();
    }
}
