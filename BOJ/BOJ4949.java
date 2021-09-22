import java.io.*;
import java.util.*;

public class BOJ4949 {
    //균형잡힌 세상
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Stack<String> st = new Stack<>();
        while(true){
            String input = br.readLine();
            if(input.equals(".")){
                break;
            }
            String[] inputArr = input.replaceAll("[^\\(\\[\\]\\)]","").split("");

            for(int j=0;j<inputArr.length;j++){
                if(inputArr[j].length() != 0){
                    String tmp = inputArr[j];
                    if(tmp.equals("(") || tmp.equals("[")){
                        st.push(tmp);
                    }
                    else{
                        if(st.isEmpty()){
                            st.push(tmp);
                            break;
                        }
                        else{
                            if(tmp.equals(")")){
                                if(st.peek().equals("(")){
                                    st.pop();
                                }
                                else{
                                    break;
                                }
                            }
                            else if(tmp.equals("]")){
                                if(st.peek().equals("[")){
                                    st.pop();
                                }
                                else{
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if(!st.isEmpty()){
                sb.append("no\n");
            }
            else{
                sb.append("yes\n");
            }
            st.clear();
        }
        wr.write(sb.toString());
        wr.flush();
        wr.close();
        br.close();
    }
}

