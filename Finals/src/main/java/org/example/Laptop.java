package org.example;


import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Laptop implements Comparable<Laptop>{
    private String name;
    private int RAM;
    private int storageSpace;
    private String operatingSystem;
    private String color;

    public Laptop(String name, int RAM, int storageSpace, String operatingSystem, String color) {
        this.name = name;
        this.RAM = RAM;
        this.storageSpace = storageSpace;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getRAM() {
        return RAM;
    }

    public int getStorageSpace() {
        return storageSpace;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "name='" + name + '\'' +
                ", RAM=" + RAM +
                ", storageSpace=" + storageSpace +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", color='" + color + '\'' +
                '}';
    }


    @Override
    public int compareTo(Laptop o) {
        Laptop laptop = (Laptop) o;
        System.out.println("this.getName() " + this.getName() + " this.getRAM() " + this.getRAM() + "\n");
        return this.getStorageSpace() - laptop.getStorageSpace();
    }



    public static List sortLaptops(Set<Laptop> laptopSet, int num, int userValue) {
        List<Laptop> ofLaptops = null;
        if(num == 1) {
            ofLaptops = laptopSet.stream().sorted(Comparator.comparing(Laptop::getName)).collect(Collectors.toList());
        } else if (num == 2) {
            ofLaptops = laptopSet.stream().sorted(Comparator.comparing(Laptop::getRAM)).filter(val -> (val.getRAM() >= userValue)).collect(Collectors.toList());
        } else if (num == 3) {
            ofLaptops = laptopSet.stream().sorted(Comparator.comparing(Laptop::getStorageSpace)).filter(val -> (val.getStorageSpace() >= userValue)).collect(Collectors.toList());
        } else if (num == 4) {
            ofLaptops = laptopSet.stream().sorted(Comparator.comparing(Laptop::getOperatingSystem)).collect(Collectors.toList());
        } else if (num == 5) {
            ofLaptops = laptopSet.stream().sorted(Comparator.comparing(Laptop::getColor)).collect(Collectors.toList());
        } else {
            System.out.println("Введенный номер не числится");
        }

        return ofLaptops;
    }

    public static void printLaptops(List<Laptop> ofLaptops) {
        for(Laptop laptop : ofLaptops) {
            System.out.println("Name: " + laptop.getName());
            System.out.println("RAM: " + laptop.getRAM());
            System.out.println("Storage space: " + laptop.getStorageSpace());
            System.out.println("Operating system: " + laptop.getOperatingSystem());
            System.out.println("Color: " + laptop.getColor());
            System.out.println("=========================");
        }
    }
}