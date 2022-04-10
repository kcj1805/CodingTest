import java.io.*;
import java.util.*;

public class Lotto {
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
        
        int [] lottos = {44, 1, 0, 0, 31, 25};
        int [] win_nums = {31, 10, 45, 1, 6, 19};
        solution(lottos, win_nums);
    }
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        TreeSet<Integer> win = new TreeSet<>();
        for (int val : win_nums) {
            win.add(val);
        }
        int hitcnt = 0;
        int losscnt = 0;
        for (int val : lottos) {
            if(win.contains(val)){
                win.remove(val);
                hitcnt++;
            }
            if(val == 0){
                losscnt++;
            }
        }

        int calc = 7-hitcnt;
        answer[1] = calc >= 7 ? 6 : calc;
        if(win.size() >= losscnt){
            calc = 7-(hitcnt+losscnt);
            answer[0] = calc >= 7 ? 6 : calc;
        }
        else if(win.size() < losscnt){
            calc = 7-(hitcnt+win.size());
            answer[0] = calc >= 7 ? 6 : calc;
        }

        return answer;
    }
}
