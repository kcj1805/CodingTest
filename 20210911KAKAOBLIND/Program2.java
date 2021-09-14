import java.io.*;
import java.util.*;

public class Program2 {
    public static void main(String[] args) throws IOException
    {
        solution(437674,3);
    }
    public static int solution(int n, int k) {
        String str = getdecimal(n, k);
        String[] strArr = str.split("0");

        int answer = 0;

        for (String string : strArr) {
            if(!string.isEmpty()){
                long Num = Long.parseLong(string);
                if(CheckPrimal(Num)){
                    answer++;
                }
            }
        }

        return answer;
    }
    public static boolean CheckPrimal(long n) {
		if(n==1) {
			return false;
		}
		for(int i=2 ; i<=Math.sqrt(n) ; i++ ) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
		
	}
    public static String getdecimal(int n, int k){
        StringBuilder sb = new StringBuilder();
        while(n>0){
            sb.append(n%k);
            n /= k;
        }
        sb.append(n);
        return sb.reverse().toString();
    }
}

