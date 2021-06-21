import java.io.*;
import java.util.*;

public class BOJ2579 {
    //계단 오르기
    /*
    10 - 10
    20 - 20 / 30
    15 - 25 / 35
    25 - 45 55 / 50
    10 - 35 45 / 55 65
    20 - 65 75 70 / 55 65
    ------------------------------------
    30 - 65 75 85 95 / 95 105 100
    10 - 85 80 65 / 75 105
    10 - 75 105 115 110 / 95 90 70
    10 - 95 90 70 85 115 / 75 115 120 120
    */
    static int[] stair;
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        stair = new int[N];
        for(int i=0;i<N;i++){
            stair[i] = sc.nextInt();
        }
        System.out.println(Solution(N));
        sc.close();
    }
    public static int Solution(int N)
    {
        int A = 0;
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        
        for(int i=0;i<N;i++){
            List<Integer> now = new ArrayList<>();
            if(i==0){
                A = 1;
            }
            else if(i==1){
                B.add(stair[1]);
                B.add(stair[0]+stair[1]);
            }
            else if(i==2){
                C.add(stair[0]+stair[2]);
                C.add(stair[1]+stair[2]);
            }
            else{
                for (int val : B) {
                    now.add(stair[i]+val);
                }
                for(int j=0;j<A;j++){
                    now.add(stair[i]+C.get(j));
                }
                A=B.size();
                B=C;
                C=now;
            }
        }
        
        return Collections.max(C);
    }
}
