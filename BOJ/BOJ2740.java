import java.io.*;
import java.util.*;

public class BOJ2740 {
    //행렬 곱셈
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);

        int[][] A;
        int[][] B;
        int[][] C;
        A = new int[sc.nextInt()][sc.nextInt()];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                A[i][j] = sc.nextInt();
            }
        }
        int M = sc.nextInt();
        B = new int[M][sc.nextInt()];
        for(int i=0;i<B.length;i++){
            for(int j=0;j<B[0].length;j++){
                B[i][j] = sc.nextInt();
            }
        }

        C = new int[A.length][B[0].length];

        for(int i=0;i<C.length;i++){
            for(int j=0;j<C[0].length;j++){
                int val = 0;
                for(int a=0;a<M;a++){
                    val += A[i][a]*B[a][j];
                }
                C[i][j] = val;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<C.length;i++){
            for(int j=0;j<C[0].length;j++){
                sb.append(C[i][j]+" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
        sc.close();
    }
}
