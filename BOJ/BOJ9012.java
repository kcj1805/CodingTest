import java.io.*;
import java.util.*;

public class BOJ9012 {
    //괄호
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<String> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            String[] inputArr = br.readLine().split("");

            for(int j=0;j<inputArr.length;j++){
                String tmp = inputArr[j];
                if(tmp.equals("(")){
                    st.push(tmp);
                }
                else{
                    if(st.isEmpty()){
                        st.push(tmp);
                        break;
                    }
                    else if(st.peek().equals("(")){
                        st.pop();
                    }
                }
            }
            if(!st.isEmpty()){
                sb.append("NO");
            }
            else{
                sb.append("YES");
            }
            sb.append("\n");
            st.clear();
        }

        wr.write(sb.toString());
        wr.flush();
        wr.close();
        br.close();
    }
}

