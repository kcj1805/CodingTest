import java.io.*;
import java.util.*;

public class BOJ2562 {
    // 최댓값
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        for(int i=0;i<9;i++){
            tm.put(sc.nextInt(),i+1);
        }
        System.out.println(tm.lastKey());
        System.out.println(tm.get(tm.lastKey()));
        sc.close();
    }
}
