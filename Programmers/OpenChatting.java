import java.io.*;
import java.util.*;

public class OpenChatting {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        wr.write("");
        wr.flush();
        wr.close();
        br.close();

        Scanner sc = new Scanner(System.in);
        sc.close();

        String[] a = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        solution(a);
    }
    public static String[] solution(String[] record) {
        List<String> answerList = new LinkedList<>();
        Map<String,String> Userpool = new HashMap<>();
        List<History> History = new LinkedList<>();

        for (String string : record) {
            String[] temp = string.split(" ");
            switch(temp[0]){
                case "Enter":{
                    History.add(new History((byte)0, temp[1]));
                    Userpool.put(temp[1],temp[2]);
                    break;
                }
                case "Leave":{
                    History.add(new History((byte)1, temp[1]));
                    break;
                }
                case "Change":{
                    Userpool.put(temp[1],temp[2]);
                    break;
                }
            }
        }

        for (History history : History) {
            if(history.flag==0){
                answerList.add(Userpool.get(history.id)+"님이 들어왔습니다.");
            }
            else{
                answerList.add(Userpool.get(history.id)+"님이 나갔습니다.");
            }
        }

        return answerList.toArray(new String[0]);
    }
    static class History{
        byte flag;
        String id;

        History(byte f, String i){
            flag = f;
            id = i;
        }
    }
}
