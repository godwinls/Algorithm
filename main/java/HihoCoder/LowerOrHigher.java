package HihoCoder;

import java.util.Scanner;

/**
 * Created by Yunzhuo on 10/15/2016.
 * http://hihocoder.com/contest/hihointerview20/problem/3
 */
public class LowerOrHigher {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] table = new int[n+1][n+1];
        System.out.println(dp(table, 1, n));
        in.close();
    }
    private static int dp(int[][] t, int s, int e){
        if(s>=e)
            return 0;
        if(t[s][e] !=0)
                return t[s][e];
        int res = Integer.MAX_VALUE;
        for(int x = s; x<=e; x++){
            int tmp = x+Math.max(dp(t, s, x-1), dp(t, x+1, e));
            res = Math.min(res, tmp);
        }
        t[s][e] = res;
        return res;
    }
}
