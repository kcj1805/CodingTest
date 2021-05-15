import java.io.*;
import java.util.*;

public class BOJ2920 {
    //음계
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int[] intArr = new int[8];
        int val = 0;
        for(int i=0;i<8;i++){
            int input = sc.nextInt();
            if(i==0){
            }
            else if(input>intArr[i-1]){
                if(i!=1 && val!=1){
                    val = 3;
                    break;
                }
                else{
                    val=1;
                }
            }
            else if(input<intArr[i-1]){
                if(i!=1 && val!=2){
                    val = 3;
                    break;
                }
                else{
                    val=2;
                }
            }
            else{
                val=3;
                break;
            }
            intArr[i] = input;
        }
        switch(val){
            case 1:
                System.out.println("ascending");
                break;
            case 2:
                System.out.println("descending");
                break;
            case 3:
                System.out.println("mixed");
                break;
        }
        sc.close();
    }
}
