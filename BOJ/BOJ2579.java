import java.io.*;
import java.util.*;

public class BOJ2579 {
    //계단 오르기
    /*
    10 - 10
    20 - 30
    15 - 25
    25 - 55 /50
    10 - 35 /65
    20 - 75 70 /55
    30 - 65 95 /105 100
    10 - 85 80 65 /75 105
    10 - 75 105 115 110/95 90 70
    10 - 95 90 70 85 115 / 75 115 120 120
    */
    static int[] stair;
    static List<List<Integer>> Case;
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        stair = new int[N];
        Case = new ArrayList<>();
        for(int i=0;i<N;i++){
            stair[i] = sc.nextInt();
        }
        System.out.println(Solution(N));
        sc.close();
    }
    public static int Solution(int N)
    {
        for(int i=0;i<N;i++){
            List<Integer> now = new ArrayList<>();
            if(i==0){
                now.add(stair[0]);
            }
            else if(i==1){
                now.add(stair[0]+stair[1]);
            }
            else if(i==2){
                now.add(stair[0]+stair[2]);
            }
            else{
                for (Integer val : Case.get(i-2)) {
                    now.add(stair[i]+val);
                }
                for(int j=0;j<Case.get(i-3).size();j++){
                    now.add(stair[i]+Case.get(i-1).get(j));
                }
            }
            Case.add(now);
        }
        Collections.sort(Case.get(Case.size()-1), Collections.reverseOrder());
        return Case.get(Case.size()-1).get(0);
    }
}
