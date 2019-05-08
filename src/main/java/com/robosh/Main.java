package com.robosh;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Sasha");
        names.add("Orest");
        names.add("Nikita");
        names.add("Ivan");
        names.add("Peter");
        System.out.println(task1(names));
        System.out.println(task2(names));
        Collection<String> collection = Arrays.asList("1, 2, 0", "4, 5");
        System.out.println(Arrays.toString(task3(collection)));
        task4(25_214_903_917L, 11L, 2 ^ 48, 0).limit(5).forEach(element -> System.out.print(element + " "));
        System.out.println();
        zip(names.stream(), collection.stream()).forEach(element -> System.out.print(element + " "));
        System.out.println();
    }

    public static String task1(List<String> strList) {
        return IntStream.range(0, strList.size())
                .filter((i) -> i % 2 == 0)
                .mapToObj((i) -> (i + 1) + ". " + strList.get(i))
                .collect(Collectors.joining(", "));
    }

    public static List<String> task2(List<String> strList) {
        return strList.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public static String[] task3(Collection<String> collection) {
        return collection.stream()
                .flatMap((s) -> Arrays.stream(s.split(", ")))
                .toArray(String[]::new);
    }

    public static Stream<Long> task4(long a, long c, long m, long seed) {
        return Stream.iterate(seed, x -> (a * x + c) % m);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();
        //Stream.iterate(0, x -> Math.toIntExact(Math.min(first.count(), second.count()) * 2))
        //return Stream.concat(Stream.of(firstIterator.next()), Stream.of(secondIterator.next()));
        Stream<T> concatStream = Stream.empty();
        while (firstIterator.hasNext() && secondIterator.hasNext()) {
            concatStream = Stream.concat(concatStream, Stream.of(firstIterator.next(), secondIterator.next()));
        }
        return concatStream;

    }
}
