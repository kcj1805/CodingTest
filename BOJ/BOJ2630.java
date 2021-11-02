import java.io.*;
import java.util.*;

public class BOJ2630 {
    //색종이 만들기
    static int white=0;
    static int blue=0;
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] paper = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                paper[i][j] = sc.nextInt();
            }
        }
        Cut(paper,N,0,0);
        System.out.println(white + "\n" + blue);
        sc.close();
    }

    public static void Cut(int[][] paper,int N, int i, int j)
    {
        int tmp=paper[i][j];
        if(N!=1){
            for(int k=i;k<i+N;k++){
                for(int r=j;r<j+N;r++){
                    //완전하지않으면 분할해서 재귀
                    if(tmp != paper[k][r]){
                        for(int a=0;a<2;a++){
                            for(int b=0;b<2;b++){
                                Cut(paper, N/2, i+(a*N/2), j+(b*N/2));
                            }
                        }
                        return;
                    }
                }
            }
        }
        //완전하면 흰색, 파란색 구분
        if(tmp==1){
            blue++;
        }
        else{
            white++;
        }
    }
}
