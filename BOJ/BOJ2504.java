import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//괄호의 값
public class BOJ2504 
{
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(calc(str));
    }

    public static int calc(String str)
    {
        Stack<String> st = new Stack<String>();

        char[] charArr = str.toCharArray();
        int res = 0;
        int rightstr = 0;
        for(int i=0;i<charArr.length;i++)
        {
            String chr = Character.toString(charArr[i]);
            switch(chr)
            {
                // ( 일경우 
                case "(":
                {
                    rightstr++;
                    st.push(chr);
                    break;
                }
                // ) 일경우 
                case ")":
                {
                    rightstr--;
                    if(!st.isEmpty())
                    {
                        //top의 값을 확인하여 짝이 맞는 경우 pop후 2 push
                        String top = st.peek();
                        if(top.equals("("))
                        {
                            st.pop();
                            st.push("2");
                        }
                        // [ 또는 ) 일 경우 짝이 맞지 않는 경우 이므로 0 리턴
                        else if(top.equals("[") || top.equals(")"))
                        {
                            return 0;
                        }
                        else
                        {
                            int val = 0;
                            // ( 가 나올때까지 pop
                            while(!st.isEmpty()) {
                                // [ 일 경우 오류로 0 리턴
                                if(st.peek().equals("[")) 
                                {
                                    return 0;
                                }
                                // ( 일 경우 값에 x2 후 push
                                else if(st.peek().equals("(")) 
                                {
                                    st.pop();
                                    val *=2;
                                    st.push(String.valueOf(val));
                                    break;
                                }
                                // ( 가 나올때까지 중간의 정수를 값에 모두 더함
                                else
                                {
                                    val += Integer.parseInt(st.pop());
                                }
                            }
                        }
                    }

                    break;
                }
                case "[":
                {
                    rightstr++;
                    st.push(chr);
                    break;
                }
                case "]":
                {
                    rightstr--;
                    if(!st.isEmpty())
                    {
                        String top = st.peek();
                        //top의 값을 확인하여 짝이 맞는 경우 pop후 3 push
                        if(top.equals("["))
                        {
                            st.pop();
                            st.push("3");
                        }
                        // ( 또는 ] 일 경우 짝이 맞지 않는 경우 이므로 0 리턴
                        else if(top.equals("(") || top.equals("]"))
                        {
                            return 0;
                        }
                        else
                        {
                            int val = 0;
                            // [ 가 나올때까지 pop
                            while(!st.isEmpty()) {
                                // ( 일 경우 오류로 0 리턴
                                if(st.peek().equals("(")) 
                                {
                                    return 0;
                                }
                                // [ 일 경우 값에 x2 후 push
                                else if(st.peek().equals("[")) 
                                {
                                    st.pop();
                                    val *=3;
                                    st.push(String.valueOf(val));
                                    break;
                                }
                                // [ 가 나올때까지 중간의 정수를 값에 모두 더함
                                else
                                {
                                    val += Integer.parseInt(st.pop());
                                }
                            }
                        }
                    }
                    break;
                }
            }
        }
        if(rightstr!=0)
        {
            return 0;
        }
        while(!st.isEmpty()) {
            res += Integer.parseInt(st.pop());
        }
        return res;
    }
}
