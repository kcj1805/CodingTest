import java.io.*;
import java.util.*;

public class BOJ5430 {
    //AC
    static Deque<Integer> dq = new LinkedList<>();
    static boolean First = true;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            String[] P = br.readLine().split("");
            int N = Integer.parseInt(br.readLine());
            String[] strarr = br.readLine().replaceAll("[\\[\\]]", "").split(",");


            for (int j=0;j<N;j++) {
                dq.addLast(Integer.parseInt(strarr[j]));
            }
    
            boolean error = false;
            First = true;
            for (String func : P) {
                if(!ExecFunc(func)){
                    error=true;
                    break;
                }
            }
    
            if(error){
                sb.append("error\n");
            }
            else{
                sb.append("[");
                if(!dq.isEmpty()){
                    while(!dq.isEmpty()){
                        if(First){
                            sb.append(dq.pollFirst()+",");
                        }
                        else{
                            sb.append(dq.pollLast()+",");
                        }
                    }
                    sb.deleteCharAt(sb.length()-1);
                }
                sb.append("]\n");
            }
            dq.clear();
        }

        wr.write(sb.toString());
        wr.flush();
        wr.close();
        br.close();
    }

    static boolean ExecFunc(String func){
        switch(func){
            case "R":{
                First = !First;
                break;
            }
            case "D":{
                if(dq.isEmpty()){
                    return false;
                }
                else{
                    if(First){
                        dq.pollFirst();
                    }
                    else{
                        dq.pollLast();
                    }
                    break;
                }
            }
        }
        return true;
    }
}
