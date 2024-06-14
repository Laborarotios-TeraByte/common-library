package io.terabyte.labs.utils.ifc.decorator;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberSampleGeneratorDecorator {
    private static final Faker faker = new Faker();
    private static final Random random = new Random();

    /**
     * Generates a random integer between the specified bounds.
     *
     * @param lowerBound The lower bound (inclusive).
     * @param upperBound The upper bound (exclusive).
     * @return A random integer between lowerBound (inclusive) and upperBound (exclusive).
     */
    public Integer generateInt(int lowerBound, int upperBound) {
        return faker.number().numberBetween(lowerBound, upperBound);
    }

    /**
     * Generates a list of random integers.
     *
     * @param numberOfElements The number of random integers to generate.
     * @param lowerBound The lower bound (inclusive).
     * @param upperBound The upper bound (exclusive).
     * @return A list of random integers between lowerBound (inclusive) and upperBound (exclusive).
     */
    public List<Integer> generateInts(int numberOfElements, int lowerBound, int upperBound) {
        List<Integer> ids = new ArrayList<>();
        for (int i = 0; i < numberOfElements; i++) {
            ids.add(generateInt(lowerBound, upperBound));
        }
        return ids;
    }

    /**
     * Generates a random double between the specified bounds.
     *
     * @param lowerBound The lower bound (inclusive).
     * @param upperBound The upper bound (exclusive).
     * @return A random double between lowerBound (inclusive) and upperBound (exclusive).
     */
    public Double generateDouble(double lowerBound, double upperBound) {
        return random.nextDouble(lowerBound, upperBound);
    }

    /**
     * Generates a list of random doubles.
     *
     * @param numberOfElements The number of random doubles to generate.
     * @param lowerBound The lower bound (inclusive).
     * @param upperBound The upper bound (exclusive).
     * @return A list of random doubles between lowerBound (inclusive) and upperBound (exclusive).
     */
    public List<Double> generateDoubles(int numberOfElements, double lowerBound, double upperBound) {
        List<Double> ids = new ArrayList<>();
        for (int i = 0; i < numberOfElements; i++) {
            ids.add(generateDouble(lowerBound, upperBound));
        }
        return ids;
    }

    /**
     * Generates a random long between the specified bounds.
     *
     * @param lowerBound The lower bound (inclusive).
     * @param upperBound The upper bound (exclusive).
     * @return A random long between lowerBound (inclusive) and upperBound (exclusive).
     */
    public Long generateLong(long lowerBound, long upperBound) {
        return random.nextLong(lowerBound, upperBound);
    }

    /**
     * Generates a list of random longs.
     *
     * @param numberOfElements The number of random longs to generate.
     * @param lowerBound The lower bound (inclusive).
     * @param upperBound The upper bound (exclusive).
     * @return A list of random longs between lowerBound (inclusive) and upperBound (exclusive).
     */
    public List<Long> generateLongs(int numberOfElements, long lowerBound, long upperBound) {
        List<Long> ids = new ArrayList<>();
        for (int i = 0; i < numberOfElements; i++) {
            ids.add(generateLong(lowerBound, upperBound));
        }
        return ids;
    }

    /**
     * Generates a random float between the specified bounds.
     *
     * @param start The start bound (inclusive).
     * @param end The end bound (exclusive).
     * @return A random float between start (inclusive) and end (exclusive).
     */
    public Float generateFloat(float start, float end) {
        return start + random.nextFloat() * (end - start);
    }

    /**
     * Generates a list of random floats.
     *
     * @param numberOfFloats The number of random floats to generate.
     * @param start The start bound (inclusive).
     * @param end The end bound (exclusive).
     * @return A list of random floats between start (inclusive) and end (exclusive).
     */
    public List<Float> generateFloats(int numberOfFloats, float start, float end) {
        List<Float> ids = new ArrayList<>();
        for (int i = 0; i < numberOfFloats; i++) {
            ids.add(generateFloat(start, end));
        }
        return ids;
    }
}
