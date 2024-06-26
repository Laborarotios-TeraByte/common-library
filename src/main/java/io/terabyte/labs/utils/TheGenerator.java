package io.terabyte.labs.utils;

import com.github.javafaker.Faker;
import io.terabyte.labs.utils.annotation.SampleGenAddress;
import io.terabyte.labs.utils.annotation.SampleGenEmail;
import io.terabyte.labs.utils.annotation.SampleGenId;
import io.terabyte.labs.utils.annotation.SampleGenLocalDate;
import io.terabyte.labs.utils.annotation.SampleGenNumber;
import io.terabyte.labs.utils.annotation.SampleGenPhoneNumber;
import io.terabyte.labs.utils.annotation.SampleGenRandomString;
import io.terabyte.labs.utils.ifc.decorator.NumberSampleGeneratorDecorator;
import io.terabyte.labs.utils.ifc.decorator.StringSampleGeneratorDecorator;
import io.terabyte.labs.utils.model.StringTypeFaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TheGenerator {
    private static final Logger logger = LoggerFactory.getLogger(TheGenerator.class);

    /**
     * Constructs a new TheGenerator instance.
     */
    public TheGenerator() {
        this.numberSampleGeneratorDecorator = new NumberSampleGeneratorDecorator();
        this.stringSampleGeneratorDecorator = new StringSampleGeneratorDecorator();
    }

    private TheGenerator(NumberSampleGeneratorDecorator numberSampleGeneratorDecorator,
                         StringSampleGeneratorDecorator stringSampleGeneratorDecorator) {
        this.numberSampleGeneratorDecorator = numberSampleGeneratorDecorator;
        this.stringSampleGeneratorDecorator = stringSampleGeneratorDecorator;
    }


    private static final Faker faker = new Faker();
    private NumberSampleGeneratorDecorator numberSampleGeneratorDecorator;
    private StringSampleGeneratorDecorator stringSampleGeneratorDecorator;

    /**
     * Supplies a list of populated instances of the specified class.
     *
     * @param <T>              The type of the class.
     * @param clazz            The class to instantiate and populate.
     * @param numberOfElements The number of instances to create.
     * @return A list of populated instances of the specified class.
     */
    public <T> List<T> supplyInformation(Class<T> clazz, int numberOfElements) {
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

    /**
     * Populates the fields of the given instance with generated data based on annotations.
     *
     * @param <T>      The type of the instance.
     * @param instance The instance to populate.
     */
    private <T> void populateFields(T instance) {
        Field[] fields = instance.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.isAnnotationPresent(SampleGenEmail.class)) {
                    if (field.getType() == List.class) {
                        field.set(instance, stringSampleGeneratorDecorator.generateEmailList(10));
                    } else {
                        field.set(instance, stringSampleGeneratorDecorator.generateEmail());
                    }
                } else if (field.isAnnotationPresent(SampleGenId.class)) {
                    if (field.getType() == String.class) {
                        field.set(instance, stringSampleGeneratorDecorator.generateUUID());
                    } else if (field.getType() == int.class || field.getType() == Integer.class) {
                        SampleGenId idAnnotation = field.getAnnotation(SampleGenId.class);
                        int start = idAnnotation.start();
                        int end = idAnnotation.end();
                        field.set(instance, numberSampleGeneratorDecorator.generateInt(start, end));
                    } else if (field.getType() == List.class) {
                        ParameterizedType listType = (ParameterizedType) field.getGenericType();
                        Class<?> listClass = (Class<?>) listType.getActualTypeArguments()[0];
                        if (listClass == String.class) {
                            field.set(instance, stringSampleGeneratorDecorator.generateUUIDList(12));
                        } else if (listClass == Integer.class) {
                            SampleGenId idAnnotation = field.getAnnotation(SampleGenId.class);
                            int start = idAnnotation.start();
                            int end = idAnnotation.end();
                            field.set(instance, numberSampleGeneratorDecorator.generateInts(12, start, end));
                        }
                    }
                } else if (field.isAnnotationPresent(SampleGenAddress.class)) {
                    SampleGenAddress sampleGenAddress = field.getAnnotation(SampleGenAddress.class);
                    if (field.getType() == List.class) {
                        int numberOfAddresses = sampleGenAddress.numberOfAddresses();
                        field.set(instance, stringSampleGeneratorDecorator.generateAddressList(numberOfAddresses));
                    } else {
                        field.set(instance, stringSampleGeneratorDecorator.generateAddress());
                    }
                } else if (field.isAnnotationPresent(SampleGenNumber.class)) {
                    SampleGenNumber numberAnnotation = field.getAnnotation(SampleGenNumber.class);
                    double start = numberAnnotation.start();
                    double end = numberAnnotation.end();
                    switch (numberAnnotation.type()) {
                        case INT:
                            if (field.getType() == List.class) {
                                field.set(instance, numberSampleGeneratorDecorator.generateInts(12, (int) start, (int) end));
                            } else {
                                field.set(instance, numberSampleGeneratorDecorator.generateInt((int) start, (int) end));
                            }
                            break;
                        case FLOAT:
                            if (field.getType() == List.class) {
                                field.set(instance, numberSampleGeneratorDecorator.generateFloats(12, (float) start, (float) end));
                            } else {
                                field.set(instance, numberSampleGeneratorDecorator.generateFloat((float) start, (float) end));
                            }
                            break;
                        case DOUBLE:
                            if (field.getType() == List.class) {
                                field.set(instance, numberSampleGeneratorDecorator.generateDoubles(12, start, end));
                            } else {
                                field.set(instance, numberSampleGeneratorDecorator.generateDouble(start, end));
                            }
                            break;
                        case LONG:
                            if (field.getType() == List.class) {
                                field.set(instance, numberSampleGeneratorDecorator.generateLongs(12, (long) start, (long) end));
                            } else {
                                field.set(instance, numberSampleGeneratorDecorator.generateLong((long) start, (long) end));
                            }
                            break;
                    }
                } else if (field.isAnnotationPresent(SampleGenPhoneNumber.class)) {
                    SampleGenPhoneNumber sampleGenPhoneNumber = field.getAnnotation(SampleGenPhoneNumber.class);
                    int numberOfPhones = sampleGenPhoneNumber.numberOfPhones();
                    switch (sampleGenPhoneNumber.type()) {
                        case PHONE:
                            if (field.getType() == List.class) {
                                field.set(instance, stringSampleGeneratorDecorator.generatePhoneNumbers(numberOfPhones));
                            } else {
                                field.set(instance, stringSampleGeneratorDecorator.generatePhoneNumber());
                            }
                            break;
                        case CELL_PHONE:
                            if (field.getType() == List.class) {
                                field.set(instance, stringSampleGeneratorDecorator.generateCellPhoneNumbers(12));
                            } else {
                                field.set(instance, stringSampleGeneratorDecorator.generateCellPhoneNumber());
                            }
                            break;
                    }
                } else if (field.isAnnotationPresent(SampleGenRandomString.class)) {
                    SampleGenRandomString sampleGenRandomString = field.getAnnotation(SampleGenRandomString.class);
                    StringTypeFaker stringTypeFaker = sampleGenRandomString.typeFakerGenerator();
                    if (field.getType() == List.class) {
                        int numberOfElements = sampleGenRandomString.numberOfElements();
                        field.set(instance, stringSampleGeneratorDecorator.generateRandomStrings(numberOfElements, stringTypeFaker));
                    } else {
                        field.set(instance, stringSampleGeneratorDecorator.generateRandomString(stringTypeFaker));
                    }
                } else if (field.getType() == boolean.class || field.getType() == Boolean.class) {
                    field.set(instance, faker.bool().bool());
                } else if (field.isAnnotationPresent(SampleGenLocalDate.class)) {
                    SampleGenLocalDate sampleGenLocalDate = field.getAnnotation(SampleGenLocalDate.class);
                    int numberOfElements = sampleGenLocalDate.numberOfElements();
                    if (field.getType() == List.class) {
                        field.set(instance, generateLocalDates(numberOfElements));
                    } else {
                        field.set(instance, generateLocalDate());
                    }
                }
            } catch (Exception e) {
                logger.error("Error Al setear field {}", field.getName());
            }
        }
    }

    /**
     * Generates a list of random LocalDate instances.
     *
     * @param numOfLocalDates The number of LocalDate instances to generate.
     * @return A list of random LocalDate instances.
     */
    private List<LocalDate> generateLocalDates(int numOfLocalDates) {
        List<LocalDate> dates = new ArrayList<>();
        for (int i = 0; i < numOfLocalDates; i++) {
            dates.add(generateLocalDate());
        }
        return dates;
    }

    /**
     * Generates a random LocalDate instance.
     *
     * @return A random LocalDate instance.
     */
    public static LocalDate generateLocalDate() {
        Date birthday = faker.date().birthday();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthday);
        return LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
    }

    public static class Builder {
        private NumberSampleGeneratorDecorator numberSampleGeneratorDecorator = new NumberSampleGeneratorDecorator();
        private StringSampleGeneratorDecorator stringSampleGeneratorDecorator = new StringSampleGeneratorDecorator();

        public Builder withNumberSampleGeneratorDecorator(NumberSampleGeneratorDecorator numberSampleGeneratorDecorator) {
            this.numberSampleGeneratorDecorator = numberSampleGeneratorDecorator;
            return this;
        }

        public Builder withStringSampleGeneratorDecorator(StringSampleGeneratorDecorator stringSampleGeneratorDecorator) {
            this.stringSampleGeneratorDecorator = stringSampleGeneratorDecorator;
            return this;
        }

        public TheGenerator build() {
            return new TheGenerator(numberSampleGeneratorDecorator, stringSampleGeneratorDecorator);
        }

        public TheGenerator buildWithDefaults() {
            return new TheGenerator(new NumberSampleGeneratorDecorator(), new StringSampleGeneratorDecorator());
        }
    }

}