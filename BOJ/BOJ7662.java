import java.io.*;
import java.util.*;

public class BOJ7662 {
    //이중 우선순위 큐
    //1
    //7
    //I 5
    //I 3
    //I 7
    //I 6
    //D 1
    //D -1
    //D -1
    //
    //정답 6 6
    //
    //1
    //3
    //I 1
    //D 1
    //I 2
    //답 : 2 2
    static int size=0;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> rpq = new PriorityQueue<>(Collections.reverseOrder());

        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            size=0;
            pq.clear();
            rpq.clear();
            int K = Integer.parseInt(br.readLine());
            for(int j=0;j<K;j++){
                Solution(pq, rpq, br.readLine());
                if(size==0){
                    pq.clear();
                    rpq.clear();
                }
            }
            if(size==0){
                sb.append("EMPTY\n");
            }
            else{
                sb.append(rpq.peek() + " " + pq.peek() + "\n");
            }
        }

        wr.write(sb.toString());
        wr.flush();
        wr.close();
        br.close();

    }
    public static void Solution(PriorityQueue<Integer> pq, PriorityQueue<Integer> rpq, String str)
    {
        StringTokenizer st = new StringTokenizer(str);

        String command = st.nextToken();
        int val = Integer.parseInt(st.nextToken());
        switch(command){
            case "I":{
                pq.add(val);
                rpq.add(val);
                size++;
                break;
            }
            case "D":{
                if(size > 0){
                    if(val == 1){
                        if(!rpq.isEmpty()){
                            rpq.poll();
                            size--;
                        }
                    }
                    else if(val == -1){
                        if(!pq.isEmpty()){
                            pq.poll();
                            size--;
                        }
                    }
                }
                break;
            }
        }
    }
}
