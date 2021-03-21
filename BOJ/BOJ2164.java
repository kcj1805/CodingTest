import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2164 {
    public static void main(String[] args)
    {
        int N;
        int res;
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<N;i++)
        {
            queue.add(i+1);
        }
        while(true)
        {
            res = queue.poll();
            if(!queue.isEmpty())
            {
                res = queue.poll();
                if(queue.isEmpty()){
                    System.out.println(res);
                    break;
                }
                queue.add(res);
            }
            else
            {
                System.out.println(res);
                break;
            }
        }
        sc.close();
    }
}
