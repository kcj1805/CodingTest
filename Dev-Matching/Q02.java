import java.io.*;
import java.util.*;
public class Q02 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        wr.write("");
        wr.flush();
        wr.close();
        br.close();

        Scanner sc = new Scanner(System.in);
        sc.close();

        solution(7,9,4,new String[]{"111100000","000010011","111100011","111110011","111100011","111100010","111100000"});
    }
    public static int solution(int h, int w, int n, String[] board) {
        //int answer = 0;
        int[][] boardArr = new int[h][w];
        for(int i=0;i<h;i++){
            String[] tmpArr = board[i].split("");
            for(int j=0;j<w;j++){
                boardArr[i][j] = Integer.parseInt(tmpArr[j]);
            }
        }
        
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                Calc(n, i, j, 0, 0, boardArr);
            }
        }

        return answer;
    }

    static int answer=0;
    public static boolean Calc(int n, int i, int j, int cnt, int pos, int[][] boardArr)
    {
        if(i<0 || j<0 || i>=boardArr.length || j>=boardArr[0].length){
            if(cnt == n){
                answer++;
                return true;
            }
            return false;
        }
        if(boardArr[i][j]==0){
            if(cnt == n){
                answer++;
                return true;
            }
            return false;
        }
        if(boardArr[i][j]==1){
            cnt++;
            if(cnt > n){
                return false;
            }
        }

        switch(pos){
            case 0:{
                //하
                Calc(n, i+1, j, cnt, 1, boardArr);
                //우
                Calc(n, i, j+1, cnt, 2, boardArr);
                //좌하
                Calc(n, i+1, j-1, cnt, 3, boardArr);
                //우하
                Calc(n, i+1, j+1, cnt, 4, boardArr);
                break;
            }
            case 1:{
                //하
                if(Calc(n, i+1, j, cnt, 1, boardArr)){
                    return true;
                }
                break;
            }
            case 2:{
                //우
                if(Calc(n, i, j+1, cnt, 2, boardArr)){
                    return true;
                }
                break;
            }
            case 3:{
                //좌하
                if(Calc(n, i+1, j-1, cnt, 3, boardArr)){
                    return true;
                }
                break;
            }
            case 4:{
                //우하
                if(Calc(n, i+1, j+1, cnt, 4, boardArr)){
                    return true;
                }
                break;
            }
        }
        return false;
    }
}
