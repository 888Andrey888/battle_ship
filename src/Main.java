import java.util.Random;
import java.util.Scanner;

import static java.lang.System.*;

public class Main {
    final static int SIZE_FIELD = 5;
    public static char[][] playerField = new char[SIZE_FIELD][SIZE_FIELD];
    public static char[][] computerField = new char[SIZE_FIELD][SIZE_FIELD];
    public static Scanner scanner = new Scanner(in);
    public static Random rnd = new Random();

    public static void main(String[] args) {
        fillField(playerField);
        fillField(computerField);

        addShipForPlayer();
        printField(playerField);
        out.println("---------------");
        addShipForComputer();
        printField(computerField);
        while (!isAllPlayerShipsFall(playerField) && !isAllComputerShipsFall(computerField)) {
            out.println("---------------");
            fire(playerField, rnd.nextInt(0, SIZE_FIELD - 1), rnd.nextInt(0, SIZE_FIELD - 1));
            fire(computerField, scanner.nextInt(), scanner.nextInt());
            printField(playerField);
        }
    }

    public static boolean isAllPlayerShipsFall(char[][] playerField) {
        boolean allPlayerShipsFall = true;
        for (int i = 0; i < SIZE_FIELD; i++) {
            if (!allPlayerShipsFall) {
                break;
            }
            for (int j = 0; j < SIZE_FIELD; j++) {
                if (playerField[i][j] == '1') {
                    allPlayerShipsFall = false;
                    break;
                }
            }
        }
        if (allPlayerShipsFall) {
            out.println("Player is won!!!");
        }

        return allPlayerShipsFall;
    }

    public static boolean isAllComputerShipsFall(char[][] computerField) {
        boolean allComputerShipsFall = true;
        for (int i = 0; i < SIZE_FIELD; i++) {
            if (!allComputerShipsFall) {
                break;
            }
            for (int j = 0; j < SIZE_FIELD; j++) {
                if (computerField[i][j] == '1') {
                    allComputerShipsFall = false;
                    break;
                }
            }
        }
        if (allComputerShipsFall) {
            out.println("Computer is won!!!");
        }

        return allComputerShipsFall;
    }

    public static void fire(char[][] field, int x, int y) {
        field[x][y] = 'X';
    }

    public static void addShipForPlayer() {
        out.print("введите координату х:");
        int x = scanner.nextInt();
        out.println();
        out.print("введите координату y:");
        int y = scanner.nextInt();

        playerField[x][y] = '1';
    }

    public static void addShipForComputer() {
        computerField[rnd.nextInt(0, SIZE_FIELD - 1)][rnd.nextInt(0, SIZE_FIELD - 1)] = '1';
    }

    public static void printField(char[][] arrayForPrint) {
        for (int i = 0; i < SIZE_FIELD; i++) {
            for (int j = 0; j < SIZE_FIELD; j++) {
                out.print(arrayForPrint[i][j] + " ");
            }
            out.println();
        }
    }

    public static void fillField(char[][] arrayForFill) {
        for (int i = 0; i < SIZE_FIELD; i++) {
            for (int j = 0; j < SIZE_FIELD; j++) {
                arrayForFill[i][j] = '0';
            }
        }
    }
}