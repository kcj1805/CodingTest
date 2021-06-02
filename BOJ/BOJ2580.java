import java.io.*;
import java.util.*;

public class BOJ2580 {
    //스도쿠
    static int[][] sudoku;
    static List<Integer> Numpoll;
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        sudoku = new int[9][9];
        Numpoll = new ArrayList<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                sudoku[i][j] = sc.nextInt();
            }
            Numpoll.add(i+1);
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
                    List<Integer> temppoll = InitList();
                    for(int i=a/3*3;i<a/3*3+3;i++){
                        for(int j=b/3*3;j<b/3*3+3;j++){
                            temppoll.remove((Object)sudoku[i][j]);
                        }
                    }
                    for(int i=0;i<9;i++){
                        temppoll.remove((Object)sudoku[a][i]);
                        temppoll.remove((Object)sudoku[i][b]);
                    }
                    if(temppoll.isEmpty()){
                        return false;
                    }
                    else{
                        for (int val : temppoll) {
                            sudoku[a][b] = val;
                            if(Solution(a, b)){
                                return true;
                            }
                            sudoku[a][b] = 0;
                        }
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static List<Integer> InitList(){
        List<Integer> temp = new ArrayList<>();
        for (int val : Numpoll) {
            temp.add(val);
        }
        return temp;
    }
}
