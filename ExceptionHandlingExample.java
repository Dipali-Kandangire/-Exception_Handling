import java.util.Scanner;

public class ExceptionHandlingExample {

    // Method to demonstrate ArithmeticException (division by zero)
    public static void divideNumbers(int a, int b) {
        try {
            int result = a / b;
            System.out.println("Result of division: " + result);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: Division by zero is not allowed!");
        }
    }

    // Method to demonstrate ArrayIndexOutOfBoundsException
    public static void accessArrayElement(int[] array, int index) {
        try {
            System.out.println("Accessing array element at index " + index + ": " + array[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: Invalid index " + index);
        }
    }

    // Method to demonstrate NumberFormatException
    public static void convertStringToNumber(String str) {
        try {
            int number = Integer.parseInt(str);
            System.out.println("Converted string to number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: Invalid number format for input \"" + str + "\"");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Handling ArithmeticException
        System.out.println("Enter two numbers to divide:");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        divideNumbers(num1, num2);

        // Handling ArrayIndexOutOfBoundsException
        int[] myArray = {1, 2, 3, 4, 5};
        System.out.println("Enter the index of the array to access (valid range: 0 to 4):");
        int index = scanner.nextInt();
        accessArrayElement(myArray, index);

        // Handling NumberFormatException
        System.out.println("Enter a string to convert into a number:");
        String inputString = scanner.next();
        convertStringToNumber(inputString);

        scanner.close();
    }
}
