import java.io.*;

public class BOJ1018 {
    //체스판 다시 칠하기
    static String[][] WChess = {
                        {"W","B","W","B","W","B","W","B"},
                        {"B","W","B","W","B","W","B","W"},
                        {"W","B","W","B","W","B","W","B"},
                        {"B","W","B","W","B","W","B","W"},
                        {"W","B","W","B","W","B","W","B"},
                        {"B","W","B","W","B","W","B","W"},
                        {"W","B","W","B","W","B","W","B"},
                        {"B","W","B","W","B","W","B","W"}};
    static String[][] BChess = {
                        {"B","W","B","W","B","W","B","W"},
                        {"W","B","W","B","W","B","W","B"},
                        {"B","W","B","W","B","W","B","W"},
                        {"W","B","W","B","W","B","W","B"},
                        {"B","W","B","W","B","W","B","W"},
                        {"W","B","W","B","W","B","W","B"},
                        {"B","W","B","W","B","W","B","W"},
                        {"W","B","W","B","W","B","W","B"}};
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();

        int N = Integer.parseInt(input.split(" ")[0]);
        int M = Integer.parseInt(input.split(" ")[1]);
        String[][] chess = new String[N][M];
        
        for(int i=0;i<chess.length;i++){
            String[] temp = br.readLine().split("");
            for(int j=0;j<temp.length;j++){
                chess[i][j] = temp[j];
            }
        }

        wr.write(Integer.toString(Solution(chess)));
        
        wr.flush();
        wr.close();
        br.close();
    }
    public static int Solution(String[][] chess)
    {
        int answer=Integer.MAX_VALUE;
        String[][] tempArr = new String[8][8];
        for(int i=0;i<chess.length;i++){
            if(chess.length-i>=8){
                for(int j=0;j<chess[i].length;j++){
                    if(chess[i].length-j>=8){
                        for(int a=0;a<8;a++){
                            for(int b=0;b<8;b++){
                                tempArr[a][b] =chess[i+a][j+b]; 
                            }
                        }
                        answer=Math.min(answer,CheckPaint(tempArr));
                    }
                }
            }
        }

        return answer;
    }
    public static int CheckPaint(String[][] chess)
    {
        int Wcnt=0;
        int Bcnt=0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(!chess[i][j].equals(WChess[i][j])){
                    Wcnt++;
                }
                if(!chess[i][j].equals(BChess[i][j])){
                    Bcnt++;
                }
            }
        }
        return Math.min(Wcnt,Bcnt);
    }
}
