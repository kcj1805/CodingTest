import java.io.*;
import java.util.*;

public class BOJ9663 {
    static int answer=0;
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] Chess = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                Solution(Chess, N, i, j, 0);
                Chess = new int[N][N];
            }
        }
        System.out.println(answer);
        sc.close();
    }
    public static void Solution(int[][] Chess, int N, int x, int y, int cnt)
    {
        Chess[x][y]=2;
        cnt++;
        if(cnt==N){
            answer++;
            return;
        }
        if(!BlockChess(Chess, N, x, y)){
            return;
        }
        int[][] ChessCopy = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(Chess[i][j]==0){
                    ArrCopy(ChessCopy,Chess);
                    Solution(ChessCopy, N, i, j, cnt);
                }
            }
        }
    }
    public static void ArrCopy(int[][] des, int[][] sour){
        for(int i=0;i<des.length;i++){
            for(int j=0;j<des.length;j++){
                des[i][j]=sour[i][j];
            }
        }
    }
    public static boolean BlockChess(int[][] Chess, int N, int x, int y){
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
        int i=1;
        while(true){
            //좌상
            if(x-i>=0&&y-i>=0){
                if(Chess[x-i][y-i]==2){
                    return false;
                }
                Chess[x-i][y-i]=1;
            }
            //좌하
            if(x+i<N&&y-i>=0){
                if(Chess[x+i][y-i]==2){
                    return false;
                }
                Chess[x+i][y-i]=1;
            }
            //우상
            if(x-i>=0&&y+i<N){
                if(Chess[x-i][y+i]==2){
                    return false;
                }
                Chess[x-i][y+i]=1;
            }
            //우하
            if(x+i<N&&y+i<N){
                if(Chess[x+i][y+i]==2){
                    return false;
                }
                Chess[x+i][y+i]=1;
            }
            i++;
            if(i==N){
                return true;
            }
        }
    }
}
