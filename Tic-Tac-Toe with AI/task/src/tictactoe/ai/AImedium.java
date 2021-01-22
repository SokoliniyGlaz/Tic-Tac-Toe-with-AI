package tictactoe.ai;

import tictactoe.game.Field;

public class AImedium extends ArtificialIntel{

    public Field field;
    private final char sign;

    public AImedium(Field field, char sign) {
        this.field = field;
        this.sign = sign;
    }
    public int[] makeMove() {
       int [] move = attack();
       if ( move == null) {
           move = protect();
       }
       else return move;
       if (move == null) {
           move = super.makeMove();
       }
       return move;
    }
    private int[] attack() {
        for (int i = 0; i < field.length; i++) {
            if (field.getElem(i, 0) == 0 && field.getElem(i, 1) == sign && field.getElem(i, 2) == sign) {
                return new int[]{i,0};
            } else if (field.getElem(i, 0) == sign && field.getElem(i, 1) == sign && field.getElem(i, 2) == 0) {
                return new int[]{i,2};
            } else if (field.getElem(i, 0) == sign && field.getElem(i, 2) == sign && field.getElem(i, 1) == 0) {
                return new int[]{i,1};

            }
        }
            for (int i = 0; i < field.length; i++) {
                if (field.getElem(i, 0) == 0 && field.getElem(i, 1) == sign && field.getElem(i, 2) == sign) {
                    return new int[]{i,0};
                } else if (field.getElem(i, 0) == sign && field.getElem(i, 1) == sign && field.getElem(i, 2) == 0) {
                    return new int[]{i,2};
                } else if (field.getElem(i, 0) == sign && field.getElem(i, 2) == sign && field.getElem(i, 1) == 0) {
                    return new int[]{i,1};
                }
            }

        if (field.getElem(0,0) == sign && field.getElem(1,1) == sign && field.getElem(2,2) == 0) {
            return new int[]{2,2};
        }
        else if (field.getElem(0,0) == 0 && field.getElem(1,1) == sign && field.getElem(2,2) == sign) {
            return new int[]{0,0};
        }
        else if (field.getElem(1,1) == 0 && field.getElem(2,2) == sign && field.getElem(0,0) == sign) {
            return new int[]{1,1};
        }
        else if (field.getElem(1,1) == 0 && field.getElem(2,0) == sign && field.getElem(0,2) == sign) {
            return new int[]{1,1};
        }
        else if (field.getElem(2,0) == 0 && field.getElem(1,1) == sign && field.getElem(0,2) == sign) {
            return new int[]{2,0};
        }
        else if (field.getElem(0,2) == 0 && field.getElem(1,1) == sign && field.getElem(2,0) == sign) {
            return new int[]{0,2};
        }

        else{
            return null;
        }
    }


    private int[] protect() {
        int[] arr = new int[2];
        boolean fill = false;
        for (int i = 0; i < field.length; i++) {
            if (field.getElem(i, 0) == 0 && field.getElem(i, 1) != sign && field.getElem(i, 1) == field.getElem(i,2) && field.getElem(i,2)!=0) {
                arr[0] = i;
                fill = true;
                break;
            } else if (field.getElem(i, 0) != 0 && field.getElem(i, 0) != sign && field.getElem(i, 2) == 0 && field.getElem(i,1) == field.getElem(i,0)) {
                arr[0] = i;
                arr[1] = 2;
                fill = true;
                break;
            } else if (field.getElem(i, 0) != sign && field.getElem(i, 0) != 0 && field.getElem(i, 1) == 0 && field.getElem(i,0) == field.getElem(i,2)) {
                arr[0] = i;
                arr[1] = 1;
                fill = true;
                break;
            }
        }
        if (fill) {
            return arr;
        }else {
            for (int i = 0; i < field.length; i++) {
                if (field.getElem(0, i) == 0 && field.getElem(1, i) != sign && field.getElem(1, i) == field.getElem(2,i) && field.getElem(2,i)!=0) {
                    arr[1] = i;
                    fill = true;
                    break;
                } else if (field.getElem(0, i) != 0 && field.getElem(0, i) != sign && field.getElem(2, i) == 0 && field.getElem(1,i) == field.getElem(0,i)) {
                    arr[0] = 2;
                    arr[1] = i;
                    fill = true;
                    break;
                } else if (field.getElem(0, i) != sign && field.getElem(0, i) != 0 && field.getElem(1, i) == 0 && field.getElem(0,i) == field.getElem(2,i)) {
                    arr[0] = 1;
                    arr[1] = i;
                    fill = true;
                    break;
                }
            }
            if (fill) {
                return arr;
            }
            if (field.getElem(0,0) != sign && field.getElem(0,0) != 0 && field.getElem(1,1) == field.getElem(0,0) && field.getElem(2,2) == 0) {
                arr[0] = 2;
                arr[1] = 2;
                return arr;
            }
            else if (field.getElem(0,0) == 0 && field.getElem(1,1) != 0 && field.getElem(1,1) != sign && field.getElem(1,1) == field.getElem(2,2)) {
                return arr;
            }
            else if (field.getElem(0,0) != 0 && field.getElem(0,0) != sign && field.getElem(1,1) == 0 && field.getElem(0,0) == field.getElem(2,2)) {
                arr[0] = 1;
                return arr;
            }
            else if (field.getElem(0,2) == 0 && field.getElem(1,1) != 0 && field.getElem(1,1) != sign && field.getElem(1,1) == field.getElem(2,0)) {
                arr[1] = 2;
                return arr;
            }
            else if (field.getElem(0,2) != 0 && field.getElem(0,2) != sign && field.getElem(1,1) == field.getElem(0,2) && field.getElem(2,0) == 0) {
                arr[0] = 2;
                return arr;
            }
            else if (field.getElem(1,1) == 0 && field.getElem(0,2) != 0 && field.getElem(0,2) != sign && field.getElem(0,2) == field.getElem(2,0)) {
                arr[0] = 1;
                arr[1] = 1;
                return arr;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return "medium";
    }
}
