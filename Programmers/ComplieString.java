import java.io.*;

public class ComplieString {
    public static void main(String[] args) throws IOException
    {
        String s = "aabbaccc"; //7
        s = "ababcdcdababcdcd"; //9
        s = "abcabcdede"; //8
        s = "abcabcabcabcdededededede"; //14
        s = "xababcdcdababcdcd"; //17
        solution(s);
    }
    public static int solution(String s) {
        int answer = Integer.MAX_VALUE;
        for(int i=1;i<=s.length();i++){
            answer = Integer.min(answer, ComplieWork(s, i));
        }
        return answer;
    }
    public static int ComplieWork(String s, int i){
        int beginIndex = 0;
        int endIndex = i;
        int cnt=0;
        StringBuilder newString = new StringBuilder();
        String Word=s.substring(beginIndex, endIndex);
        while(beginIndex<=s.length()){
            endIndex = beginIndex+i;
            if(endIndex>s.length()){
                endIndex = s.length();
            }
            if(s.substring(beginIndex, endIndex).equals(Word)){
                beginIndex += i;
                cnt++;
            }
            else{
                if(cnt == 0){
                    newString.append(s.substring(beginIndex, endIndex));
                    beginIndex++;
                }
                else if(cnt == 1){
                    newString.append(Word);
                }
                else{
                    newString.append(cnt);
                    newString.append(Word);
                }
                cnt=0;
                if(beginIndex == s.length()){
                    break;
                }
                Word = s.substring(beginIndex, endIndex);
                if(beginIndex+i>endIndex){
                    newString.append(Word);
                    break;
                }
            }
        }
        return newString.length();
    }
}
