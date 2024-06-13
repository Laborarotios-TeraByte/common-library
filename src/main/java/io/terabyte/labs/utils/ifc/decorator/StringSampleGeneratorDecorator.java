package io.terabyte.labs.utils.ifc.decorator;

import com.github.javafaker.Faker;

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

    public String generateRandomString() {
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
        } else {
            return faker.company().catchPhrase();
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

    public List<String> generateRandomStrings(int numberOfStrs) {
        List<String> strs = new ArrayList<>();
        for (int i = 0; i < numberOfStrs; i++) {
            strs.add(generateRandomString());
        }
        return strs;
    }
}
