import java.io.*;
import java.util.*;

public class BOJ1107 {
    //리모컨
    public static void main(String[] args) throws IOException
    {
        /*
        11
        8
        1 3 4 5 6 7 8 9
        답 10*/
        /*
        12
        9
        0 1 3 4 5 6 7 8 9
        답 11*/
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        List<Integer> BanList = new ArrayList<>();
        for(int i=0;i<M;i++){
            BanList.add(sc.nextInt());
        }
        int res = Solution(N, BanList);
        int diff = Math.abs(100-N);
        if(diff<res){
            System.out.println(diff);
        }
        else{
            System.out.println(res);
        }
        sc.close();
    }
    public static int Solution(int N, List<Integer> BanList)
    {
        int answer=0;
        int[] NArr = Arrays.stream(Integer.toString(N).split("")).mapToInt(Integer::parseInt).toArray();
        int[] ansArr = new int[NArr.length];
        for(int i=0;i<NArr.length;i++){
            for(int j=0;j<10;j++){
                if(!BanList.contains(j) && NArr[i]<=j){
                    ansArr[i]=Math.max(ansArr[i],j);
                    answer++;
                    break;
                }
            }
        }
        StringBuilder strNum = new StringBuilder();

        for (int num : ansArr) 
        {
             strNum.append(num);
        }
        int finalInt = Integer.parseInt(strNum.toString());
        answer += Math.abs(N-finalInt);
        return answer;  
    }
}
