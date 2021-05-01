import java.io.*;
import java.util.*;

public class BOJ14889 {
    //스타트와 링크
    static int[][] arr;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        isSTeam = new boolean[N];
        
        StringTokenizer st;
        
        for(int i=0;i<N;i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        wr.write(Integer.toString(Solution()));
        
        wr.flush();
        wr.close();
        br.close();
    }
	static boolean[] visited;
	static int N;
	static int Answer = Integer.MAX_VALUE;
    public static int Solution()
    {
        setTeam(0,0);
        return Answer;
    }    
    static boolean isSTeam[];
    private static void setTeam(int idx, int cnt) {
        // 나올 수 있는 최솟값
        if (Answer == 0) return;
        // 모든 직원을 다 확인했는데, 스타트팀이 만들어지지 않았다면
        if (idx == N) return;
 
        // 스타트팀이 N/2명의 팀원을 모두 선택했다면 나머지는 링크팀
        if (cnt == N / 2) {
            int STeam = 0, LTeam = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 두 직원 모두 스타트 팀이라면 능력치 누적
                    if (isSTeam[i] && isSTeam[j]) STeam += arr[i][j];
                    // 링크팀 소속일 경우
                    if (!isSTeam[i] && !isSTeam[j]) LTeam += arr[i][j];
                    
                }
            }
 
            Answer = Math.min(Answer, Math.abs(STeam - LTeam));
            return;
        }
 
        // 스타트팀 추가
        isSTeam[idx] = true;
        setTeam(idx + 1, cnt + 1);
        // 링크팀 추가
        isSTeam[idx] = false;
        setTeam(idx + 1, cnt);
    }
}
