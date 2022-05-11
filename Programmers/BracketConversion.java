import java.io.*;
import java.util.*;

public class BracketConversion {
    public static void main(String[] args) throws IOException
    {
        String ret = solution("()))((()");
        return;
    }
    public static String solution(String p){
        int cnt=0;
        int index=0;
        StringBuilder retstr = new StringBuilder();
        if(Check(p)){
            return p;
        }
        else if(!p.isEmpty()){
            for(int i=0;i<p.length();i++){
                if(p.charAt(i) == '('){
                    cnt++;
                }
                else{
                    cnt--;
                }
    
                if(cnt==0){
                    index = i+1;
                    break;
                }
            }
            String u = p.substring(0,index);
            String v = p.substring(index);

            if(Check(u)){
                retstr.append(u);
                retstr.append(solution(v));
            }
            else{
                retstr.append('(');
                retstr.append(solution(v));
                retstr.append(')');
                String tmp = u.substring(1,u.length()-1);
                tmp = tmp.replace('(', ';');
                tmp = tmp.replace(')', '(');
                tmp = tmp.replace(';', ')');
                retstr.append(tmp);
            }
        }
        return retstr.toString();
    }

    public static boolean Check(String str){
        Queue<Character> queue = new LinkedList<>();

        for(int i=0;i<str.length();i++){
            char chr = str.charAt(i);
            if(str.charAt(i)=='('){
                queue.add(chr);
            }
            else if(queue.isEmpty()){
                return false;
            }
            else{
                queue.remove();
            }
        }

        if(queue.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}
