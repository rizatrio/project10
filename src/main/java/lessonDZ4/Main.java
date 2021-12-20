package lessonDZ4;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> l = List.of(1, 7, 82, 50, -9);
        int number = 7;
        System.out.println(search(l, list -> list.indexOf(number)));

        System.out.println(reverse("java interview", str -> {
            StringBuilder builder = new StringBuilder(str);
            return builder.reverse().toString();
        }));

        // System.out.println(maximum(l, list -> list.stream().max(Integer::compare).get()));
        System.out.println(maximum(l, list -> list.stream().max(Integer::compare).orElse(0)));

        System.out.println(average(l, list -> list.stream().mapToInt(value -> value).average().orElse(0)));

       // List<String> listString = List.of("String", "average", "maximum", "reverse", "Almaty", "Search", "analyze", "interview", "agent");
       // System.out.println(search(listString, list -> list.stream().filter(str -> str.startsWith("a")).collect(Collectors.toList())));
        
        List<String> listString = List.of("String", "average", "ali", "maximum", "reverse", "Almaty", "Search", "analyze", "interview", "agent", "abc");
        System.out.println(search(listString, list -> list.stream()
                .filter(str ->
                        str.length() == 3 && str.startsWith("a"))
                .collect(Collectors.toList())));
    }

    public static int search(List<Integer> list, Function<List<Integer>, Integer> function) {
        return function.apply(list);
    }

    public static String reverse(String str, Reverse reverse) {
        return reverse.reverse(str);
    }

    public static Integer maximum(List<Integer> list, Function<List<Integer>, Integer> function) {
        return function.apply(list);
    }

    public static Double average(List<Integer> list, Average average) {
        return average.average(list);
    }

    public static List<String> search(List<String> list, ChangeList changeList) {
        return changeList.changeList(list);
    }
}
