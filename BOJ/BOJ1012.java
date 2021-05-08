import java.io.*;
import java.util.*;

public class BOJ1012 {
    //유기농 배추
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int input = Integer.parseInt(br.readLine());
        answer = new int[input];
        for(int i=0;i<input;i++){
            String MNK = br.readLine();
            int M = Integer.parseInt(MNK.split(" ")[0]);
            int N = Integer.parseInt(MNK.split(" ")[1]);
            int K = Integer.parseInt(MNK.split(" ")[2]);
            inputArr = new int[M][N];
            visited = new boolean[M][N];

            for(int j=0;j<K;j++){
                String AB = br.readLine();
                int A = Integer.parseInt(AB.split(" ")[0]);
                int B = Integer.parseInt(AB.split(" ")[1]);
                inputArr[A][B] = 1;
            }
            cnt=0;
            for(int a=0;a<M;a++){
                for(int b=0;b<N;b++){
                    Solution(a,b,true);
                }
            }
            answer[i]=cnt;
        }

        for(int i=0;i<answer.length;i++){
            wr.write(Integer.toString(answer[i])+"\n");
        }
        
        wr.flush();
        wr.close();
        br.close();
    }
    static int[] answer;
    static int cnt;
    static int[][] inputArr;
    static boolean[][] visited;
    public static void Solution(int i, int j, Boolean first)
    {
        if(visited[i][j]){
            return;
        }
        if(inputArr[i][j]==0){
            return;
        }
        visited[i][j]=true;

        //상
        if(j != 0){
            Solution(i, j-1, false);
        }
        //하
        if(j+1 != inputArr[0].length){
            Solution(i, j+1, false);
        }
        //좌
        if(i != 0){
            Solution(i-1, j, false);
        }
        //우
        if(i+1 != inputArr.length){
            Solution(i+1, j, false);
        }
        if(first){
            cnt++;
        }
    }
}
