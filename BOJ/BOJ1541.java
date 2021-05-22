import java.io.*;
import java.util.*;

public class BOJ1541 {
    //잃어버린 괄호
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String[] Number = input.split("[^0-9999]");
        String[] Oper = input.split("[0-9999]");
        Queue<Integer> Numque = new LinkedList<>();
        Queue<String> Operque = new LinkedList<>();
        //숫자큐
        for(int i=0;i<Number.length;i++){
            Numque.add(Integer.parseInt(Number[i]));
        }
        //연산자큐
        for(int i=0;i<Oper.length;i++){
            if(!Oper[i].isEmpty()){
                Operque.add(Oper[i]);
            }
        }
        System.out.println(Solution(Numque, Operque));
        sc.close();
    }
    public static int Solution(Queue<Integer> Numque, Queue<String> Operque)
    {
        int answer=0;
        answer += Numque.poll();
        
        while(!Numque.isEmpty()){
            String tmpOper = Operque.poll();
            //+일경우
            if(tmpOper.equals("+")){
                answer += Numque.poll();
            }
            //-일경우
            else{
                answer -= Numque.poll();
                //다음 -가 나올때까지 빼기
                while (!Operque.isEmpty()) {
                    String tmpOper2 = Operque.peek();
                    if(tmpOper2.equals("+")){
                        answer -= Numque.poll();
                        Operque.poll();
                    }
                    else{
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
