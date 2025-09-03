import java.util.*;

public class tictactoe {
    public static void main(String[] args) {
        char board[][]=new char[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j]=' ';
            }
        }
        char player='X';
        boolean gameover=false;
        Scanner sc=new Scanner(System.in);
        while(!gameover){
            printboard(board);
            System.out.println("Player "+player+" enter your move (row and column): ");
            System.out.print("Row: ");
             int row=sc.nextInt();
            System.out.print("Column: ");
            int col=sc.nextInt();
            if(row<0 || col<0 || row>=3 || col>=3 || board[row][col]!=' '){
                System.out.println("Invalid move! Try again.");
                continue;
            }
            board[row][col]=player;
            gameover=gameover(board,player);
            if(gameover){
                printboard(board);
                System.out.println("Player "+player+" wins!");
                break;
            }
            if(player=='X'){
                player='O';
            }else{
                player='X';
            }
        }
        sc.close();
    }
    public static boolean gameover(char board[][],char player){
        // check rows 
        for(int i=0;i<board.length;i++){
            if(board[i][0]==player && board[i][1]==player && board[i][2]==player){
                return true;
            }
        }
        for(int i=0;i<board.length;i++){
            if(board[0][i]==player && board[1][i]==player && board[2][i]==player){
                return true;
            }
        }
        if(board[0][0]==player && board[1][1]==player && board[2][2]==player){
            return true;
        }
        if(board[0][2]==player && board[1][1]==player && board[2][0]==player){
            return true;
        }
        return false;
    }
    
    public static void  printboard(char board[][]){
        System.out.println("-------------");
        for(int i=0;i<board.length;i++){
            System.out.print("| ");
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]+" | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
        
    
}
