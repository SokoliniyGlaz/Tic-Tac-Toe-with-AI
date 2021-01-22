package tictactoe;

import tictactoe.ai.ArtificialIntel;
import tictactoe.game.Field;
import tictactoe.game.Game;
import tictactoe.game.Player;
import tictactoe.game.User;

import java.util.Scanner;


public class Main {
    static boolean win;
    static boolean draw;
    static Player player1;
    static Player player2;
    static Player mover;
    static boolean keepOn;
    static Field field;
    static Game game;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] commands;
        loop:
        while (true) {
            while (true) {
                System.out.println("Input command: ");
                String input = scanner.nextLine();
                if (input.equals("exit")) {
                    break loop;
                }
                commands = input.split(" ");
                if (checkParam(commands)) {
                    initGame(commands);
                    keepOn = true;
                    break;
                }
            }
            while (keepOn) {
                char winner;
                while (true) {
                    int[] move;
                        move = mover.makeMove();
                        if (mover instanceof User) {
                            move = game.getCoordinates(move[0], move[1]);
                        }
                        if (game.makeMove(move, mover.sign)) {
                            winner = mover.sign;
                            if (mover instanceof ArtificialIntel) {
                                System.out.println("Making move level \"" + commands[1] + "\"");
                            }
                            if (mover == player1) {
                                mover = player2;
                            } else {
                                mover = player1;
                            }
                            break;
                        }
                    if (mover instanceof User) {
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                }
                game.field.printField();
                win = game.winOrNot(winner);
                draw = game.drawOrNot();
                keepOn = !(win || draw);
                if (win) {
                    System.out.println(winner + " " + "wins");
                } else if (draw) {
                    System.out.println("Draw");
                }
            }
        }
    }


    private static boolean checkParam(String[] commands) {
        if (commands.length < 3 || !commands[0].equals("start")
                || !Game.param.contains(commands[1])
                || !Game.param.contains(commands[2])) {
            System.out.println("Bad parameters!");
            return false;
        }
        return true;
    }

    private static void initGame(String[] commands) {
        field = new Field();
        game = new Game(field);
        player1 = game.createPlayer(commands[1], 'X');
        player1.sign = 'X';
        player2 = game.createPlayer(commands[2], 'O');
        player2.sign = 'O';
        game.field.printField();
        mover = player1;
    }

}



