package com.seungho.demojunit5.methodScope;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.ThrowingConsumer;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class FactoryTest {

    @TestFactory
    Collection<DynamicTest> dynamicTestsFromCollection() {
        return Arrays.asList(
                dynamicTest("1st dynamic test", () -> assertTrue(true)),
                dynamicTest("2nd dynamic test", () -> assertEquals(4, 2 * 2))
        );
    }

    @TestFactory
    Stream<DynamicTest> generateRandomNumberOfTests() {

        Iterator<Integer> inputGenerator = new Iterator<Integer>() {

            final Random random = new Random();
            int current;

            @Override
            public boolean hasNext() {
                current = random.nextInt(100);
                return current % 7 != 0;
            }

            @Override
            public Integer next() {
                return current;
            }
        };

        Function<Integer, String> displayNameGenerator = (input) -> "input:" + input;

        ThrowingConsumer<Integer> testExecutor = (input) -> assertTrue(input % 7 != 0);

        return DynamicTest.stream(inputGenerator, displayNameGenerator, testExecutor);
    }

    @TestFactory
    Stream<DynamicTest> test() {
        class TestTemplate {
            final String name;
            final int age;

            public TestTemplate(String name, int age) {
                this.name = name;
                this.age = age;
            }
        }

        return Stream.of(
                new TestTemplate("Seung", 19),
                new TestTemplate("Ho", 20)
        ).map(e -> dynamicTest("test" + e.name, () -> {
            assertTrue(e.age > 18, e.name + "'s age");
        }));
    }

}
