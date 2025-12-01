package pr11.task5;

import java.util.*;

public class SimpleQueueCompare {
    public static void main(String[] args) {
        int n = 100000;

        // 1. Добавление в конец (enqueue)
        System.out.println("1. Добавление " + n + " элементов (enqueue):");

        List<Integer> arrayList = new ArrayList<>();
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) arrayList.add(i);
        long arrayTime = System.nanoTime() - start;
        System.out.println("   ArrayList:  " + arrayTime / 1000000 + " мс");

        List<Integer> linkedList = new LinkedList<>();
        start = System.nanoTime();
        for (int i = 0; i < n; i++) linkedList.add(i);
        long linkedTime = System.nanoTime() - start;
        System.out.println("   LinkedList: " + linkedTime / 1000000 + " мс");

        // 2. Удаление из начала (dequeue)
        System.out.println("\n2. Удаление " + (n/1000) + " элементов из начала (dequeue):");

        start = System.nanoTime();
        for (int i = 0; i < n/1000; i++) arrayList.remove(0);
        arrayTime = System.nanoTime() - start;
        System.out.println("   ArrayList:  " + arrayTime / 1000000 + " мс");

        start = System.nanoTime();
        for (int i = 0; i < n/1000; i++) linkedList.remove(0);
        linkedTime = System.nanoTime() - start;
        System.out.println("   LinkedList: " + linkedTime / 1000000 + " мс");

        // 3. Поиск по значению
        System.out.println("\n3. Поиск " + (n/1000) + " случайных элементов:");

        start = System.nanoTime();
        for (int i = 0; i < n/1000; i++) arrayList.contains(i);
        arrayTime = System.nanoTime() - start;
        System.out.println("   ArrayList:  " + arrayTime / 1000000 + " мс");

        start = System.nanoTime();
        for (int i = 0; i < n/1000; i++) linkedList.contains(i);
        linkedTime = System.nanoTime() - start;
        System.out.println("   LinkedList: " + linkedTime / 1000000 + " мс");
    }
}