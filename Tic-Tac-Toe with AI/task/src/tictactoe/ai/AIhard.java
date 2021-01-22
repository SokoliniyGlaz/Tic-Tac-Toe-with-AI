package tictactoe.ai;

import tictactoe.game.Field;
import tictactoe.game.Game;

import java.util.ArrayList;
import java.util.List;

public class AIhard extends ArtificialIntel {
    public Field field;
    public char sign;
    public Game game;
    public Move best;


    private class Move {
         int a;
         int b;
        private int score;

        public Move(int a, int b) {
            this.a = a;
            this.b = b;
        }
        public void setScore(int score) {
            this.score = score;
        }
        public int getScore() {
            return score;
        }
    }

    public AIhard(Field field, char sign, Game game) {
        this.field = field;
        this.sign = sign;
        this.game = game;

    }

    public List<Move> emptySpot(Field field) {
        ArrayList<Move> moves = new ArrayList<>();
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field.getElem(i, j) == 0) {
                    moves.add(new Move(i,j));
                }
            }
        }
        return moves;
    }
   public int[] makeMove() {
       char rival = this.sign == 'X'? 'O' : 'X';
       int bestScore = Integer.MIN_VALUE;
       for (int i = 0; i < field.length; i++) {
           for (int j = 0; j < field.length; j++) {
               if (field.getElem(i,j) == 0) {
                   field.setSign(i,j,sign);
                   int score = minimax(field, rival);
                   if (bestScore < score) {
                       bestScore = score;
                       best = new Move(i,j);
                   }
                   field.remove(i,j);
               }
           }
       }
       return new int[]{best.a,best.b};
   }


    public int minimax(Field temp, char sign) {
        List<Move> availSpots = emptySpot(temp);
        char rival = this.sign == 'X'? 'O' : 'X';
        if (game.winOrNot(this.sign)) {
            return  10;
        }
        else if (game.drawOrNot()) {
            return 0;
        }
        else if (game.winOrNot(rival)) {
            return  -10;
        }
        List<Move> moves = new ArrayList<>();
        for (Move availSpot : availSpots) {
            temp.setSign(availSpot.a, availSpot.b, sign);
            if (sign == this.sign) {
                int score = minimax(temp, rival);
                availSpot.setScore(score);
            } else {
                int score = minimax(temp, this.sign);
                availSpot.setScore(score);
            }
            temp.remove(availSpot.a,availSpot.b);
            moves.add(availSpot);
        }
        int bestScore;
        if (sign == this.sign) {
            bestScore  = Integer.MIN_VALUE;
            for (Move a : moves) {
                if (a.getScore() > bestScore) {
                    bestScore = a.getScore();
                }
            }
        }
        else {
            bestScore = Integer.MAX_VALUE;
            for (Move a : moves) {
                if (a.getScore() < bestScore) {
                    bestScore = a.getScore();
                }
            }
        }
         return bestScore;
    }
    @Override
    public String toString() {
        return "hard";
    }
}
