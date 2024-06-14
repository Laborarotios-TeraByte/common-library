# Sample Generator Utilities

This project contains classes and annotations to generate random sample data for various types of fields, including numbers, strings, emails, addresses, and more. It leverages the `Faker` library to generate realistic and random data.

## Classes

### NumberSampleGeneratorDecorator

The `NumberSampleGeneratorDecorator` class provides methods to generate random numbers of various types within specified bounds.

#### Methods

- `Integer generateInt(int lowerBound, int upperBound)`
    - Generates a random integer between the specified bounds.

- `List<Integer> generateInts(int numberOfElements, int lowerBound, int upperBound)`
    - Generates a list of random integers.

- `Double generateDouble(double lowerBound, double upperBound)`
    - Generates a random double between the specified bounds.

- `List<Double> generateDoubles(int numberOfElements, double lowerBound, double upperBound)`
    - Generates a list of random doubles.

- `Long generateLong(long lowerBound, long upperBound)`
    - Generates a random long between the specified bounds.

- `List<Long> generateLongs(int numberOfElements, long lowerBound, long upperBound)`
    - Generates a list of random longs.

- `Float generateFloat(float start, float end)`
    - Generates a random float between the specified bounds.

- `List<Float> generateFloats(int numberOfFloats, float start, float end)`
    - Generates a list of random floats.

### StringSampleGeneratorDecorator

The `StringSampleGeneratorDecorator` class provides methods to generate random strings, including email addresses, UUIDs, addresses, phone numbers, and more.

#### Methods

- `String generateEmail()`
    - Generates a random email address.

- `List<String> generateEmailList(int numberOfEmails)`
    - Generates a list of random email addresses.

- `String generateUUID()`
    - Generates a random UUID.

- `String generateAddress()`
    - Generates a random address.

- `String generatePhoneNumber()`
    - Generates a random phone number.

- `String generateCellPhoneNumber()`
    - Generates a random cell phone number.

- `String generateRandomString(StringTypeFaker stringTypeFaker)`
    - Generates a random string based on the specified type.

- `List<String> generateUUIDList(int numberOfUUIDs)`
    - Generates a list of random UUIDs.

- `List<String> generateAddressList(int numberOfAddresses)`
    - Generates a list of random addresses.

- `List<String> generatePhoneNumbers(int numberOfPhones)`
    - Generates a list of random phone numbers.

- `List<String> generateCellPhoneNumbers(int numberOfCells)`
    - Generates a list of random cell phone numbers.

- `List<String> generateRandomStrings(int numberOfStrs, StringTypeFaker stringTypeFaker)`
    - Generates a list of random strings based on the specified type.

### TheGenerator

The `TheGenerator` class utilizes the decorators and annotations to populate fields of objects with random data.

#### Methods

- `TheGenerator()`
    - Constructs a new TheGenerator instance.

- `<T> List<T> supplyInformation(Class<T> clazz, int numberOfElements)`
    - Supplies a list of populated instances of the specified class.

- `<T> void populateFields(T instance)`
    - Populates the fields of the given instance with generated data based on annotations.

- `List<LocalDate> generateLocalDates(int numOfLocalDates)`
    - Generates a list of random LocalDate instances.

- `LocalDate generateLocalDate()`
    - Generates a random LocalDate instance.

### Annotations

#### SampleGenAddress

The `@SampleGenAddress` annotation is used to indicate that a field should be populated with a generated address.

#### SampleGenEmail

The `@SampleGenEmail` annotation is used to indicate that a field should be populated with a generated email address.

#### SampleGenId

The `@SampleGenId` annotation is used to indicate that a field should be populated with a generated ID.

#### SampleGenLocalDate

The `@SampleGenLocalDate` annotation is used to indicate that a field should be populated with a generated LocalDate.

#### SampleGenNumber

The `@SampleGenNumber` annotation is used to indicate that a field should be populated with a generated number.

#### SampleGenPhoneNumber

The `@SampleGenPhoneNumber` annotation is used to indicate that a field should be populated with a generated phone number.

#### SampleGenRandomString

The `@SampleGenRandomString` annotation is used to indicate that a field should be populated with a generated random string.

## Usage

To use these classes and annotations, include the `Faker` library in your project and annotate the fields you want to populate with sample data. Use the decorators and `TheGenerator` class to generate random values and populate objects.

### Example

```java
public class ExampleClass {
    @SampleGenEmail
    private String email;

    @SampleGenId
    private int id;

    @SampleGenAddress
    private String address;

    @SampleGenPhoneNumber
    private String phoneNumber;
}

public class Main {
    public static void main(String[] args) {
        TheGenerator generator = new TheGenerator();
        List<ExampleClass> examples = generator.supplyInformation(ExampleClass.class, 10);
        examples.forEach(System.out::println);
    }
}
```