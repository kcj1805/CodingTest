import java.io.*;
import java.util.*;

public class BOJ14888 {
    //연산자 끼워넣기
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Stack<Integer> tempStack = new Stack<>();
        for(int i=0;i<N;i++){
            tempStack.push(sc.nextInt());
        }
        reverse(tempStack);
        for(int i=0;i<4;i++){
            Calc[i] = sc.nextInt();
        }
        Solution(A.pop());
        System.out.println(max + "\n" + min);
        sc.close();
    }
    static Stack<Integer> A = new Stack<>();
    static int[] Calc = new int[4];
    static int max=Integer.MIN_VALUE;
    static int min=Integer.MAX_VALUE;
    public static void Solution(int val)
    {
        if(A.isEmpty()){
            max = Math.max(max,val);
            min = Math.min(min,val);
            return;
        }
        int tmp = A.pop();
        for(int i=0;i<Calc[0];i++){
            Calc[0]--;
            val += tmp;
            Solution(val);
            val -= tmp;
            Calc[0]++;
        }
        for(int i=0;i<Calc[1];i++){
            Calc[1]--;
            val -= tmp;
            Solution(val);
            val += tmp;
            Calc[1]++;
        }
        for(int i=0;i<Calc[2];i++){
            Calc[2]--;
            val *= tmp;
            Solution(val);
            val /= tmp;
            Calc[2]++;
        }
        for(int i=0;i<Calc[3];i++){
            Calc[3]--;
            val /= tmp;
            Solution(val);
            val *= tmp;
            Calc[3]++;
        }
        A.push(tmp);
    }
    public static void reverse(Stack<Integer> tempStack){
        while(!tempStack.isEmpty()){
            A.push(tempStack.pop());
        }
    }
}
