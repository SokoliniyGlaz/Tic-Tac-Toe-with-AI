package tictactoe.game;


import tictactoe.ai.AIeasy;
import tictactoe.ai.AIhard;
import tictactoe.ai.AImedium;
import java.util.Arrays;
import java.util.List;

public class Game {
    public Field field;
    public static List<String> param = Arrays.asList("easy", "medium", "hard", "user");

    public Game(Field field){
        this.field = field;
    }

    public boolean winOrNot(char sign) {
        int count;
        for (int i = 0; i < 3; i++) {
            count = 1;
            for (int j = 1; j < field.length; j++) {
                if (field.getElem(i,j) == field.getElem(i,j-1)&& field.getElem(i, j) == sign) {
                    count++;
                }
                if (count == 3) {
                    return true;
                }
            }
        }
        for (int i = 0; i < field.length; i++) {
            count = 1;
            for (int j = 1; j < field.length; j++) {
                if (field.getElem(j, i) == field.getElem(j-1, i) && field.getElem(j, i) == sign) {
                    count++;
                }
                if (count == 3) {
                    return true;
                }
            }
        }
        return field.getElem(0,0) == sign &&  field.getElem(1,1) == sign &&  field.getElem(2,2) == sign ||
                field.getElem(0,2) == sign && field.getElem(1,1) == sign && field.getElem(2,0) == sign;
    }
    public boolean drawOrNot() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field.getElem(i,j) == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    public int[] getCoordinates(int a,int b){
        int[] arr = new int[2];
        if (a == 1) a = 0;
        else if (a == 2) a = 1;
        else if (a == 3) a = 2;
        if (b == 1) b = 2;
        else if (b == 2) b = 1;
        else if (b == 3) b = 0;
        arr[0] = b;
        arr[1] = a;
        return arr;
    }

    public boolean makeMove(int[] coord, char z){
        if (field.getElem(coord[0],coord[1]) == 0) {
            field.setSign(coord[0],coord[1],z);
            return true;
        }
        else {
            return false;
        }
    }

    public Player createPlayer(String s,char a) {
        switch (s) {
            case "easy":
                return new AIeasy();
            case "medium": {
                return new AImedium(field,a);
            }
            case "hard":
                return new AIhard(field,a,this);
            default:
                return new User();
        }
    }
}
