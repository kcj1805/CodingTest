import java.io.*;
import java.util.*;

public class Program4 {
    static int max=0;
    static int ApeachScore=0;
    static int[] ArrowList = new int[11];
    static int[] Answer = new int[11];
    public static void main(String[] args) throws IOException
    {
        int n = 5;
        int[] info={2,1,1,1,0,0,0,0,0,0,0};
        //n = 9;
        //int[] info={0,0,1,2,0,1,1,1,1,1,1};
        solution(n, info);
    }
    public static int[] solution(int n, int[] info) {

        for(int i=10;i>=0;i--){
            if(info[10-i]>0){
                ApeachScore += i;
            }
        }
        Calc(n, info, 0, 11);

        return Answer;
    }
    public static void Calc(int n, int[] info, int score, int point){

        if(point == 0 || n==0){
            int dis = score - ApeachScore;
            if(dis>max){
                max = dis;
                ApeachScore += point;
                for(int i=0;i<Answer.length;i++){
                    Answer[i] = ArrowList[i];
                    
                    System.out.print(Answer[i]+" ");
                }
                System.out.println(": "+score+" "+ApeachScore);
                ApeachScore -= point;
            }
            return;
        }

        int Arrowcnt = info[11-point]+1;

        score += point-1;
        ArrowList[11-point]=Arrowcnt;
        ApeachScore -= point-1;
        n -= Arrowcnt;
        if(n>=0){
            Calc(n,info, score, point-1);
        }
        

        score -= point-1;
        ArrowList[11-point]=0;
        ApeachScore += point-1;
        n += Arrowcnt;

        Calc(n,info, score, point-1);
        
    }
}
