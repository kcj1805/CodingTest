import java.io.*;
import java.util.*;

public class BOJ10866 {
    //덱
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new LinkedList<Integer>();
        for(int i=0;i<N;i++){
            String[] strArr = br.readLine().split(" ");

            switch(strArr[0]){
                case "push_back":{
                    dq.addLast(Integer.parseInt(strArr[1]));
                    break;
                }
                case "push_front":{
                    dq.addFirst(Integer.parseInt(strArr[1]));
                    break;
                }
                case "pop_back":{
                    if(dq.isEmpty()){
                        sb.append("-1\n");
                    }
                    else{
                        sb.append(dq.pollLast()+"\n");
                    }
                    break;
                }
                case "pop_front":{
                    if(dq.isEmpty()){
                        sb.append("-1\n");
                    }
                    else{
                        sb.append(dq.pollFirst()+"\n");
                    }
                    break;
                }
                case "size":{
                    sb.append(dq.size()+"\n");
                    break;
                }
                case "empty":{
                    if(dq.isEmpty()){
                        sb.append("1\n");
                    }
                    else{
                        sb.append("0\n");
                    }
                    break;
                }
                case "front":{
                    if(dq.isEmpty()){
                        sb.append("-1\n");
                    }
                    else{
                        sb.append(dq.peekFirst()+"\n");
                    }
                    break;
                }
                case "back":{
                    if(dq.isEmpty()){
                        sb.append("-1\n");
                    }
                    else{
                        sb.append(dq.peekLast()+"\n");
                    }
                    break;
                }
            }
        }
        wr.write(sb.toString());
        wr.flush();
        wr.close();
        br.close();
    }
}
