import java.io.*;
import java.util.*;

public class BOJ1780 {
    static int Minus=0;
    static int Zero=0;
    static int Plus=0;
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] paper = new int[N][N];;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                paper[i][j] = sc.nextInt();
            }
        }

        Cut(paper,N,0,0);

        System.out.println(Minus+"\n"+Zero+"\n"+Plus);
        sc.close();
    }
    public static void Cut(int[][] paper, int N, int i, int j)
    {
        int tmp = paper[i][j];
        if(N != 1){
            for(int k=i;k<i+N;k++){
                for(int l=j;l<j+N;l++){
                    if(tmp != paper[k][l]){
                        for(int a=0;a<3;a++){
                            for(int b=0;b<3;b++){
                                Cut(paper,N/3,i+(a*N/3),j+(b*N/3));
                            }
                        }
                        return;
                    }
                }
            }
        }
        switch(tmp){
            case -1:
            Minus++;
            break;
            case 0:
            Zero++;
            break;
            case 1:
            Plus++;
            break;
        }

        return;
    }
}
