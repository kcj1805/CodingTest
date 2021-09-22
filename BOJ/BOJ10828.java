import java.io.*;
import java.util.*;

public class BOJ10828 {
    //스택
    public static void main(String[] args) throws IOException {
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            boolean IsPush = false;
            String[] input = br.readLine().split(" ");
            switch(input[0]){
                case "push":{
                    st.push(Integer.parseInt(input[1]));
                    IsPush = true;
                    break;
                }
                case "pop":{
                    if(st.isEmpty()){
                        sb.append(-1);
                    }
                    else{
                        sb.append(st.pop());
                    }
                    break;
                }
                case "size":{
                    sb.append(st.size());
                    break;
                }
                case "empty":{
                    if(st.isEmpty()){
                        sb.append(1);
                    }
                    else{
                        sb.append(0);
                    }
                    break;
                }
                case "top":{
                    if(st.isEmpty()){
                        sb.append(-1);
                    }
                    else{
                        sb.append(st.peek());
                    }
                    break;
                }
            }
            if(!IsPush){
                sb.append("\n");
            }
        }

        wr.write(sb.toString());
        wr.flush();
        wr.close();
        br.close();
    }
}
