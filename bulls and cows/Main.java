package bullscows;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

        public class Main {
            public static void readNumber() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Input the length of the secret code:");
                String strLength = scanner.nextLine();
                if (!strLength.matches("\\d+")) {
                    System.out.println("Error: " + strLength + " isn't a valid number.");
                }
                else if (Integer.parseInt(strLength) > 36){
                    System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                }
                else if (Integer.parseInt(strLength) < 1){
                    System.out.println("Error: can't generate a secret number with a length of " + strLength +
                            " because there aren't enough unique digits.");
                }
                else {
                    System.out.println("Input the number of possible symbols in the code:");
                    String strSymbolNum = scanner.nextLine();

                    if (!strSymbolNum.matches("\\d+")) {
                        System.out.println("Error: " + strSymbolNum + " isn't a valid number.");
                    }
                    else if (!strSymbolNum.matches("\\d+")) {
                        System.out.println("Error: " + strSymbolNum + " isn't a valid number.");
                    }
                    else if (Integer.parseInt(strSymbolNum) > 36) {
                        System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                    } else if (Integer.parseInt(strSymbolNum) < 1) {
                        System.out.println("Error: can't generate a secret number with a length of " + strSymbolNum +
                                " because there aren't enough unique digits.");
                    } else if (Integer.parseInt(strLength) > Integer.parseInt(strSymbolNum)) {
                        System.out.println("Error: it's not possible to generate a code with a " +
                                "length of " + strLength + " with " + strSymbolNum + " unique symbols");
                    } else {
                        int length = Integer.parseInt(strLength);
                        int symbolNum = Integer.parseInt(strSymbolNum);
                        random(length, symbolNum);
                    }
                }

            }

            public static void random(int length, int symbolNum) {
                ArrayList<Character> chars = new ArrayList<Character>(Arrays.asList('0', '2', '3', '4', '5', '6', '7', '8', '9'));

                    for (char i = 'a'; i <= 'z'; i++){
                        chars.add(i);
                }
                ArrayList<Character> ultimate = new ArrayList<Character>();
                for (int i = 1; i < symbolNum; i++){
                    ultimate.add(i-1, chars.get(i-1));
                }

                Collections.shuffle(chars);
                StringBuilder result = new StringBuilder();
                for (var dig : ultimate.subList(0, length)) {
                    result.append(dig);
                }

                String result1 = result.toString();
                System.out.println(result1);
                String[] temporary = result1.split("");
                String[] code = new String[temporary.length];
                for (int i = 0; i < temporary.length; i++){
                    code[i] = temporary[i];
                }

                System.out.print("The secret code is prepared: ");
                for(int i = 0; i < length; i++){
                    System.out.print("*");
                }
                System.out.print(" ");
                if (symbolNum <= 10) {
                    System.out.println("(0-9).");
                }
                else {
                    System.out.println("(0-9, a-" + ultimate.get(ultimate.size()-1) + ").");
                }
                System.out.println("Okay, let's start a game!");
                check(code, length);
            }

            public static void main(String[] args) {

                readNumber();
            }

            public static void check(String[] code, int length) {
                //checking for bulls or cows
                boolean win = false;
                int turn = 1;
                while (!win) {
                    int bulls = 0;
                    int cows = 0;
                    System.out.println("Turn " + turn +":");
                    //getting input
                    Scanner scanner = new Scanner(System.in);
                    String n = scanner.next();
                    //array of guess
                    String[] arr = n.split("");
                    int l = arr.length;
                    for (int i = 0; i < l; i++) {
                        if (code[i].equals(arr[i])) {
                            bulls++;
                            arr[i] = "87";
                        }
                    }

                    for (int i = 0; i < arr.length; i++) {
                        if (i != 0 && code[i].equals(arr[i])) {
                            cows++;
                        }
                    }
                    if (bulls == length) {
                        System.out.println("Grade: " + bulls + " bulls");
                        System.out.println("Congratulations! You guessed the secret code!");
                        win = true;
                    }
                    else if (bulls == 1 && cows == 1) {
                        System.out.println("Grade: 1 bull and 1 cow.");
                    }
                    else if (bulls == 1 && cows != 0) {
                        System.out.println("Grade: 1 bull and " + cows + " cows.");
                    }
                    else if (bulls != 0 && cows == 1) {
                        System.out.println("Grade: " + bulls + " bulls and 1 cow.");
                    }
                    else if (bulls != 0 && cows != 0) {
                        System.out.println("Grade: " + bulls + " bulls and " + cows + " cows.");
                    } else if (bulls != 0 && cows == 0) {
                        System.out.println("Grade: " + bulls + " bulls.");
                    } else if (bulls == 0 && cows != 0) {
                        System.out.println("Grade: " + cows + " cows.");
                    } else if (bulls == 0 && cows == 0) {
                        System.out.println("Grade: None");
                    }
                    turn++;
                }
            }
        }
