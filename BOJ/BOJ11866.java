import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ11866 {
    //요세푸스 문제0
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strArray = str.split(" ");
        int N = Integer.parseInt(strArray[0]);
        int K = Integer.parseInt(strArray[1]);
        Queue<Integer> que = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            que.add(i + 1);
        }
        int cnt = 0;
        System.out.print("<");
        while (true) {
            int temp = que.poll();
            if (++cnt != K) {
                que.add(temp);
            } else {
                System.out.print(temp);
                cnt = 0;
                if (que.isEmpty()) {
                    System.out.print(">");
                    break;
                } else {
                    System.out.print(", ");
                }
            }
        }
        sc.close();
    }
}
