/**
 * Java 1. Lesson 4. Tic-tac-toe in console
 *
 * @author Sergey Iryupin
 * @version dated Feb 02, 2017
 */
import java.util.Random;
import java.util.Scanner;

class TicTacToe {

    final int SIZE = 3;
    final char DOT_X = 'x';
    final char DOT_O = 'o';
    final char DOT_EMPTY = '.';
    char[][] map = new char[SIZE][SIZE];
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    public static void main(String[] args) {
        new TicTacToe();
    }

    TicTacToe() {
        initMap();
        while (true) {
            humanTurn();
            if (checkWin(DOT_X)) {
                System.out.println("YOU WON!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Sorry, DRAW!");
                break;
            }
//            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("AI WON!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Sorry, DRAW!");
                break;
            }
        }
        System.out.println("GAME OVER.");
        printMap();
    }

    void initMap() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                map[i][j] = DOT_EMPTY;
    }

    void printMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    void humanTurn() {
        int x, y;
        do {
            System.out.println("Enter X and Y (1..3):");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    void aiTurn() {
        int protectX = -1, protectY = -1;
        int winX = -1, winY = -1;
        
        for (int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                if(isCellValid(j, i))
                {
                    map[i][j] = DOT_O;
                    if(checkWin(DOT_O)) {
                        winY = i;
                        winX = j;
                    }
                    map[i][j] = DOT_X;
                    if(checkWin(DOT_X)) {
                        protectY = i;
                        protectX = j;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
        
        if(winX != -1) {
            map[winY][winX] = DOT_O;
        } else if (protectX != -1) {
            map[protectY][protectX] = DOT_O;
        } else {
            int x, y;
            do {
                
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            } while (!isCellValid(x, y));
            map[y][x] = DOT_O;
        }
    }

    boolean checkWin(char dot) {
        boolean firstDiag = true;
        boolean secondDiag = true;
        for(int i = 0; i < SIZE; i++) {
            firstDiag &= map[i][i] == dot;
            secondDiag &= map[SIZE - 1 - i][i] == dot;
            
            boolean col = true;
            boolean row = true;
            for(int j = 0; j < SIZE; j++) {
                col &= map[i][j] == dot;
                row &= map[j][i] == dot;
            }
            if (col || row) return true;
        }
        return (firstDiag || secondDiag);
    }

    boolean isMapFull() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (map[i][j] == DOT_EMPTY)
                    return false;
        return true;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE)
            return false;
        return map[y][x] == DOT_EMPTY; // by DSerov
    }
}