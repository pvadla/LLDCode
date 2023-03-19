package TicTacToe;

import TicTacToe.exceptions.InvalidArgumentsGameException;
import TicTacToe.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws InvalidArgumentsGameException {
        Scanner scn = new Scanner(System.in);

        System.out.println("What is the size of the board?");
        int dim = scn.nextInt();

        List<Player> players = new ArrayList<>();
        int numOfPlayers = dim - 1;
        for(int i = 0; i < numOfPlayers; i++){
            System.out.println("What is the name of the player?");
            String name = scn.next();

            System.out.println("What is the symbol of the player?");
            char symbol = scn.next().charAt(0);

            System.out.println("Is it a bot? (y/n)");
            boolean isBot = scn.next().toLowerCase().equals("y");

            Player p = null;
            if(isBot){
                System.out.println("Press 1 for easy, 2 for medium, and 3 for hard");
                BotDifficultyLevel difficultyLevel = BotDifficultyLevel.valueOf(scn.next());

                p = new Bot(name, symbol, difficultyLevel);
            }else{
                p = new Player(name,symbol);
            }

            players.add(p);
        }

        Game game = Game.getBuilder()
                .setDimensions(dim)
                .setPlayers(players)
                .build();

        while(game.getGameState().equals(GameState.InProgress)){
            System.out.println("the board looks like");
            game.display();

            System.out.println("Press Y for undo and n for next move");
            boolean isUnDoRequired = scn.next().toLowerCase().equals("y");

            if(isUnDoRequired){
                game.undo();
            }else{
                game.nextMove();
            }


        }

        //show the result

        if(game.getGameState().equals(GameState.End_In_Draw)){
            System.out.println("Game in draw");
        }else{
            Player winner = game.getWinner();
            System.out.println("Game ended. Winner is: "+winner.getName());
        }

    }
}
