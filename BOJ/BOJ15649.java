import java.io.*;
import java.util.*;

public class BOJ15649 {
    //N과 M - (1),(2),(3),(4)
    static List<Integer> ansList = new ArrayList<>();
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        visited = new boolean[N+1];
        for(int i=1;i<=N;i++){
            Solution(i,M);
        }
        System.out.println(sb.toString());
        sc.close();
    }
    public static void Solution(int val, int M)
    {
        visited[val]=true;
        ansList.add(val);

        if(ansList.size()==M){
            for (int ans : ansList) {
                sb.append(ans+" ");
            }
            sb.append("\n");
        }
        else{
            //Calc1(M);
            //Calc2(val,M);
            //Calc3(M);
            Calc4(val,M);
        }

        ansList.remove(ansList.size()-1);
        visited[val]=false;
    }
    public static void Calc1(int M)
    {
        for(int i=1;i<visited.length;i++){
            if(!visited[i]){
                Solution(i, M);
            }
        }
    }
    public static void Calc2(int val, int M)
    {
        for(int i=val;i<visited.length;i++){
            if(!visited[i]){
                Solution(i, M);
            }
        }
    }
    public static void Calc3(int M)
    {
        for(int i=1;i<visited.length;i++){
            Solution(i, M);
        }
    }
    public static void Calc4(int val, int M)
    {
        for(int i=val;i<visited.length;i++){
            Solution(i, M);
        }
    }
}
