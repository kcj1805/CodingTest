import java.io.*;
import java.util.*;

public class BOJ1992 {
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] video = new int[N][N];;

        for(int i=0;i<N;i++){
            String input = sc.next();
            for(int j=0;j<N;j++){
                video[i][j] = Integer.parseInt(input.split("")[j]);
            }
        }

        Zip(video,N,0,0);

        System.out.println(answer.toString());
        sc.close();
    }
    public static void Zip(int[][] video, int N, int i, int j)
    {
        int tmp = video[i][j];
        if(N != 1){
            for(int k=i;k<i+N;k++){
                for(int l=j;l<j+N;l++){
                    if(tmp != video[k][l]){
                        answer.append("(");
                        for(int a=0;a<2;a++){
                            for(int b=0;b<2;b++){
                                Zip(video,N/2,i+(a*N/2),j+(b*N/2));
                            }
                        }
                        answer.append(")");
                        return;
                    }
                }
            }
        }
        answer.append(tmp);

        return;
    }
}
