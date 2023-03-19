package TicTacToe.models;

import java.util.Scanner;

public class Player {

    private String name;
    private char symbol;

    public Player(String name, char symbol){
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public Move decideMove(Board board){
        Scanner scn = new Scanner(System.in);
        System.out.println("Tell the row for move");
        int row = scn.nextInt();

        System.out.println("Tell the col for move");
        int col = scn.nextInt();

        //validate
        if(row < 0 || row >= board.getCells().length || col < 0 || col >= board.getCells().length){
            System.out.println("The Cell is occupied. See the board and choose again:");
            board.display();
            Move move = this.decideMove(board);
            return move;

        }else{
            Cell cell = board.getCells()[row][col];
            if(cell.getPlayer() != null){
                System.out.println("The Cell is occupied. See the board and choose again:");
                board.display();
                Move move = this.decideMove(board);
                return move;
            }else{
                return new Move(this, row,col);

            }
        }
    }
}
