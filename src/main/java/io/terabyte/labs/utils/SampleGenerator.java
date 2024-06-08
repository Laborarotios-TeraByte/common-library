package io.terabyte.labs.utils;

import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class SampleGenerator {
    private static final Logger logger = LoggerFactory.getLogger(SampleGenerator.class);

    private SampleGenerator() {
    }

    private static final Faker faker = new Faker();
    private static final Random random = new Random();
    private static final int DEFAULT_NUMBER_OF_ELEMENTS = 10;

    public static <T> List<T> supplyInformation(Class<T> clazz, int numberOfElements) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < numberOfElements; i++) {
            try {
                T instance = clazz.getDeclaredConstructor().newInstance();
                populateFields(instance);
                list.add(instance);
            } catch (Exception e) {
                logger.error("Error Al generar POJO: {}", e.getMessage());
            }
        }
        return list;
    }

    private static <T> void populateFields(T instance) {
        Field[] fields = instance.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.getType() == String.class) {
                    field.set(instance, generateString(field.getName()));
                } else if (field.getType() == int.class || field.getType() == Integer.class) {
                    field.set(instance, getNumberBetween(1, 25000));
                } else if (field.getType() == long.class || field.getType() == Long.class) {
                    field.set(instance, getNumberBetween(1, 25000));
                } else if (field.getType() == double.class || field.getType() == Double.class) {
                    field.set(instance, faker.number().randomNumber());
                } else if (field.getType() == boolean.class || field.getType() == Boolean.class) {
                    field.set(instance, faker.bool().bool());
                } else if (field.getType() == LocalDate.class) {
                    field.set(instance, generateLocalDate()); // Date in the last 40 years
                } else if (field.getType() == List.class) {
                    ParameterizedType listType = (ParameterizedType) field.getGenericType();
                    Class<?> listClass = (Class<?>) listType.getActualTypeArguments()[0];
                    if (listClass == String.class) {
                        field.set(instance, generateListOfStrings(field.getName(), 5));
                    } else if (listClass == Integer.class) {
                        field.set(instance, generateListOfInteger(12));
                    } else if (listClass == Double.class) {
                        field.set(instance, generateListOfDoubles(11));
                    } else if (listClass == LocalDate.class) {
                        field.set(instance, generateListOfTemporals(6));
                    }
                }
            } catch (Exception e) {
                logger.error("Error Al setear field {}", field.getName());
            }
        }
    }

    private static String generateString(String fieldName) {
        if (fieldName.toLowerCase().contains("id")) {
            return faker.internet().uuid();
        } else if (fieldName.toLowerCase().contains("email")) {
            return faker.internet().emailAddress();
        } else if (fieldName.toLowerCase().contains("address")) {
            return faker.address().fullAddress();
        } else {
            return getRandomStringFromFaker();
        }
    }

    public static List<Double> generateListOfDoubles(int numberOfElements) {
        if (numberOfElements <= 0) {
            numberOfElements = DEFAULT_NUMBER_OF_ELEMENTS;
        }
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < numberOfElements; i++) {
            list.add(random.nextDouble(-25000, 25000));
        }
        return list;
    }

    public static List<Integer> generateListOfInteger(int numberOfElements) {
        if (numberOfElements <= 0) {
            numberOfElements = DEFAULT_NUMBER_OF_ELEMENTS;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numberOfElements; i++) {
            list.add(getNumberBetween(-25000, 25000));
        }
        return list;
    }

    public static List<String> generateListOfStrings(String fieldName, int numberOfElements) {
        if (numberOfElements <= 0) {
            numberOfElements = DEFAULT_NUMBER_OF_ELEMENTS;
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < numberOfElements; i++) {
            list.add(generateString(fieldName));
        }
        return list;
    }

    public static List<LocalDate> generateListOfTemporals(int numberOfElements) {
        if (numberOfElements <= 0) {
            numberOfElements = DEFAULT_NUMBER_OF_ELEMENTS;
        }
        List<LocalDate> list = new ArrayList<>();
        for (int i = 0; i < numberOfElements; i++) {
            list.add(generateLocalDate());
        }
        return list;
    }

    public static int getNumberBetween(int lowerBound, int upperBound) {
        return faker.number().numberBetween(lowerBound, upperBound);
    }

    public static LocalDate generateLocalDate() {
        Date birthday = faker.date().birthday();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthday);
        return LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
    }

    public static String getRandomStringFromFaker() {
        int choice = random.nextInt(20);
        if (choice == 0) {
            return faker.artist().name();
        } else if (choice == 1) {
            return faker.ancient().hero();
        } else if (choice == 2) {
            return faker.animal().name();
        } else if (choice == 3) {
            return faker.app().name();
        } else if (choice == 4) {
            return faker.book().title();
        } else if (choice == 5) {
            return faker.book().author();
        } else if (choice == 6) {
            return faker.ancient().god();
        } else if (choice == 7) {
            return faker.aviation().aircraft();
        } else if (choice == 8) {
            return faker.aviation().airport();
        } else if (choice == 9) {
            return faker.beer().name();
        } else if (choice == 10) {
            return faker.cat().name();
        } else if (choice == 11) {
            return faker.cat().breed();
        } else if (choice == 12) {
            return faker.company().name();
        } else  {
            return faker.company().catchPhrase();
        }
    }
}
