package com.robosh;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


public class MainTest {

    @Test
    public void shouldReturnNumeratedOddNames(){
        List<String> names = Arrays.asList("Sasha", "Orest", "Nikita", "Ivan", "Peter");
        String result = "1. Sasha, 3. Nikita, 5. Peter";
        assertEquals(result, Main.task1(names));
    }

    @Test
    public void shouldReturnListToUppercaseAndSortedByDescending(){
        List<String> strList = Arrays.asList("Alexandr", "Bogdan", "Yaroslav");
        List<String> result = Arrays.asList("YAROSLAV", "BOGDAN", "ALEXANDR");
        assertEquals(result, Main.task2(strList));
    }

    @Test
    public void shouldReturnParseNumberIntoStringArray(){
        Collection<String> collection = Arrays.asList("1, 2, 0", "4, 5");
        String[] result = {"1", "2", "0", "4", "5"};
        assertThat(result, equalTo(Main.task3(collection)));
    }

    @Test
    public void shouldGenerateRandomNumbers(){
        long a = 25_214_903_917L;
        long c = 11L;
        long m = 2 ^ 47;
        long seed = 0;
        long limit = 10;

        List<Long> firstAray =Main.task4(a, c, m, seed).limit(limit).collect(Collectors.toList());
        List<Long> secondArray = Main.task4(a, c, m, seed).limit(limit).collect(Collectors.toList());
        assertEquals(firstAray, secondArray);
    }
    @Test
    public void shouldUnionElementsFromStreamsAndFinishWhenOneIsEmpty(){
        Stream<Integer> firstStream = IntStream.iterate(1, (i) -> i+2).limit(5).boxed();
        Stream<Integer> secondStream = IntStream.iterate(2, (i) -> i+2).limit(10).boxed();
        Stream<Integer> rightStream = IntStream.iterate(1, (i) -> i+1).limit(10).boxed();
        Stream<Integer> resultStream = Main.zip(firstStream, secondStream);
        assertThat(rightStream.collect(Collectors.toList()), equalTo(resultStream.collect(Collectors.toList())));
    }
}