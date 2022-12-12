package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = 4;
        int num = 1000;
//        findTriangularNumber(n);
//        findFactorial(n);
//        printPrime(num);
//        calculator();

    }

    /**
     *
     * Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
     */
    public static void findTriangularNumber(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    public static void findFactorial(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++) {
            f *= i;
        }
        System.out.println(f);
    }
    /**
     * Вывести все простые числа от 1 до 1000
     */
    public static boolean isPrime(int num) {
        boolean prime = false;
        for (int i = 2; i <= num / 2; ++i) {
            if (num % i == 0) {
                prime = true;
                break;
            }
        }
        if (!prime)
            return true;
        else
            return false;

    }
    public static void printPrime(int n) {
        for (int i = 1; i < n; i++) {
            if(isPrime(i) && i != 1) {
                System.out.println(i);
            }
        }
    }

    /**
     * Реализовать простой калькулятор
     */
    public static void calculator() {
        System.out.println("Пожалуйста, введите номер операции: \n" +
                "1: Сложение\n" +
                "2: Вычитание\n" +
                "3: Умножение\n" +
                "4: Деление");
        Scanner operation = new Scanner(System.in);
        int choice = operation.nextInt();

        System.out.print("Пожалуйста, введите первое число: ");
        Scanner strOne = new Scanner(System.in);
        int num1 = strOne.nextInt();

        System.out.print("Пожалуйста, введите второе число: ");
        Scanner strTwo = new Scanner(System.in);
        int num2 = strTwo.nextInt();

        int result = 0;
        switch (choice) {
            case 1:
                result = num1 + num2;
                break;
            case 2:
                result = num1 - num2;
                break;
            case 3:
                result = num1 * num2;
                break;
            case 4:
                result = num1 / num2;
                break;

        }
        System.out.printf("Результат: %d",result);
    }
}
