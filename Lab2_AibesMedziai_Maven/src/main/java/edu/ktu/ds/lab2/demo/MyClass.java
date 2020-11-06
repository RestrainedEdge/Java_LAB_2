package edu.ktu.ds.lab2.demo;

import edu.ktu.ds.lab2.utils.AvlSet;
import edu.ktu.ds.lab2.utils.BstSet;
import edu.ktu.ds.lab2.utils.Ks;

import java.util.Iterator;

public class MyClass {
    public static void main(String[] args) {
        ExtraTwo();
    }
    private static void ExtraTwo() {
        AvlSet<Integer> numbers = new AvlSet<>();
        for(int i = 1; i < 32; i++) {
            numbers.add(i);
        }
        Ks.out(numbers.toVisualizedString(""));
        Ks.out(numbers.GetInner().toVisualizedString(""));
    }
    private static void ExtraOne() {
        int levels = 7;
        BstSet<Integer> numbers = new BstSet<Integer>();
        int maxValue = (int)Math.pow(2, levels);
        for(int i = maxValue; i >= 1; i /= 2) {
            for(int j = 0; i + j < maxValue; j += 2 * i) {
                int n = i + j;
                if(n % 3 == 0 && n < 97)
                    numbers.add(n);
            }
        }
        Ks.out(numbers.toVisualizedString(""));
        Ks.out("" + '\n' + numbers.isBalanced(5));
    }
    private static void SetTest() {
        int levels = 5;
        BstSet<Integer> numbers = new BstSet<Integer>();
        int maxValue = (int)Math.pow(2, levels);
        for(int i = maxValue; i >= 1; i /= 2) {
            for(int j = 0; i + j < maxValue; j += 2 * i) {
                int n = i + j;
                if(n % 2 == 0)
                    numbers.add(n);
            }
        }
        BstSet<Integer> headSet = (BstSet<Integer>) numbers.headSet(4);
        BstSet<Integer> tailSet = (BstSet<Integer>) numbers.tailSet(24);
        BstSet<Integer> subSet = (BstSet<Integer>) numbers.subSet(4, 24);

        Ks.out(numbers.toVisualizedString(""));
        Ks.out(headSet.toVisualizedString(""));
        Ks.out(subSet.toVisualizedString(""));
        Ks.out(tailSet.toVisualizedString(""));

    }
    private static void AVLRemoveTest() {
        int levels = 5;
        AvlSet<Integer> numbers = new AvlSet<Integer>();
        int maxValue = (int)Math.pow(2, levels);
        for(int i = 1; i < maxValue; i++) {
            numbers.add(i);
        }
        Ks.out(numbers.toVisualizedString(""));
        for(int i = 1; i < maxValue; i++) {
            if(i % 1 == 0)
                numbers.remove(i);
        Ks.out(numbers.toVisualizedString(""));
        }
        Ks.out(numbers.toVisualizedString(""));
    }
    private static void RetainAllTest() {
        int levels = 5;
        BstSet<Integer> numbers = new BstSet<Integer>();
        int maxValue = (int)Math.pow(2, levels);
        for(int i = maxValue; i >= 1; i /= 2) {
            for(int j = 0; i + j < maxValue; j += 2 * i) {
                int n = i + j;
                if(n % 2 == 0)
                    numbers.add(n);
            }
        }
        BstSet<Integer> Set = new BstSet<Integer>();
        for(int i = maxValue; i >= 1; i /= 2) {
            for(int j = 0; i + j < maxValue; j += 2 * i) {
                int n = i + j;
                if(n % 3 == 0)
                    Set.add(n);
            }
        }
        Ks.out(numbers.toVisualizedString(""));
        Ks.out(Set.toVisualizedString(""));
        numbers.retainAll(Set);
        Ks.out(numbers.toVisualizedString(""));

    }
    private static void ContainsAllTest() {
        int levels = 5;
        BstSet<Integer> numbers = new BstSet<Integer>();
        int maxValue = (int)Math.pow(2, levels);
        for(int i = maxValue; i >= 1; i /= 2) {
            for(int j = 0; i + j < maxValue; j += 2 * i) {
                int n = i + j;
                if(n % 2 == 0)
                    numbers.add(n);
            }
        }
        BstSet<Integer> Set = new BstSet<Integer>();
        for(int i = maxValue; i >= 1; i /= 2) {
            for(int j = 0; i + j < maxValue; j += 2 * i) {
                int n = i + j;
                if(n % 4 == 0)
                    Set.add(n);
            }
        }
        Ks.out(numbers.toVisualizedString(""));
        Ks.out(Set.toVisualizedString("") + '\n');
        Ks.out("Contains All - " + numbers.containsAll(Set));
    }

    private static void AddAllTest() {
        int levels = 5;
        BstSet<Integer> numbers = new BstSet<Integer>();
        int maxValue = (int)Math.pow(2, levels);
        for(int i = maxValue; i >= 1; i /= 2) {
            for(int j = 0; i + j < maxValue; j += 2 * i) {
                int n = i + j;
                if(n % 2 == 0)
                    numbers.add(n);
            }
        }
        BstSet<Integer> addSet = new BstSet<Integer>();
        for(int i = maxValue; i >= 1; i /= 2) {
            for(int j = 0; i + j < maxValue; j += 2 * i) {
                int n = i + j;
                if(n % 3 == 0)
                    addSet.add(n);
            }
        }
        Ks.out(numbers.toVisualizedString(""));
        Ks.out(addSet.toVisualizedString(""));
        numbers.addAll(addSet);
        Ks.out(numbers.toVisualizedString(""));
    }
    private static void RemoveIteratorTest() {
        int levels = 5;
        BstSet<Integer> numbers = new BstSet<Integer>();
        int maxValue = (int)Math.pow(2, levels);
        for(int i = maxValue; i >= 1; i /= 2) {
            for(int j = 0; i + j < maxValue; j += 2 * i) {
                numbers.add(i + j);
            }
        }

        Ks.out(numbers.toVisualizedString(""));
        Ks.out("Empty? - " + numbers.isEmpty());

        Iterator<Integer> i = numbers.iterator();
        while(i.hasNext()) {
            Integer number = i.next();
            if(number % 8 == 0) {
                Ks.out("------------------------\n");
                Ks.out("removing -" + number + '\n');
                i.remove();
                Ks.out(numbers.toVisualizedString(""));
            }
        }

        Ks.out("------------------------\n");
        Ks.out("Size:" + numbers.size() + '\n');
        Ks.out("------------------------\n");
        Ks.out(numbers.toVisualizedString(""));
        Ks.out("Empty? - " + numbers.isEmpty());
    }
    private static void RemoveTest() {
        int levels = 4;
        BstSet<Integer> numbers = new BstSet<Integer>();
        int maxValue = (int)Math.pow(2, levels);
        for(int i = maxValue; i >= 1; i /= 2) {
            for(int j = 0; i + j < maxValue; j += 2 * i) {
                numbers.add(i + j);
            }
        }
        Ks.out("Empty? - " + numbers.isEmpty() + "\n");
        Ks.out(numbers.toVisualizedString(""));
        numbers.remove(8);
        Ks.out(numbers.toVisualizedString(""));
        numbers.remove(7);
        Ks.out(numbers.toVisualizedString(""));
        numbers.remove(6);
        Ks.out(numbers.toVisualizedString(""));
        numbers.remove(5);
        Ks.out(numbers.toVisualizedString(""));
        numbers.remove(4);
        Ks.out(numbers.toVisualizedString(""));
        numbers.remove(3);
        Ks.out(numbers.toVisualizedString(""));
        numbers.remove(2);
        Ks.out(numbers.toVisualizedString(""));
        numbers.remove(1);
        Ks.out(numbers.toVisualizedString(""));
        numbers.remove(12);
        Ks.out(numbers.toVisualizedString(""));
        numbers.remove(11);
        Ks.out(numbers.toVisualizedString(""));
        numbers.remove(10);
        Ks.out(numbers.toVisualizedString(""));
        numbers.remove(9);
        Ks.out(numbers.toVisualizedString(""));
        numbers.remove(14);
        Ks.out(numbers.toVisualizedString(""));
        numbers.remove(13);
        Ks.out(numbers.toVisualizedString(""));
        numbers.remove(15);
        Ks.out(numbers.toVisualizedString(""));
        Ks.out("\nSize: " + numbers.size() + '\n');
        Ks.out("Empty? - " + numbers.isEmpty() + "\n");
        for(int i = maxValue; i >= 1; i /= 2) {
            for(int j = 0; i + j < maxValue; j += 2 * i) {
                numbers.add(i + j);
            }
        }
        Ks.out("\n");
        Ks.out("Size: " + numbers.size() + '\n');
        Ks.out(numbers.toVisualizedString(""));
    }
}
