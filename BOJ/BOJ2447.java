import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2447 
{
    static char[][] arr={};
    public static void main2(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        arr = new char[input][input];

        Star(input,0,0);
        for(int i=0;i<input;i++)
        {
            for(int j=0;j<input;j++)
            {
                if(arr[i][j]=='*')
                {
                    System.out.print('*');
                }
                else
                {
                    System.out.print(' ');
                }
            }
            System.out.println("");
        }
    }

    public static void Star(int input, int i, int j)
    {
        if(input == 1)
        {
            arr[i][j]='*';
            return;
        }
        for(int k=0;k<3;k++)
        {
            for(int l=0;l<3;l++)
            {
                if(k==1 && l==1)
                {
                }
                else
                {
                    Star(input/3,i+(k*(input/3)),j+(l*(input/3)));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                star2(i, j, n);
            }
            System.out.println("");
        }
    }
    
    static void star2(int i, int j, int n) {
        if (i / n % 3 == 1 && j / n % 3 == 1) {
            System.out.print(" ");
        }
        else if (n / 3 == 0) {
            System.out.print("*");
        }
        else {
            star2(i, j, n / 3);
        }
    }
}