package tictactoe.game;

public class Field {
    public char[][] field;
    public int length = 3;


    public Field() {
        field = new char[3][3];
    }
    public Field(char[][] array) {
        this.field = array;
    }

    public void printField() {
        System.out.println("---------");
        for (int i = 0; i < field.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] != 0) {
                    System.out.print(field[i][j] + " ");
                }
                else System.out.print("  ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }
    public void remove(int a, int b) {
        if(field[a][b] != 0) {
          field[a][b] = 0;
        }
    }
    public char[][] getCopy() {
        return field.clone();
    }
    public char getElem(int i, int j) {
        return field[i][j];
    }
    public void setSign(int i, int j, char z) {
        field[i][j] = z;
    }


}
