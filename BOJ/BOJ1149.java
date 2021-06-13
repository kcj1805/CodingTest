import java.io.*;
import java.util.*;

public class BOJ1149 {
    static int[][] town;
    static int N;
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        town = new int[N][3];
        for(int i=0;i<N;i++){
            for(int j=0;j<3;j++){
                town[i][j] = sc.nextInt();
            }
        }
        System.out.println(Solution(0, 4));
        sc.close();
    }
    public static int Solution(int index, int except)
    {
        int min = Integer.MAX_VALUE;
        int tmp = 0;
        int select=0;
        for(int i=0;i<3;i++){
            if(i != except){
                tmp = min;
                min = Math.min(min,town[index][i]);
                if(tmp != min){
                    select = i;
                }
            }
        }
        index++;
        if(index == N){
            return min;
        }
        for(int i=0;i<3;i++){
            town[index][i] += min;
        }
        
        return Solution(index, select);
    }
}
