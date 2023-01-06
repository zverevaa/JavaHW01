package org.example;

import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        /* Reverse linked list */
        int size = 10;
        LinkedList<Integer> list = new LinkedList<>();
        createLinkedList(list, size);
        System.out.println(list);
        reverseLinkedList(list);

        /*Linked list queue */
        enqueue(list, 6);
        System.out.println("Queued num: 6");
        System.out.println("Enqueue result: " + list);
        dequeue(list);
        System.out.println("Dequeue result: " + list);
        first(list);


    }
    /** Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.  */
    public static LinkedList<Integer> createLinkedList(LinkedList<Integer> list, int n) {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(10));
        }
        return list;
    }
    public static void reverseLinkedList(LinkedList<Integer> list) {
        int temp = 0;
        while (temp != list.size() - 1) {
            list.add(list.size() - temp, list.getFirst());
            list.removeFirst();
            temp++;
        }

        System.out.println("Reversed linked list: " + list);
    }

    /** Реализуйте очередь с помощью LinkedList со следующими методами:
     * enqueue() - помещает элемент в конец очереди,
     * dequeue() - возвращает первый элемент из очереди и удаляет его,
     * first() - возвращает первый элемент из очереди, не удаляя. */

    public static void enqueue(LinkedList<Integer> list, int num) {
        list.add(num);
    }
    public static Integer dequeue(LinkedList<Integer> list) {
        int temp = list.getFirst();
        list.removeFirst();
        System.out.println("Dequeued num: " + temp);
        return temp;
    }

    public static Integer first(LinkedList<Integer> list) {
        int temp = list.getFirst();
        System.out.println("The first num is: " + temp);
        return temp;
    }
}