package HihoCoder;

import java.util.Scanner;

/**
 * Created by Yunzhuo on 10/16/2016.
 * http://hihocoder.com/contest/hihointerview20/problem/1
 */
public class FiveInARow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());;
        for(int i=0; i<n; i++){
            char[][] board= new char[15][15];
            for(int j=0; j<15; j++){
                String line = sc.nextLine();
                for(int k=0; k<15; k++){
                    board[j][k] = line.charAt(k);
                }
            }
            System.out.println(solve(board));
        }
        sc.close();
    }

    private static String solve(char[][] board){
        boolean white = false;
        boolean black = false;
        for(int i=0; i<15; i++){
            for(int j=0; j<15; j++){
                if(board[i][j]=='B' && expand(i, j, board, 'B')){
                    black = true;
                }
                else if(board[i][j]=='W' && expand(i, j, board, 'W')){
                    white = true;
                }
            }
        }
        if(white&&black)
            return "Both";
        else if(!white && !black)
            return "None";
        else if(white)
            return "White";
        else
            return "Black";
    }

    private static boolean expand(int i, int j, char[][] board, char c){
        int count = 1;
        for(int m=1; m<=5; m++){
            if(count==5)
                return true;
            if(i+m>=board.length || board[i+m][j] !=c)
                break;
            if(board[i+m][j]==c)
                count++;
        }
        count = 1;
        for(int m=1; m<=5; m++){
            if(count==5)
                return true;
            if(i-m<0 || board[i-m][j] !=c)
                break;
            if(board[i-m][j]==c)
                count++;
        }
        count = 1;
        for(int m=1; m<=5; m++){
            if(count==5)
                return true;
            if(j+m>=board[0].length || board[i][j+m] !=c)
                break;
            if(board[i][j+m]==c)
                count++;
        }
        count = 1;
        for(int m=1; m<=5; m++){
            if(count==5)
                return true;
            if(j-m<0 || board[i][j-m] !=c)
                break;
            if(board[i][j-m]==c)
                count++;
        }
        count = 1;
        for(int m=1; m<=5; m++){
            if(count==5)
                return true;
            if(i+m>=board.length || j+m >=board[0].length ||board[i+m][j+m]!=c)
                break;
            if(board[i+m][j+m]==c)
                count++;
        }
        count = 1;
        for(int m=1; m<=5; m++){
            if(count==5)
                return true;
            if(i+m>=board.length || j-m <0 ||board[i+m][j-m]!=c)
                break;
            if(board[i+m][j-m]==c)
                count++;
        }
        count = 1;
        for(int m=1; m<=5; m++){
            if(count==5)
                return true;
            if(i-m<0 || j+m >=board[0].length ||board[i-m][j+m]!=c)
                break;
            if(board[i-m][j+m]==c)
                count++;
        }
        count = 1;
        for(int m=1; m<=5; m++){
            if(count==5)
                return true;
            if(i-m<0 || j-m <0 ||board[i-m][j-m]!=c)
                break;
            if(board[i-m][j-m]==c)
                count++;
        }
        return false;
    }
}
