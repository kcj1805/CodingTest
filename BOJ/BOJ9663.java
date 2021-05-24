import java.io.*;
import java.util.*;

public class BOJ9663 {
    static int answer=0;
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] Chess = new int[N][N];
        Solution(Chess, N, 0, 0, 0);
        System.out.println(answer);
        sc.close();
    }
    public static boolean Solution(int[][] Chess, int N, int x, int y, int cnt)
    {
        int[][] ChessCopy = new int[N][N];
        Chess[x][y]=2;
        cnt++;
        if(cnt==N){
            answer++;
            return false;
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!(i==x && j==y)){
                    if(i==x || j==y){
                        if(Chess[i][j]!=2){
                            Chess[i][j]=1;
                        }
                        else{
                            return false;
                        }
                    }
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(Chess[i][j]==0){
                    ArrCopy(ChessCopy,Chess);
                    Solution(ChessCopy, N, i, j, cnt);
                    //ArrCopy(Chess,ChessCopy);
                    cnt--;
                    Chess[i][j]=0;
                }
            }
        }
        return true;
    }
    public static void ArrCopy(int[][] des, int[][] sour){
        for(int i=0;i<des.length;i++){
            for(int j=0;j<des.length;j++){
                des[i][j]=sour[i][j];
            }
        }
    }
}
