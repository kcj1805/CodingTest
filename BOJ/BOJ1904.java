import java.io.*;
import java.util.*;

public class BOJ1904 {
    //01타일
    static int C = 0;
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] Tile = new int[N];
        Solution(Tile, N);
        //System.out.println(Tile[N-1]%15746);
        System.out.println(C);
        sc.close();
    }
    public static void Solution(int[] Tile, int N)
    {
        /*
        for(int i=0;i<N;i++){
            if(i==0){
                Tile[i]=1;
                continue;
            }
            if(i==1){
                Tile[i]=2;
                continue;
            }
            if(Tile[i-1] + Tile[i-2]>=15746){
                Tile[i]=(Tile[i-1] + Tile[i-2])%15746;
            }
            else{
                Tile[i]=Tile[i-1] + Tile[i-2];
            }
        }
        */
        int A=0; 
        int B=0;
        for(int i=0;i<N;i++){
            if(i==0){
                A=1;
            }
            else if(i==1){
                B=2;
            }
            else{
                C = (A+B)%15746;
                A = B;
                B = C;
            }
        }
    }
}
