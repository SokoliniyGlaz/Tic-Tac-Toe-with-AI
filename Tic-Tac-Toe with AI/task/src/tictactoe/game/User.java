package tictactoe.game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class User extends Player{

    public int[] makeMove() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the coordinates: ");
        boolean repeat = true;
        int a = 0;
        int b = 0;
        while (repeat) {
            try {
                a = sc.nextInt();
                b = sc.nextInt();
                if (a > 3 || a < 1 || b < 1 || b > 3) throw new ArrayIndexOutOfBoundsException();
                repeat = false;
            }catch(InputMismatchException e){
                System.out.println("You should enter numbers!");
                System.out.println("Enter the coordinates: ");
                sc.next();
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Coordinates should be from 1 to 3!");
                System.out.println("Enter the coordinates: ");
            }
        }
        return new int[]{a,b};
    }
    @Override
    public String toString() {
        return "user";
    }

}
