package TicTacToe.factories;

import TicTacToe.models.BotDifficultyLevel;
import TicTacToe.strategies.BotPlayingStrategies.BotPlayingStrategy;
import TicTacToe.strategies.BotPlayingStrategies.EasyPlayingStrategy;
import TicTacToe.strategies.BotPlayingStrategies.HardPlayingStrategy;
import TicTacToe.strategies.BotPlayingStrategies.MediumPlayingStrategy;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel){
        BotPlayingStrategy bps = null;
        switch(botDifficultyLevel){
            case Easy:
                bps = new EasyPlayingStrategy();
                break;
            case Medium:
                bps = new MediumPlayingStrategy();
                break;
            case Hard:
                bps = new HardPlayingStrategy();
                break;
            default:
                return null;
        }
        return bps;
    }
}
