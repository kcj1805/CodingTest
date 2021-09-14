import java.io.*;
import java.util.*;

public class Program6 {
    public static void main(String[] args) throws IOException
    {
        int[][] board={{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        int[][] skill={{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
        solution(board, skill);
    }
    public static int solution(int[][] board, int[][] skill) {
        for(int i=0;i<skill.length;i++){

            int a = skill[i][1];
            int c = skill[i][3];

            for( ; a <= c ; a++){
                int b = skill[i][2];
                int d = skill[i][4];
                for( ; b <= d ; b++){
                    //공격
                    if(skill[i][0]==1){
                        board[a][b] -= skill[i][5];
                    }
                    //회복
                    else{
                        board[a][b] += skill[i][5];
                    }
                }
            }
        }

        int answer = 0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]>0){
                    answer++;
                }
            }
        }
        return answer;
    }
}
