import java.io.*;
import java.util.*;

public class BOJ7576 {
    //토마토
    static class XY{
        int X;
        int Y;
        XY(int x, int y){
            this.X = x;
            this.Y = y;
        }
    }
    static class tomato{
        int val;
        int Day;
        tomato(int val, int Day){
            this.val = val;
            this.Day = Day;
        }
    }
    static tomato[][] field;
    static Queue<XY> que;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        field = new tomato[N][M];
        que = new LinkedList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++) {
                tomato input = new tomato(Integer.parseInt(st.nextToken()),0);
                field[i][j] = input;
                if(input.val==1){
                    que.add(new XY(i,j));
                }
            }
        }
        wr.write(Integer.toString(Solution(N, M)));
        wr.flush();
        wr.close();
        br.close();
    }
    public static int Solution(int N, int M)
    {
        XY xy;
        int i=0;
        int j=0;
        while(!que.isEmpty()){
            xy = que.poll();
            i = xy.X;
            j = xy.Y;
            
            //상
            if(i-1 >= 0 && field[i-1][j].val == 0){
                que.add(new XY(i-1,j));
                field[i-1][j].val = 1;
                field[i-1][j].Day = field[i][j].Day+1;
            }
            //하
            if(i+1 < N && field[i+1][j].val == 0){
                que.add(new XY(i+1,j));
                field[i+1][j].val = 1;
                field[i+1][j].Day = field[i][j].Day+1;
            }
            //좌
            if(j-1 >= 0 && field[i][j-1].val == 0){
                que.add(new XY(i,j-1));
                field[i][j-1].val = 1;
                field[i][j-1].Day = field[i][j].Day+1;
            }
            //우
            if(j+1 < M && field[i][j+1].val == 0){
                que.add(new XY(i,j+1));
                field[i][j+1].val = 1;
                field[i][j+1].Day = field[i][j].Day+1;
            }
        }
        if(CheckZero(N, M)){
            return field[i][j].Day;
        }
        else{
            return -1;
        }
    }
    public static boolean CheckZero(int N, int M){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(field[i][j].val==0){
                    return false;
                }
            }
        }
        return true;
    }
}
