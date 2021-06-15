import java.io.*;
import java.util.*;

public class BOJ1932 {
    //정수 삼각형
    static int[][] triangle;
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        triangle = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<i+1;j++){
                triangle[i][j] = sc.nextInt();
            }
        }
        Solution(N);
        int answer = 0;
        for(int i=0;i<N;i++){
            answer = Math.max(answer,triangle[N-1][i]);
        }
        System.out.println(answer);
        sc.close();
    }
    public static void Solution(int N)
    {
        for(int i=1;i<N;i++){
            for(int j=0;j<i+1;j++){
                int val = 0;
                if(j==0){
                    int tmp = triangle[i-1][j] + triangle[i][j];
                    val = Math.max(val,tmp);
                }
                else if(j==i){
                    int tmp = triangle[i-1][j-1] + triangle[i][j];
                    val = Math.max(val,tmp);
                }
                else{
                    int tmp = triangle[i-1][j] + triangle[i][j];
                    int tmp2 = triangle[i-1][j-1] + triangle[i][j];
                    tmp = Math.max(tmp,tmp2);
                    val = Math.max(val,tmp);
                }
                triangle[i][j] = val;
            }
        }
    }
}
