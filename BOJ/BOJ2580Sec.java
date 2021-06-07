import java.io.*;
import java.util.*;

public class BOJ2580Sec {
    //스도쿠
    static int[][] sudoku;
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        sudoku = new int[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                sudoku[i][j] = sc.nextInt();
            }
        }
        Solution(0,0);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                sb.append(sudoku[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
        
        sc.close();
    }
    public static boolean Solution(int y, int x)
    {
        for(int a=0;a<9;a++){
            for(int b=0;b<9;b++){
                if(sudoku[a][b]==0){
                    for(int z=1;z<=9;z++){
                        if(Check(a, b, z)){
                            sudoku[a][b] = z;
                            if(Solution(a, b)){
                                return true;
                            }
                            sudoku[a][b] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean Check(int a, int b, int z){
        for(int i=a/3*3;i<a/3*3+3;i++){
            for(int j=b/3*3;j<b/3*3+3;j++){
               if(sudoku[i][j]==z) return false;
            }
        }
        for(int i=0;i<9;i++){
            if(sudoku[a][i]==z) return false;
            if(sudoku[i][b]==z) return false;
        }
        return true;
    }
}
