import java.util.Scanner;

/**
 * Java LifePilot - Your Personal Java Assistant
 * A beginner-friendly console application for practicing core Java basics.
 */
public class Main {

    // One Scanner shared by the whole program (reads keyboard input)
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true; // controls the main loop

        while (running) {
            showMenu();
            int choice = readInt("Enter your choice (1-8): ");

            // switch picks one block of code based on the value of choice
            switch (choice) {
                case 1:
                    quickAddition();
                    break;
                case 2:
                    smartCalculator();
                    break;
                case 3:
                    numberAnalyzer();
                    break;
                case 4:
                    compareNumbers();
                    break;
                case 5:
                    leapYearDetector();
                    break;
                case 6:
                    primeNumberChecker();
                    break;
                case 7:
                    aboutProject();
                    break;
                case 8:
                    System.out.println();
                    System.out.println("Thanks for using Java LifePilot. Keep coding! \u2615");
                    running = false; // ends the loop
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 8.");
            }
        }

        scanner.close();
    }

    // ---------- MENU ----------

    static void showMenu() {
        System.out.println();
        System.out.println("======================================");
        System.out.println("          JAVA LIFEPILOT \u2615");
        System.out.println("     Your Personal Java Assistant");
        System.out.println("======================================");
        System.out.println();
        System.out.println("1. Quick Addition");
        System.out.println("2. Smart Calculator");
        System.out.println("3. Number Analyzer");
        System.out.println("4. Compare Numbers");
        System.out.println("5. Leap Year Detector");
        System.out.println("6. Prime Number Checker");
        System.out.println("7. About Project");
        System.out.println("8. Exit");
        System.out.println();
    }

    // ---------- INPUT HELPERS ----------

    static int readInt(String message) {
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }
            if (!scanner.hasNext()) {
                System.exit(0);
            }
            System.out.println("That is not a valid whole number. Try again.");
            scanner.next();
        }
    }

    static double readDouble(String message) {
        while (true) {
            System.out.print(message);
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            }
            if (!scanner.hasNext()) {
                System.exit(0);
            }
            System.out.println("That is not a valid number. Try again.");
            scanner.next();
        }
    }

    // ---------- FEATURE 1: QUICK ADDITION ----------

    static void quickAddition() {
        System.out.println();
        System.out.println("--- Quick Addition ---");
        int first = readInt("Enter first number: ");
        int second = readInt("Enter second number: ");
        int sum = first + second;
        System.out.println("Result: " + sum);
    }

    // ---------- FEATURE 2: SMART CALCULATOR ----------

    static void smartCalculator() {
        System.out.println();
        System.out.println("--- Smart Calculator ---");
        double first = readDouble("Enter first number: ");
        double second = readDouble("Enter second number: ");
        System.out.print("Enter operator (+, -, *, /, %): ");
        String text = scanner.next();
        char operator = text.charAt(0);

        switch (operator) {
            case '+':
                System.out.println("Result: " + (first + second));
                break;
            case '-':
                System.out.println("Result: " + (first - second));
                break;
            case '*':
                System.out.println("Result: " + (first * second));
                break;
            case '/':
                if (second == 0) {
                    System.out.println("Error: Cannot divide by zero.");
                } else {
                    System.out.println("Result: " + (first / second));
                }
                break;
            case '%':
                if (second == 0) {
                    System.out.println("Error: Cannot find remainder when dividing by zero.");
                } else {
                    System.out.println("Result: " + (first % second));
                }
                break;
            default:
                System.out.println("Error: Unknown operator '" + operator + "'.");
        }
    }

    // ---------- FEATURE 3: NUMBER ANALYZER ----------

    static void numberAnalyzer() {
        System.out.println();
        System.out.println("--- Number Analyzer ---");
        int number = readInt("Enter an integer: ");

        String sign;
        if (number > 0) {
            sign = "Positive";
        } else if (number < 0) {
            sign = "Negative";
        } else {
            sign = "Zero";
        }

        String parity = (number % 2 == 0) ? "Even" : "Odd";
        String primeStatus = isPrime(number) ? "Prime" : "Not Prime";

        System.out.println();
        System.out.println("Number       : " + number);
        System.out.println("Sign         : " + sign);
        System.out.println("Parity       : " + parity);
        System.out.println("Prime Status : " + primeStatus);
    }

    // ---------- FEATURE 4: COMPARE NUMBERS ----------

    static void compareNumbers() {
        System.out.println();
        System.out.println("--- Compare Numbers ---");
        System.out.println("1. Compare two numbers");
        System.out.println("2. Compare three numbers");
        int option = readInt("Choose an option (1-2): ");

        if (option == 1) {
            int a = readInt("Enter first number: ");
            int b = readInt("Enter second number: ");
            if (a == b) {
                System.out.println("Both numbers are equal: " + a);
            } else if (a > b) {
                System.out.println("The largest number is: " + a);
            } else {
                System.out.println("The largest number is: " + b);
            }
        } else if (option == 2) {
            int a = readInt("Enter first number: ");
            int b = readInt("Enter second number: ");
            int c = readInt("Enter third number: ");
            int largest = a;
            if (b >= a && b >= c) {
                largest = b;
            } else if (c >= a && c >= b) {
                largest = c;
            }
            System.out.println("The largest number is: " + largest);
        } else {
            System.out.println("Invalid option. Please choose 1 or 2.");
        }
    }

    // ---------- FEATURE 5: LEAP YEAR DETECTOR ----------

    static void leapYearDetector() {
        System.out.println();
        System.out.println("--- Leap Year Detector ---");
        int year = readInt("Enter a year: ");

        boolean isLeap = (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);

        if (isLeap) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }
    }

    // ---------- FEATURE 6: PRIME NUMBER CHECKER ----------

    static void primeNumberChecker() {
        System.out.println();
        System.out.println("--- Prime Number Checker ---");
        int number = readInt("Enter an integer: ");

        if (isPrime(number)) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }
    }

    static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    // ---------- FEATURE 7: ABOUT PROJECT ----------

    static void aboutProject() {
        System.out.println();
        System.out.println("--- About Project ---");
        System.out.println("Java LifePilot");
        System.out.println("A beginner Java project for practicing:");
        System.out.println();
        System.out.println("- Variables");
        System.out.println("- Data Types");
        System.out.println("- Operators");
        System.out.println("- Input/Output");
        System.out.println("- if/else");
        System.out.println("- switch");
        System.out.println("- loops");
        System.out.println("- methods");
        System.out.println("- basic problem solving");
    }
}
