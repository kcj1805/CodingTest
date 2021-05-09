import java.io.*;
import java.util.*;

public class BOJ2108 {
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] inputArr = new int[N];
        int sum=0;
        for(int i=0;i<N;i++){
            inputArr[i]=sc.nextInt();
            sum += inputArr[i];
        }
        Arrays.sort(inputArr);
        
        int fir = sum/N;
        if(Math.abs(((double)sum%N)/N) > 0.5){
            if(fir<0){
                fir--;
            }
            else{
                fir++;
            }
        }
        int sec = inputArr[N/2];



        int four = inputArr[N-1]-inputArr[0];

        sc.close();
    }
}
