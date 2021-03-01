package machine;
import java.util.*;
public class CoffeeMachine {
    static int water = 400;
    static int milk = 540;
    static int beans  = 120;
    static int cups = 9;
    static int money = 550;
    static Scanner scanner = new Scanner(System.in);
    public static void printContent() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println("$" + money + " of money");
    }
    public static void buy(){
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String bev = scanner.next();
        if (!bev.equals("back")){
            if (bev.equals("1")) {
                if  (water >= 250 && beans >= 16 && cups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 250;
                    beans -= 16;
                    money += 4;
                    cups -= 1;
                }
                else if (water < 250){
                    System.out.println("Sorry, not enough water!");
                    }
                else if (beans < 16){
                    System.out.println("Sorry, not enough beans!");
                }
                else if (cups < 1){
                    System.out.println("Sorry, not enough cups!");
                }
            } else if (bev.equals("2")) {
                if (water >= 350 && beans >= 20 && milk >= 75 && cups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 350;
                    beans -= 20;
                    milk -= 75;
                    money += 7;
                    cups -= 1;
                }
                else if (water < 350){
                    System.out.println("Sorry, not enough water!");
                }
                else if (beans < 20){
                    System.out.println("Sorry, not enough beans!");
                }
                else if (cups < 1){
                    System.out.println("Sorry, not enough cups!");
                }
                else if (milk < 75){
                    System.out.println("Sorry, not enough milk!");
                }
            } else if (bev.equals("3")) {
                if (water >= 200 && beans >= 12 && milk >= 100 && cups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 200;
                    beans -= 12;
                    milk -= 100;
                    money += 6;
                    cups -= 1;
                } else if (water < 200) {
                    System.out.println("Sorry, not enough water!");
                } else if (beans < 12) {
                    System.out.println("Sorry, not enough beans!");
                } else if (cups < 1) {
                    System.out.println("Sorry, not enough cups!");
                } else if (milk < 100) {
                    System.out.println("Sorry, not enough milk!");
                }
            }
        }
    }
    public static void fill(){
        System.out.println("\nWrite how many ml of water do you want to add: ");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        beans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        cups += scanner.nextInt();
    }
    public static void take(){
        System.out.println("\nI gave you $" + money);
        money = 0;
    }
    public static void main(String[] args) {
        while(true){
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = scanner.next();
            switch (action) {
                case "buy":
                    buy();
                    System.out.println("");
                    break;
                case "fill":
                    fill();
                    System.out.println("");
                    break;
                case "take":
                    take();
                    System.out.println("");
                    break;
                case "remaining":
                    System.out.println("");
                    printContent();
                    System.out.println("");
                    break;
                case "exit":
                    System.exit(0);
                    break;
            }
        }
    }
}
