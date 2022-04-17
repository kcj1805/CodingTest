import java.io.*;
import java.util.*;

public class GroupPhoto {
    public static void main(String[] args) throws IOException
    {
        //{A, C, F, J, M, N, R, T}
        solution(1, new String[]{"N~F=0", "R~T>2"});
        //solution(2, new String[]{"M~C<2", "C~M>1"});
    }
    public static class Condition{
        String A;
        String B;
        String F;
        int Num;

        public Condition(String a, String b, String f, String num){
            A=a;
            B=b;
            F=f;
            Num=Integer.parseInt(num);
        }
    }
    static int cnt;
    static String[] Arr;
    static List<String> strList;
    static boolean[] IsSelected;
    static List<Condition> ConList;
    public static int solution(int n, String[] data) {
        cnt = 0;
        Arr = new String[]{"A", "C", "F", "J", "M", "N", "R", "T"};
        strList = new ArrayList<>();
        IsSelected = new boolean[Arr.length];
        ConList = new ArrayList<>();
        for (String str : data) {
            String[] temp = str.split("");
            ConList.add(new Condition(temp[0], temp[2], temp[3], temp[4]));
        }
        Work(0);
        return cnt;
    }
    public static void Work(int index){
        if(strList.size()==Arr.length){
            for (Condition con : ConList) {
                int val = Math.abs(strList.indexOf(con.A)-strList.indexOf(con.B))-1;
                switch(con.F){
                    case "=":
                        if(val!=con.Num){
                            return;
                        }
                        break;
                    case ">":
                        if(val<=con.Num){
                            return;
                        }
                        break;
                    case "<":
                        if(val>=con.Num){
                            return;
                        }
                        break;
                }
            }
            cnt++;
            return;
        }

        for(int i=0;i<Arr.length;i++){
            if(IsSelected[i]){
                continue;
            }
            IsSelected[i] = true;
            strList.add(Arr[i]);
            Work(index+1);
            strList.remove(Arr[i]);
            IsSelected[i] = false;
        }
    }
}
