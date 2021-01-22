package tictactoe.ai;

import tictactoe.game.Player;

import java.util.Random;

public abstract class ArtificialIntel extends Player {

    public int[] makeMove() {
        Random random = new Random();
        int a = random.nextInt(3);
        int b = random.nextInt(3);
        return new int[]{a,b};
    }
}
