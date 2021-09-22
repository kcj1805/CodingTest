import java.io.*;
import java.util.*;

public class BOJ1874 {
    //스택 수열
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int Num = 1;
        try{
            for (int i = 0; i < N; i++) {
                int input = sc.nextInt();
                int peek = 0;
                if (st.empty()) {
                    peek = 0;
                } else {
                    peek = st.peek();
                }
    
                if (input > peek) {
                    for (; Num <= input;) {
                        st.push(Num++);
                        sb.append("+\n");
                    }
                    st.pop();
                    sb.append("-\n");
                } else {
                    while (true) {
                        if (st.peek() == input) {
                            st.pop();
                            sb.append("-\n");
                            break;
                        }
                        st.pop();
                        sb.append("-\n");
                    }
                }
            }
            System.out.println(sb.toString());
        }
        catch(Exception ex){
            System.out.println("NO");
        }
        finally{
            sc.close();
        }
    }
}
