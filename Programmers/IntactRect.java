import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class IntactRect {
    public static void main(String[] args) throws IOException
    {
        solution(7,12);
    }
    public static long solution(int w, int h) {
        BigInteger answer = BigInteger.valueOf(w);
        answer = answer.multiply(BigInteger.valueOf(h));
        long val = Calc(w,h);
        answer = answer.subtract(BigInteger.valueOf(val));
        return answer.longValue();
    }
    
    public static long Calc(long w, long h){
        long gcdval = gcd(w,h);
        long a = w/gcdval;
        long b = h/gcdval;
        long res = 0;
        if(isPrime(a) && isPrime(b) || gcdval==1){
            res = gcdval * (a+b-1);
        }
        else{
            res = gcdval * Calc(a,b);
        }
        return res;
    }

    public static long gcd(long a, long b){
        if(b == 0){
            return a;
        }else{
            return gcd(b, a%b);
        }
    }

    public static boolean isPrime(long num){
        for(int i=2; i<num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}
