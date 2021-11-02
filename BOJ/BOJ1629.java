import java.io.*;
import java.util.*;

public class BOJ1629 {
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        Long A = Long.valueOf(sc.nextInt());
        Long B = Long.valueOf(sc.nextInt());
        Long C = Long.valueOf(sc.nextInt());

        System.out.println(Multi(A,B,C)%C);
        sc.close();
    }
    public static Long Multi(Long A, Long B, Long C)
    {
        Long ret = Long.valueOf(1);
        if(B==1){
            return A%C == 0 ? Long.valueOf(1) : A%C;
        }
        else if(B==2){
            return A*A%C == 0 ? Long.valueOf(1) : A*A%C;
        }
        else
        {
            ret = (ret * Multi(A, B/2, C))%C == 0 ? Long.valueOf(1) : (ret * Multi(A, B/2, C))%C;
            if(B%2 !=0){
                ret = (ret * Multi(A, B/2+1, C))%C == 0 ? Long.valueOf(1) : (ret * Multi(A, B/2+1, C))%C;
            }
            return ret;
        }
    }
}
