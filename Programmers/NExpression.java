import java.io.*;
import java.util.*;

public class NExpression {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        //String cnt = br.readLine();
        //String input = br.readLine();

        wr.write("");
        Solution(4,17);
        wr.flush();
        wr.close();
        br.close();
    }
    static int tempN;
    static TreeSet<Integer>[] arr;

    public static int Solution(int N, int number)
    {
        tempN = N;
        arr = new TreeSet[10];
        for(int i=1; i<=8; i++) {
            getNum(i);
            if(arr[i].contains(number)) 
                return i;
        }
        
        return -1;
    } 

    public static TreeSet<Integer> getNum(int n) {
        if((arr[n]!=null) && !arr[n].isEmpty())
            return arr[n];
        
        int num = 0;
        for(int i=0; i<n ; i++)
            num = 10*num + tempN;
        
        TreeSet<Integer> temp = new TreeSet<>();
        temp.add(num);
        
        for(int i=1; i<n; i++) {
            int j = n-i;
            TreeSet<Integer> from = getNum(i);
            TreeSet<Integer> to = getNum(j);
            for(int n1 : from) {
                for(int n2 : to) {
                    temp.add(n1+n2);
                    temp.add(n1-n2);
                    temp.add(n1*n2);
                    if(n2!=0) temp.add(n1/n2);
                }
            }
        }
        return arr[n] = temp;
    }
}