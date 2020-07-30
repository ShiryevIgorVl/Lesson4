import com.sun.deploy.security.SelectableSecurityManager;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static int SIZE = 5;
    public static int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;


   public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWindLinegor(DOT_X) || checkWindLinever(DOT_X) || checkWinDia1(DOT_X) || checkWinDia2(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWindLinegor(DOT_O) || checkWindLinever(DOT_O) || checkWinDia1(DOT_O) ||  checkWinDia2(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }



    public static boolean checkWinDia1 (char symb) {             // диагональ [1][1] - [5][5]

        int a = 0;
        for (int i = 0; i < map.length - 1; i++) {
            //for (int j = 1; j <map.length - 1; j++) {
                if (map[i][i] == symb && map[i + 1][i + 1] == symb) {         //диагонали
                    a++;
                }
            //}
            }
            if (a == DOTS_TO_WIN - 1) {
                return true;
        }


        return false;
    }

    public static boolean checkWinDia2 (char symb) {             // диагональ [1][5] - [1][5]

        int a = 0;
        for (int i = 0; i < map.length - 1; i++) {
            //for (int j = 1; j <map.length - 1; j++) {
            if (map[i][map.length - 1 - i] == symb && map[i + 1][map.length - 2 - i] == symb) {         //диагонали
                a++;
            }
            //}
        }
        if (a == DOTS_TO_WIN - 1) {
            return true;
        }


        return false;
    }

    public static boolean checkWindLinegor (char symb) {
        int a = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length - 1; j++) {
                if (map[i][j] == symb && map[i][j+1] == symb) {                     //горизонтали
                  a++;
                }
                if (j == 0) {
                    a = 0;
                }
            }
                if (a == DOTS_TO_WIN - 1) {
                    return true;
            }
        }

            return false;
        }

    public static boolean checkWindLinever (char symb) {
        int a = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length - 1; j++) {
                if (map[j][i] == symb && map[j + 1][i] == symb) {                     //вертикали
                    a++;
                }
                if (j == 0) {
                    a = 0;
                }
            }
            if (a == DOTS_TO_WIN - 1) {
                return true;
            }
          }
        return false;
    }


        public static boolean isMapFull () {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (map[i][j] == DOT_EMPTY) {
                        return false;
                    }
                }
            }
            return true;
        }


        public static void aiTurn () {
            int x;
            int y;
            do {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            } while (!isCellValid(x, y));
            System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
            map[y][x] = DOT_O;
        }


        public static void humanTurn () {
            int x;
            int y;
            do {
                System.out.println("Введите координаты в формате X Y");
                x = sc.nextInt() - 1;
                y = sc.nextInt() - 1;
            } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
            map[y][x] = DOT_X;
        }

        public static boolean isCellValid ( int x, int y ){
            if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
                return false;
            }
            if (map[y][x] == DOT_EMPTY) {
                return true;
            }
            return false;
        }
        public static void initMap () {
            map = new char[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    map[i][j] = DOT_EMPTY;
                }
            }
        }

        public static void printMap () {
            for (int i = 0; i <= SIZE; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
            for (int i = 0; i < SIZE; i++) {
                System.out.print((i + 1) + " ");
                for (int j = 0; j < SIZE; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }









