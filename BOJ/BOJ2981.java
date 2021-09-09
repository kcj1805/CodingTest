import java.io.*;
import java.util.*;

public class BOJ2981 {
    //검문
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] Arr = new int[N-1];
        int first = sc.nextInt();
        for(int i=0;i<N-1;i++){
            int sec = sc.nextInt(); 
            Arr[i]=Math.abs(first-sec);
            first = sec;
        }
        sc.close();

        int gcd = GetListGCD(Arr);
        
        for(int i=2;i<=gcd;i++){
            if(gcd%i==0){
                System.out.print(i + " ");
            }
        }
    }
    public static int GetListGCD(int[] tree){
        if(tree.length==1){
            return tree[0];
        }
        else{
            int result = GCD(tree[0], tree[1]);
            for (int i=2;i<tree.length;i++) {
                result = GCD(tree[i],result);
            }
            return result;
        }
    }
    public static int GCD(int a, int b){
        while(true){
            int r = a%b;
            if(r==0) return b;
            a=b;
            b=r;
        }
    }
}
