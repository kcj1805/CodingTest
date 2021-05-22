import java.io.*;
import java.util.*;

public class BOJ1389{
    //케빈 베이컨의 6단계 법칙
    static int[] depth;
    static boolean[] visited;
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        List<TreeSet<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=N;i++){
            graph.add(new TreeSet<>());
        }
        depth = new int[graph.size()];
        visited = new boolean[graph.size()];

        for(int i=0;i<M;i++){
            int v = sc.nextInt();
            int e = sc.nextInt();
            graph.get(v).add(e);
            graph.get(e).add(v);
        }
        int relate = Integer.MAX_VALUE;
        int answer = 0;
        for(int i=0;i<N;i++){
            //기본값 초기화
            for(int j=0;j<N;j++){
                depth[j+1]=1;
                visited[j+1]=false;
            }
            int res = BFS(graph,i+1);
            //최솟값이 바뀔 경우 인덱스 변경
            if(res < relate){
                relate = res;
                answer = i+1;
            }
        }
        System.out.println(answer);
        sc.close();
    }
    public static int BFS(List<TreeSet<Integer>> graph, int start)
    {
        int res = 0;
        Queue<Integer> que = new LinkedList<>();

        que.add(start);
        depth[start]=0;
        while(!que.isEmpty()){
            int tmp = que.poll();
            if(visited[tmp]) continue;
            else{
                visited[tmp]=true;
            }
            for (int i : graph.get(tmp)) {
                if(!visited[i] && !que.contains(i)){
                    //depth 쌓아가면서 변경 <- 이게 동적프로그래밍?
                    depth[i] += depth[tmp];
                    que.add(i);
                    res += depth[i];
                }
            }
        }
        return res;
    }
}
