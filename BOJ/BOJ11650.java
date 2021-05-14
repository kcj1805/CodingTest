import java.io.*;
import java.util.*;

public class BOJ11650 {
    //좌표 정렬하기 -1,2
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] Arr = new int[N][2];
        for(int i=0;i<N;i++){
            Arr[i][0]=sc.nextInt();
            Arr[i][1]=sc.nextInt();
        }
        //11650
        //Sort11650(Arr);
        //11651
        Sort11651(Arr);

        for (int[] is : Arr) {
            System.out.println(is[0] + " " + is[1]);
        }
        sc.close();
    }
    public static void Sort11650(int[][] Arr){
        Arrays.sort(Arr, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[0]-b[0]==0){
                    return a[1]-b[1];
                }
                else{
                    return a[0]-b[0];
                }
            }
        });
    }
    public static void Sort11651(int[][] Arr){
        Arrays.sort(Arr, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[1]-b[1]==0){
                    return a[0]-b[0];
                }
                else{
                    return a[1]-b[1];
                }
            }
        });
    }
}
