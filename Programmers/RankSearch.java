import java.io.*;
import java.util.*;

public class RankSearch {
    //순위검색
    static class Volunteer{
        String Lan;
        String Group;
        String Career;
        String Food;
        int Score;
    }
    public static void main(String[] args) throws IOException
    {
        String[] info = {"java backend junior pizza 150"        ,
                         "python frontend senior chicken 210"   ,
                         "python frontend senior chicken 150"   ,
                         "cpp backend senior pizza 260"         ,
                         "java backend junior chicken 80"       ,
                         "python backend senior chicken 50"     };

        String[] query = {"java and backend and junior and pizza 100"       ,
                          "python and frontend and senior and chicken 200"  ,
                          "cpp and - and senior and pizza 250"              ,
                          "- and backend and senior and - 150"              ,
                          "- and - and - and chicken 100"                   ,
                          "- and - and - and - 150"                         };

        solution(info, query);
    }
    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        List<Volunteer> list = new ArrayList<>();
        for(int i=0;i<info.length;i++){
            String[] infostr = info[i].split(" ");
            Volunteer vol = new Volunteer();
            vol.Lan = infostr[0];
            vol.Group = infostr[1];
            vol.Career = infostr[2];
            vol.Food = infostr[3];
            vol.Score = Integer.parseInt(infostr[4]);
            list.add(vol);
        }

        for(int i=0;i<query.length;i++){
            answer[i] = list.size();
            String[] querystrArr = query[i].split("\\s*and\\s*");
            int Score = Integer.parseInt(querystrArr[3].split(" ")[1]);
            querystrArr[3] = querystrArr[3].split(" ")[0];
            
            for (Volunteer volunteer : list) {
                if(!querystrArr[0].equals("-") && !querystrArr[0].equals(volunteer.Lan)){
                    answer[i]--;
                    continue;
                }
                if(!querystrArr[1].equals("-") && !querystrArr[1].equals(volunteer.Group)){
                    answer[i]--;
                    continue;
                }
                if(!querystrArr[2].equals("-") && !querystrArr[2].equals(volunteer.Career)){
                    answer[i]--;
                    continue;
                }
                if(!querystrArr[3].equals("-") && !querystrArr[3].equals(volunteer.Food)){
                    answer[i]--;
                    continue;
                }
                if(Score>volunteer.Score){
                    answer[i]--;
                    continue;
                }
            }
        }

        return answer;
    }
}
