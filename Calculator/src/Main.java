import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] operands = new double[2];
        String operator;

        while (true) {
            try {
                System.out.print("What is operand one: ");
                operands[0] = scanner.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("Please input a number.");
                scanner.nextLine();
            }
        }

        while (true) {
            try {
                System.out.print("What is the operator: ");
                operator = scanner.next();
                if (operator.equals("+") || operator.equals("-") ||
                    operator.equals("*") || operator.equals("/")) {
                    break;
                }
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Please input an operator (+, -, *, /).");
                scanner.nextLine();
            }
        }

        while (true) {
            try {
                System.out.print("What is operand two: ");
                operands[1] = scanner.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("Please input a number.");
                scanner.nextLine();
            }
        }

        System.out.println(operands[0] + operator + operands[1]);
        System.out.printf("Operand one: %f Operator: %s Operand Two: %f\n", operands[0], operator, operands[1]);

        switch (operator) {
            case "+":
                System.out.println("Result: " + (operands[0] + operands[1]));
                break;
            case "-":
                System.out.println("Result: " + (operands[0] - operands[1]));
                break;
            case "*":
                System.out.println("Result: " + (operands[0] * operands[1]));
                break;
            case "/":
                System.out.println("Result: " + (operands[0] / operands[1]));
                break;
        }
    }
}