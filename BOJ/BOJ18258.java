import java.io.*;
import java.util.*;

public class BOJ18258 {
    //큐 2
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> que = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int last = 0;
        for(int i=0;i<N;i++){
            String[] strArr = br.readLine().split(" ");

            switch(strArr[0]){
                case "push":{
                    que.add(Integer.parseInt(strArr[1]));
                    last = Integer.parseInt(strArr[1]);
                    break;
                }
                case "pop":{
                    if(que.isEmpty()){
                        sb.append("-1\n");
                    }
                    else{
                        sb.append(que.poll()+"\n");
                    }
                    break;
                }
                case "size":{
                    sb.append(que.size()+"\n");
                    break;
                }
                case "empty":{
                    if(que.isEmpty()){
                        sb.append("1\n");
                    }
                    else{
                        sb.append("0\n");
                    }
                    break;
                }
                case "front":{
                    if(que.isEmpty()){
                        sb.append("-1\n");
                    }
                    else{
                        sb.append(que.peek()+"\n");
                    }
                    break;
                }
                case "back":{
                    if(que.isEmpty()){
                        sb.append("-1\n");
                    }
                    else{
                        sb.append(last+"\n");
                    }
                    break;
                }
            }
        }
        wr.write(sb.toString());
        wr.flush();
        br.close();
        wr.close();
    }
}
