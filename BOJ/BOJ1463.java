import java.io.*;
import java.util.*;

public class BOJ1463 {
    //1로 만들기
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        sc.close();
        //1 입력시 0 리턴
        if(X==1){
            System.out.println(0);
            return;
        }
        
        List<TreeSet<Integer>> tsList = new ArrayList<>();
        int cnt=0;
        //첫 리스트 추가
        tsList.add(new TreeSet<>());
        Case(tsList, cnt++, X);

        while(true){
            //이전 TreeSet에서 1이 만들어졌으면 종료
            if(tsList.get(cnt-1).contains(1)){
                break;
            }
            //이전 TreeSet의 값을 전부 계산하면서 다음 TreeSet에 추가
            tsList.add(new TreeSet<>());
            for (int val : tsList.get(cnt-1)) {
                Case(tsList, cnt, val);
            }
            cnt++;
        }
        
        System.out.println(cnt);
    }

    public static void Case(List<TreeSet<Integer>> tsList, int cnt, int val){
        if(val%3==0){
            tsList.get(cnt).add(val/3);
        }
        if(val%2==0){
            tsList.get(cnt).add(val/2);
        }
        tsList.get(cnt).add(val-1);
    }
}
