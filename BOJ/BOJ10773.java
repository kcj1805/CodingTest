import java.io.*;
import java.util.*;

public class BOJ10773 {
    //제로
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st= new Stack<>();
        int K = sc.nextInt();

        for(int i=0;i<K;i++){
            int input = sc.nextInt();
            if(input==0){
                st.pop();
            }
            else{
                st.push(input);
            }
        }
        int answer=0;
        while(!st.isEmpty()){
            answer += st.pop();
        }
        System.out.println(answer);
        sc.close();
    }
}
