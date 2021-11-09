import java.io.*;
import java.util.*;

public class BOJ10830 {
    //행렬 제곱
    static int[][] A;
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Long B = sc.nextLong();
        A = new int[N][N];
        int[][] matrix = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                A[i][j]=sc.nextInt();
                matrix[i][j]=A[i][j];
            }
        }
        for(Long i=Long.valueOf(0);i<B-1;i++){
            matrix = Solution(matrix);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sb.append(matrix[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

        sc.close();
    }

    public static int[][] Solution(int[][] matrix)
    {
        int[][] C = new int[A.length][A[0].length];

        for(int i=0;i<C.length;i++){
            for(int j=0;j<C[0].length;j++){
                int val = 0;
                for(int a=0;a<A.length;a++){
                    val += matrix[i][a]*A[a][j]%1000;
                }
                C[i][j] = val%1000;
            }
        }

        return C;
    }
}
