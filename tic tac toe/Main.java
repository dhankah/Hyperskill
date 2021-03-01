package tictactoe;
import java.util.Scanner;
public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static char[][] ticTac = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };
   
    public static boolean xwin = false;
    public static boolean owin = false;
    public static boolean draw = false;
    
    public static void main(String[] args) {
        printField();
        char player = 'X';
        while (status().equals("Game not finished")) {
            move(scanner, ticTac, player);
            if (player == 'X') {
                player = 'O';
            } else {
                player = 'X';
            }
        }
        if (draw) {
            System.out.println("Draw");
        }
        else if (xwin) {
            System.out.println("X wins");
        }
        else if (owin) {
            System.out.println("O wins");
        }
        System.out.println(status());
    }
                
        static String status(){
            int row1 = ticTac[0][0] + ticTac[0][1] + ticTac[0][2];
            int row2 = ticTac[1][0] + ticTac[1][1] + ticTac[1][2];
            int row3 = ticTac[2][0] + ticTac[2][1] + ticTac[2][2];
            int col1 = ticTac[0][0] + ticTac[1][0] + ticTac[2][0];
            int col2 = ticTac[0][1] + ticTac[1][1] + ticTac[2][1];
            int col3 = ticTac[0][2] + ticTac[1][2] + ticTac[2][2];
            int dia1 = ticTac[0][0] + ticTac[1][1] + ticTac[2][2];
            int dia2 = ticTac[2][0] + ticTac[1][1] + ticTac[0][2];
            
            int total = ticTac[1][0] + ticTac[2][0] + 
            ticTac[2][1] + ticTac[0][0] +
            ticTac[0][1] + ticTac[1][1] +
            ticTac[1][2] + ticTac[2][2] +
            ticTac[0][2];
            int cx;
            int cy;
            
            if (row1 == 264 || row2 == 264 || row3 == 264 || col1 == 264 || col2 == 264 || col3 == 264 ||
            dia1 == 264 || dia2 == 264) {
                xwin = true; 
                return "X wins";                         
            } 
            else if (row1 == 237 || row2 == 237 || row3 == 237 || col1 == 237 || col2 == 237 || col3 == 237 ||
            dia1 == 237 || dia2 == 237) {
                owin = true;
                return "O wins";
            }
            else if (total == 756){
                draw = true;                
            }
            int xs = 0;
            int os = 0;
            
            for (int i = 0; i < ticTac.length; i++) {
                for (int j = 0; j < ticTac[i].length; j++) {
                    if (ticTac[i][j] == 'X'){
                        xs++;
                    }
                    else if (ticTac[i][j] == 'O'){
                        os++;
                    }
                    else if (ticTac[i][j] == ' ' || ticTac[i][j] == '_'){                   
                    return "Game not finished";
                    }
                }
            }
            return "";
        }        
                                
            static void move(Scanner scanner, char[][] ticTac, char player){
                System.out.print("Enter the coordinates: ");
                int x = scanner.nextInt() - 1;
                int y = scanner.nextInt() - 1;
                if (x < 0 || x > 2 ||  y < 0 || y > 2){
                    System.out.println("Coordinates should be from 1 to 3!");
                move(scanner, ticTac, player);
                }
                else if(ticTac[x][y] == '_' || ticTac[x][y] == ' ') {
                    ticTac[x][y] = player;
                    printField();
                }
                else {
                    System.out.println("This cell is occupied! Choose another one!");
                    move(scanner, ticTac, player);
                }
            }

    static void printField() {
        System.out.println("---------");
        System.out.println("|" + " " + ticTac[0][0] + " " + ticTac[0][1] + " " + ticTac[0][2] + " " + "|");
        System.out.println("|" + " " + ticTac[1][0] + " " + ticTac[1][1] + " " + ticTac[1][2] + " " + "|");
        System.out.println("|" + " " + ticTac[2][0] + " " + ticTac[2][1] + " " + ticTac[2][2] + " " + "|");
        System.out.println("---------");
        }
    }   
