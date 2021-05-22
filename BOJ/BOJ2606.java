import java.io.*;
import java.util.*;

public class BOJ2606 {
    //바이러스
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        List<TreeSet<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=N;i++){
            graph.add(new TreeSet<>());
        }
        for(int i=0;i<M;i++){
            int v = sc.nextInt();
            int e = sc.nextInt();
            graph.get(v).add(e);
            graph.get(e).add(v);
        }
        System.out.println(BFS(graph));
        sc.close();
    }
    public static int BFS(List<TreeSet<Integer>> graph)
    {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];
        que.add(1);
        int answer=0;

        while(!que.isEmpty()){
            int tmp = que.poll();
            visited[tmp]=true;

            for (int val : graph.get(tmp)) {
                if(!que.contains(val) && !visited[val]){
                    que.add(val);
                    visited[val]=true;
                    answer++;
                }
            }
        }
        return answer;
    }
}
