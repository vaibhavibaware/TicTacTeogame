import java.util.Scanner;

public class TicTacTeo{
   public static void main(String[] args) {
    char[][] board=new char[3][3];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
            board[i][j]=' ';
            }
        }

        char player='X';
        boolean gameOver=false;
        Scanner sc=new Scanner(System.in);

        while (!gameOver) {
            printBoard(board);
            System.out.println("Player "+ player +" enter:");
            int row=sc.nextInt();
            int col=sc.nextInt();

            if(board[row][col]==' '){
                //place the element
                board[row][col]=player;
                gameOver=haveWon(board,player);
                if (gameOver) {
                    System.out.println(" Player "+ player+" Won!!");
                }else{
                    if(player=='X'){
                        player='O';
                    }else{
                        player='X';
                    }
                }
            }else{
                System.out.println("Invalid move");
            }
        }
        printBoard(board);
        sc.close();
    } 

    public static boolean haveWon(char[][]board,char player){
        for(int i=0;i<board.length;i++){
            if(board[i][0]== player && board[i][1]== player && board[i][2]== player ){
                return true;
            }
        }

        for(int j=0;j<board[0].length;j++){
            if(board[0][j]== player && board[1][j]== player && board[2][j]== player ){
                return true;
            }
        }

        if(board[0][0]==player &&board[1][1]==player && board[2][2]==player){
            return true;
        }

        if(board[0][2]==player &&board[1][1]==player && board[2][0]==player){
            return true;
        }

        return false;
    } 

    
    public static void printBoard(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
            System.out.print(board[i][j]);
            if (j < board[0].length - 1) {
                System.out.print(" | ");
            }
            }

            System.out.println( );
            if (i < board.length - 1) {
                System.out.println("--+---+--");
            }
        }
    }
}
