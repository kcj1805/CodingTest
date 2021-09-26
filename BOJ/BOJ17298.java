import java.io.*;
import java.util.*;

public class BOJ17298 {
    //오큰수
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        int N = sc.nextInt();
        int[][] AnsArr = new int[N][2];
        for(int i=0;i<N;i++){
            AnsArr[i][0]=sc.nextInt();
        }
        AnsArr[N-1][1]=-1;

        for(int i=N-1;i>=0;i--){
            if(st.empty()){
                st.push(AnsArr[i][0]);
            }
            else{
                if(st.peek()<=AnsArr[i][0]){
                    while(!st.empty() && st.peek()<=AnsArr[i][0]){
                        st.pop();
                    }
                }
                if(st.empty()){
                    AnsArr[i][1]=-1;
                }
                else{
                    AnsArr[i][1]=st.peek();
                }
                st.push(AnsArr[i][0]);
            }
        }

        for(int i=0;i<N;i++){
            sb.append(AnsArr[i][1] + " ");
        }
        System.out.println(sb.toString());
        sc.close();
    }
}

