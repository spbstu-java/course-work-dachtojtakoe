package course.packets.lab4;

import java.util.*;
import java.util.stream.Collectors;

public class StreamClass {
    public static double getAverage(List<Integer> numbers){
        return numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public static List<String> strToUpperPrefix(List<String> strings){
        return strings.stream().map(str->"_new_" + str.toUpperCase()).toList();
    }

    public static List<Integer> squareSingleNumber(List<Integer> numbers){
        return numbers.stream()
                .filter(number-> Collections.frequency(numbers, number) == 1)
                .map(number -> number*number).toList();
    }

    public static <T> T getLastElement(Collection<T> collection) throws  NoSuchElementException {
        return collection.stream().reduce((first, second) -> second)
                .orElseThrow(() -> new NoSuchElementException("Коллекция пуста"));
    }

    public static int getEvenSum(int[] numbers){
        return Arrays.stream(numbers).filter(number -> number % 2 == 0).sum();
    }

    public static Map<Character, String> getStringsMap(List<String> strings){
        return strings.stream().filter(string -> !string.isEmpty())
                .collect(Collectors.toMap(string -> string.charAt(0),
                        string -> string.length() > 1 ? string.substring(1) : "",
                        (existing, replacement) -> existing));
    }
}
