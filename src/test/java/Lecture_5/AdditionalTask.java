package Lecture_5;

import java.util.ArrayList;
import java.util.List;

public class AdditionalTask {
    static List<Integer> collection = new ArrayList<>() {{
        add(1);
        add(2);
        add(3);
        add(0);
        add(-1);
        add(10);
        add(11);
        add(-20);
        add(40);
    }};

    public static void main(String[] args) {
        filterMoreZero();
        System.out.println();
        filterLessZero();
        System.out.println();
        filterFiveMultiple().forEach(System.out::println);
        System.out.println();
        filterTenMultiple().forEach(System.out::println);
    }

    public static void filterMoreZero() {
        List<Integer> filteredCollection = new ArrayList<>(collection);
        filteredCollection.removeIf((element) -> element <= 0);
        filteredCollection.forEach(System.out::println);
    }

    public static void filterLessZero() {
        List<Integer> filteredCollection = new ArrayList<>(collection);
        filteredCollection.removeIf((element) -> element >= 0);
        filteredCollection.forEach(System.out::println);
    }

    public static List<Integer> filterFiveMultiple() {
        return new ArrayList<>(collection) {{
            removeIf((element) -> element % 5 != 0 || element == 0);
        }};
    }

    public static List<Integer> filterTenMultiple() {
        return new ArrayList<>(collection) {{
            removeIf((element) -> element % 10 != 0 || element == 0);
        }};
    }
}
