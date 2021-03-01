package cinema;
import java.util.Scanner;
public class Cinema {
    public static Scanner scanner = new Scanner(System.in);
    public static int rows;
    public static int seats;
    public static boolean exit = false;
    
    public static char[][] cinema;
    
    public static void printCinema(){
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int l = 0; l < seats; l++) {
            System.out.print((l+1) + " ");
        }
        System.out.println("");
        for (int n = 0; n < rows; n++) {
            System.out.print(n + 1);
            for(int k = 0; k < seats; k++) {
                System.out.print(" " + cinema[n][k]);
            }
            System.out.println("");       
        }

    }
    public static void buyTicket(){
        System.out.println("Enter a row number:");
        int rowN = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatN = scanner.nextInt();
        cinema[rowN-1][seatN-1] = 'B';
        int totalSeats = rows * seats;
        int half = rows / 2;
        
        if (totalSeats <= 60) {
            System.out.println("Ticket price: $10");
        }
        
        else if (totalSeats > 60){
            if (rowN <= half) {
                System.out.println("Ticket price: $10");
            }
            else if (rowN > half) {
                System.out.println("Ticket price: $8");
            }
            System.out.println();
        }

    }
    public static void printMenu(){
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("0. Exit");
        chooseAction();
    }
    public static void chooseAction(){
        int choice = scanner.nextInt();
            if (choice == 1) {
                printCinema();
            }
            else if (choice == 2){
                buyTicket();
            }
            else if (choice == 0) {
                exit = true;
                return;  
            }
    }
    
    public static void startCinema(){
        System.out.println("Enter the number of rows:");
        rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seats = scanner.nextInt();
        cinema = new char[rows][seats];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < seats; j++){
                cinema[i][j] = 'S';
            }
        }
    }

    public static void main(String[] args) {
        
        startCinema();

        while (!exit){
            printMenu();
        }
    }
}
