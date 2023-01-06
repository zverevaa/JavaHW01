package org.example;

import java.util.LinkedList;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        LinkedList<Integer> operations = new LinkedList<>();

        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter the 1st number: ");
            int firstNum = input.nextInt();
            System.out.print("Enter the 2nd number: ");
            int secondNum = input.nextInt();
            System.out.print("Input the operator. The available operators: (+, -, *, /). To remove the last operation enter d: ");
            char operator = input.next().charAt(0);
            calculation(operations, firstNum, secondNum, operator);
        }
        input.close();
    }

    public static void calculation(LinkedList<Integer> operations, int firstNum, int secondNum, char operator) {
        int result = 0;
        switch (operator) {
            case '+' -> {
                result = firstNum + secondNum;
                operations.add(result);
                }
            case '-' -> {
                result = firstNum - secondNum;
                operations.add(result);
            }
            case '*' -> {
                result = firstNum * secondNum;
                operations.add(result);
            }
            case '/' -> {
                result = firstNum / secondNum;
                operations.add(result);
            }
            case 'd' -> {
                operations.removeLast();
            }
            default -> System.out.println("This operator isn't supported. Try again");
        }
        System.out.println(result);
        System.out.println(operations);
    }

}
