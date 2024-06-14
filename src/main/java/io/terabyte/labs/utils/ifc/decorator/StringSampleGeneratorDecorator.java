package io.terabyte.labs.utils.ifc.decorator;

import com.github.javafaker.Faker;
import io.terabyte.labs.utils.model.StringTypeFaker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StringSampleGeneratorDecorator {
    private Faker faker = new Faker();
    private Random random = new Random();

    /**
     * Generates a random email address.
     *
     * @return A random email address.
     */
    public String generateEmail() {
        return faker.internet().emailAddress();
    }

    /**
     * Generates a list of random email addresses.
     *
     * @param numberOfEmails The number of email addresses to generate.
     * @return A list of random email addresses.
     */
    public List<String> generateEmailList(int numberOfEmails) {
        List<String> emails = new ArrayList<>();
        for (int i = 0; i < numberOfEmails; i++) {
            emails.add(generateEmail());
        }
        return emails;
    }

    /**
     * Generates a random UUID.
     *
     * @return A random UUID.
     */
    public String generateUUID() {
        return faker.internet().uuid();
    }

    /**
     * Generates a random address.
     *
     * @return A random address.
     */
    public String generateAddress() {
        return faker.address().fullAddress();
    }

    /**
     * Generates a random phone number.
     *
     * @return A random phone number.
     */
    public String generatePhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }

    /**
     * Generates a random cell phone number.
     *
     * @return A random cell phone number.
     */
    public String generateCellPhoneNumber() {
        return faker.phoneNumber().cellPhone();
    }

    /**
     * Generates a random string based on the specified type.
     *
     * @param stringTypeFaker The type of string to generate.
     * @return A random string of the specified type.
     */
    public String generateRandomString(StringTypeFaker stringTypeFaker) {

        switch (stringTypeFaker) {
            case CAT_NAME -> {
                return faker.cat().name();
            }
            case BEER_NAME -> {
                return faker.beer().name();
            }
            case BOOK_ISBN_10 -> {
                return faker.code().isbn10(true);
            }
            case ANCIENT_GOD -> {
                return faker.ancient().god();
            }
            case ANIMAL_NAME -> {
                return faker.animal().name();
            }
            case ARTIST_NAME -> {
                return faker.artist().name();
            }
            case BOOK_AUTHOR -> {
                return faker.book().author();
            }
            case BOOK_TITTLE -> {
                return faker.book().title();
            }
            case ANCIENT_HERO -> {
                return faker.ancient().hero();
            }
            case BOOK_ISBN_13 -> {
                return faker.code().isbn13(true);
            }
            case COMPANY_NAME -> {
                return faker.company().name();
            }
            case APPLICATION_NAME -> {
                return faker.app().name();
            }
            case AVIATION_AIRPORT -> {
                return faker.aviation().airport();
            }
            case AVIATION_AIRCRAFT -> {
                return faker.aviation().aircraft();
            }
            case COMPANY_CATCH_PHRASE -> {
                return faker.company().catchPhrase();
            }
            default -> {
                return faker.aquaTeenHungerForce().character();
            }
        }
    }

    /**
     * Generates a list of random UUIDs.
     *
     * @param numberOfUUIDs The number of UUIDs to generate.
     * @return A list of random UUIDs.
     */
    public List<String> generateUUIDList(int numberOfUUIDs) {
        List<String> uuids = new ArrayList<>();
        for (int i = 0; i < numberOfUUIDs; i++) {
            uuids.add(generateUUID());
        }
        return uuids;
    }

    /**
     * Generates a list of random addresses.
     *
     * @param numberOfAddresses The number of addresses to generate.
     * @return A list of random addresses.
     */
    public List<String> generateAddressList(int numberOfAddresses) {
        List<String> addresses = new ArrayList<>();
        for (int i = 0; i < numberOfAddresses; i++) {
            addresses.add(generateAddress());
        }
        return addresses;
    }

    /**
     * Generates a list of random phone numbers.
     *
     * @param numberOfPhones The number of phone numbers to generate.
     * @return A list of random phone numbers.
     */
    public List<String> generatePhoneNumbers(int numberOfPhones) {
        List<String> phoneNumbers = new ArrayList<>();
        for (int i = 0; i < numberOfPhones; i++) {
            phoneNumbers.add(generatePhoneNumber());
        }
        return phoneNumbers;
    }

    /**
     * Generates a list of random cell phone numbers.
     *
     * @param numberOfCells The amount cell phone numbers to generate.
     * @return A list of random cell phone numbers.
     */
    public List<String> generateCellPhoneNumbers(int numberOfCells) {
        List<String> phoneNumbers = new ArrayList<>();
        for (int i = 0; i < numberOfCells; i++) {
            phoneNumbers.add(generateCellPhoneNumber());
        }
        return phoneNumbers;
    }

    /**
     * Generates a list of random strings based on the specified type.
     *
     * @param numberOfStrs    The number of strings to generate.
     * @param stringTypeFaker The type of string to generate.
     * @return A list of random strings of the specified type.
     */
    public List<String> generateRandomStrings(int numberOfStrs, StringTypeFaker stringTypeFaker) {
        List<String> strs = new ArrayList<>();
        for (int i = 0; i < numberOfStrs; i++) {
            strs.add(generateRandomString(stringTypeFaker));
        }
        return strs;
    }
}
