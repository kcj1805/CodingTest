import java.io.*;
import java.util.*;

public class BOJ2108 {
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] inputArr = new int[N];
        int sum=0;
        for(int i=0;i<N;i++){
            inputArr[i]=sc.nextInt();
            sum += inputArr[i];
        }
        Arrays.sort(inputArr);
        
        int fir = sum/N;
        if(Math.abs(((double)sum%N)/N) > 0.5){
            if(fir<0){
                fir--;
            }
            else{
                fir++;
            }
        }
        int sec = inputArr[N/2];

        int thr = Calc(inputArr);

        int four = inputArr[N-1]-inputArr[0];

        System.out.println(fir);
        System.out.println(sec);
        System.out.println(thr);
        System.out.println(four);
        sc.close();
    }
    public static int Calc(int[] Arr)
    {
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<Integer>();
        int answer = 0;
        int nowcnt=0;
        int pastcnt=-1;
        int tmp=0;
        for(int i=0;i<Arr.length;i++){
            if(st.empty()){
                st.push(Arr[i]);
            }
            else{
                if(st.peek()==Arr[i]){
                    st.push(Arr[i]);
                }
                else{
                    while(!st.isEmpty()){
                        tmp=st.pop();
                        nowcnt++;
                    }
                    if(nowcnt>=pastcnt){
                        if(nowcnt>pastcnt){
                            ans.clear();
                        }
                        ans.add(tmp);
                        pastcnt = nowcnt;
                    }
                    nowcnt=0;
                    st.push(Arr[i]);
                }
            }
        }

        while(!st.isEmpty()){
            tmp=st.pop();
            nowcnt++;
        }
        if(nowcnt>=pastcnt){
            if(nowcnt>pastcnt){
                ans.clear();
            }
            ans.add(tmp);
        }

        if(ans.size()>=2){
            answer = ans.get(1);
        }
        else if(!ans.isEmpty()){
            answer = ans.get(0);
        }
        return answer;
    }
}
