import java.io.*;
import java.util.*;

public class BOJ10844 {
    //쉬운 계단 수
    static int[][] stair;
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        stair = new int[N][9];
        System.out.println(Solution(N)%1000000000);
        sc.close();
    }
    public static Long Solution(int N)
    {
        Long answer = Long.valueOf(0);
        for(int i=0;i<N;i++){
            for(int j=0;j<9;j++){
                if(i==0){
                    stair[i][j] = 1;
                }
                else if(j==0){
                    if(i==1){
                        stair[i][j] = 2;
                    }
                    else{
                        stair[i][j] = (stair[i-2][j]+stair[i-1][j+1])%1000000000;
                    }
                }
                else if(j==8){
                    stair[i][j] = stair[i-1][j-1]%1000000000;
                }
                else{
                    stair[i][j] = (stair[i-1][j-1]+stair[i-1][j+1])%1000000000;
                }
            }
            if(i==N-1){
                for(int j=0;j<9;j++){
                    answer += stair[i][j]%1000000000;
                }
            }
        }
        return answer;
    }
}
