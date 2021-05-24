import java.io.*;
import java.util.*;

public class BOJ1260 {
    //DFS와 BFS
    static Map<Integer, List<Integer>> NodeList = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int start = sc.nextInt();
        visited = new boolean[N];
        for(int i=0;i<M;i++){
            int input = sc.nextInt();
            int input2 = sc.nextInt();
            if(NodeList.containsKey(input)){
                NodeList.get(input).add(input2);
            }
            else{
                List<Integer> temp = new ArrayList<>();
                temp.add(input2);
                NodeList.put(input, temp);
            }
            if(NodeList.containsKey(input2)){
                NodeList.get(input2).add(input);
            }
            else{
                List<Integer> temp = new ArrayList<>();
                temp.add(input);
                NodeList.put(input2, temp);
            }
        }
        DFS(start);
        visited = new boolean[N];
        sb.append("\n");
        BFS(start);

        System.out.println(sb.toString());
        sc.close();
    }
    public static void DFS(int des)
    {   
        if(!visited[des-1]){
            sb.append(des + " ");
            visited[des-1]=true;
            if(NodeList.containsKey(des)){
                Collections.sort(NodeList.get(des));
                for (int b : NodeList.get(des)) {
                    DFS(b);
                }
            }
        }
    }
    public static void BFS(int i)
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            if(visited[tmp-1]) continue;
            else visited[tmp-1]=true;
            sb.append(tmp + " ");
            if(NodeList.containsKey(tmp)){
                for (int it : NodeList.get(tmp)) {
                    if(!visited[it-1]){
                        queue.add(it);
                    }
                }
            }
        }
    }
}
