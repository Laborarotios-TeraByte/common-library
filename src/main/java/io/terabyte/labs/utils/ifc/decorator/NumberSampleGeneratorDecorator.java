package io.terabyte.labs.utils.ifc.decorator;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberSampleGeneratorDecorator {
    private static final Faker faker = new Faker();
    private static final Random random = new Random();

    public Integer generateInt(int lowerBound, int upperBound) {
        return faker.number().numberBetween(lowerBound, upperBound);
    }

    public List<Integer> generateInts(int numberOfElements, int lowerBound, int upperBound) {
        List<Integer> ids = new ArrayList<>();
        for (int i = 0; i < numberOfElements; i++) {
            ids.add(generateInt(lowerBound, upperBound));
        }
        return ids;
    }

    public Double generateDouble(double lowerBound, double upperBound) {
        return random.nextDouble(lowerBound, upperBound);
    }

    public List<Double> generateDoubles(int numberOfElements, double lowerBound, double upperBound) {
        List<Double> ids = new ArrayList<>();
        for (int i = 0; i < numberOfElements; i++) {
            ids.add(generateDouble(lowerBound, upperBound));
        }
        return ids;
    }

    public Long generateLong(long lowerBound, long upperBound) {
        return random.nextLong(lowerBound, upperBound);
    }

    public List<Long> generateLongs(int numberOfElements, long lowerBound, long upperBound) {
        List<Long> ids = new ArrayList<>();
        for (int i = 0; i < numberOfElements; i++) {
            ids.add(generateLong(lowerBound, upperBound));
        }
        return ids;
    }

    public Float generateFloat(float start, float end) {
        return start + random.nextFloat() * (end - start);
    }

    public List<Float> generateFloats(int numberOfFloats, float start, float end) {
        List<Float> ids = new ArrayList<>();
        for (int i = 0; i < numberOfFloats; i++) {
            ids.add(generateFloat(start, end));
        }
        return ids;
    }
}
