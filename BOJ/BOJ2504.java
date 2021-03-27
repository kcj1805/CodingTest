import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


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
                case "(":
                {
                    rightstr++;
                    st.push(chr);
                    break;
                }
                case ")":
                {
                    rightstr--;
                    if(!st.isEmpty())
                    {
                        String top = st.peek();
                        if(top.equals("("))
                        {
                            st.pop();
                            st.push("2");
                        }
                        else if(top.equals("[") || top.equals(")"))
                        {
                            return 0;
                        }
                        else
                        {
                            int val = 0;
                        
                            while(!st.isEmpty()) {
                                
                                if(st.peek().equals("[")) 
                                {
                                    return 0;
                                }
                                else if(st.peek().equals("(")) 
                                {
                                    st.pop();
                                    val *=2;
                                    st.push(String.valueOf(val));
                                    break;
                                }
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
                        if(top.equals("["))
                        {
                            st.pop();
                            st.push("3");
                        }
                        else if(top.equals("[") || top.equals(")"))
                        {
                            return 0;
                        }
                        else
                        {
                            int val = 0;
                        
                            while(!st.isEmpty()) {

                                if(st.peek().equals("(")) 
                                {
                                    return 0;
                                }
                                else if(st.peek().equals("[")) 
                                {
                                    st.pop();
                                    val *=3;
                                    st.push(String.valueOf(val));
                                    break;
                                }
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
