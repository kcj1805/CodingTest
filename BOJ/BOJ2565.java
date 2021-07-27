import java.io.*;
import java.util.*;

public class BOJ2565 {
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] val = new int[N][2];
        int answer = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<2;j++){
                val[i][j] = sc.nextInt();
            }
        }
        Arrays.sort(val, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        for(int i=0;i<N;i++){
            if(i!=0){
                int cnt = 0;
                for(int j=i-1;j>=0;j--){
                    if(val[i][1]<val[j][1]){
                        cnt++;
                    }
                }
                answer = Math.max(answer,cnt);
            }
        }
        System.out.println(answer);
        sc.close();
    }
}
