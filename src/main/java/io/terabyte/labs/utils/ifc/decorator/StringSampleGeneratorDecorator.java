package io.terabyte.labs.utils.ifc.decorator;

import com.github.javafaker.Faker;
import io.terabyte.labs.utils.model.StringTypeFaker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StringSampleGeneratorDecorator {
    private Faker faker = new Faker();
    private Random random = new Random();
    public String generateEmail() {
        return faker.internet().emailAddress();
    }

    public List<String> generateEmailList(int numberOfEmails) {
        List<String> emails = new ArrayList<>();
        for (int i = 0; i < numberOfEmails; i++) {
            emails.add(generateEmail());
        }
        return emails;
    }

    public String generateUUID() {
        return faker.internet().uuid();
    }

    public String generateAddress() {
        return faker.address().fullAddress();
    }

    public String generatePhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }

    public String generateCellPhoneNumber() {
        return faker.phoneNumber().cellPhone();
    }

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

    public List<String> generateUUIDList(int numberOfUUIDs) {
        List<String> uuids = new ArrayList<>();
        for (int i = 0; i < numberOfUUIDs; i++) {
            uuids.add(generateUUID());
        }
        return uuids;
    }

    public List<String> generateAddressList(int numberOfAddresses) {
        List<String> addresses = new ArrayList<>();
        for (int i = 0; i < numberOfAddresses; i++) {
            addresses.add(generateAddress());
        }
        return addresses;
    }

    public List<String> generatePhoneNumbers(int numberOfPhones) {
        List<String> phoneNumbers = new ArrayList<>();
        for (int i = 0; i < numberOfPhones; i++) {
            phoneNumbers.add(generatePhoneNumber());
        }
        return phoneNumbers;
    }

    public List<String> generateCellPhoneNumbers(int numberOfCells) {
        List<String> phoneNumbers = new ArrayList<>();
        for (int i = 0; i < numberOfCells; i++) {
            phoneNumbers.add(generateCellPhoneNumber());
        }
        return phoneNumbers;
    }

    public List<String> generateRandomStrings(int numberOfStrs, StringTypeFaker stringTypeFaker) {
        List<String> strs = new ArrayList<>();
        for (int i = 0; i < numberOfStrs; i++) {
            strs.add(generateRandomString(stringTypeFaker));
        }
        return strs;
    }
}
