package org.example;

import java.util.*;

import static org.example.Laptop.printLaptops;
import static org.example.Laptop.sortLaptops;


public class Main {
    public static void main(String[] args) {
        Scanner scannerOne = new Scanner(System.in);
        Scanner scannerTwo = new Scanner(System.in);
        System.out.println("Для сортировки введите число: \n" +
                "1 - Сортировать по имени \n" +
                "2 - Сортировать по объему оперативной памяти \n" +
                "3 - Сортировать по объему жесткого диска \n" +
                "4 - Сортировать по операционной системе \n" +
                "5 - Сортировать по цвету \n");
        int num = Integer.parseInt(scannerOne.nextLine());
        int userValue = 0;
        if(num == 2) {
            System.out.println("Введите минимальный объем оперативной памяти");
            userValue = Integer.parseInt(scannerTwo.nextLine());
        } else if(num == 3) {
            System.out.println("Введите минимальный объем о жесткого диска");
            userValue = Integer.parseInt(scannerTwo.nextLine());
        }
        scannerOne.close();
        scannerTwo.close();

        Set<Laptop> laptopSet = new HashSet<>();
        laptopSet.add(new Laptop("HUAWEI MateBook", 16, 512, "Windows 11", "серый"));
        laptopSet.add(new Laptop("MSI GF76 Katana 11SC-483XRU", 8, 256, "Windows 10", "черный"));
        laptopSet.add(new Laptop("GIGABYTE G5 GE", 16, 512, "Windows 11", "черный"));
        laptopSet.add(new Laptop("AORUS 17 XE4", 16, 1024, "Windows 10", "красный"));

        printLaptops(sortLaptops(laptopSet, num, userValue));

    }
}
