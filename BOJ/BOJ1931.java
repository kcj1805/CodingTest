import java.io.*;
import java.util.*;


public class BOJ1931 {
    //회의실 배정
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] Arr = new int[N][2];
        for(int i=0;i<N;i++){
            Arr[i][0]=sc.nextInt();
            Arr[i][1]=sc.nextInt();
        }
        sc.close();

        Arrays.sort(Arr, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]){
                    return o1[0]-o2[0];
                }
                else{
                    return o1[1]-o2[1];
                }
            }
        });

        int end = Arr[0][1];
        int cnt = 1;
        for(int i=1;i<N;i++){
            if(Arr[i][0]>=end){
                end = Arr[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
