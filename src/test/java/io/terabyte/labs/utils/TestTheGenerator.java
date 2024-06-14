package io.terabyte.labs.utils;

import io.terabyte.labs.utils.annotation.SampleGenAddress;
import io.terabyte.labs.utils.annotation.SampleGenEmail;
import io.terabyte.labs.utils.annotation.SampleGenId;
import io.terabyte.labs.utils.annotation.SampleGenLocalDate;
import io.terabyte.labs.utils.annotation.SampleGenNumber;
import io.terabyte.labs.utils.annotation.SampleGenPhoneNumber;
import io.terabyte.labs.utils.annotation.SampleGenRandomString;
import io.terabyte.labs.utils.model.StringTypeFaker;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

class TestTheGenerator {

    @Test
    void testSampleGenerator() {
        TheGenerator generator = new TheGenerator();
        generator.supplyInformation(MyClass.class, 5)
          .forEach(System.out::println);
    }
}

class MyClass {
    @SampleGenId(start = 1000, end = 9999)
    private int id;

    @SampleGenRandomString
    private String name;

    @SampleGenId
    private String nameId;
    @SampleGenNumber(type = SampleGenNumber.NumberType.INT, start = 0, end = 99)
    private int age;
    private boolean isActive;
    @SampleGenLocalDate
    private LocalDate birthDate;
    @SampleGenNumber(type = SampleGenNumber.NumberType.DOUBLE, start = 5000.0, end = 25000.2)
    private double salary;
    @SampleGenAddress
    private String address;
    @SampleGenRandomString(numberOfElements = 5)
    private List<String> skills;
    @SampleGenRandomString(numberOfElements = 5, typeFakerGenerator = StringTypeFaker.ARTIST_NAME)
    private List<String> employeeNames;
    @SampleGenRandomString(numberOfElements = 3, typeFakerGenerator = StringTypeFaker.BOOK_ISBN_13)
    private List<String> isbns;

    @SampleGenEmail
    private String email;

    @SampleGenPhoneNumber
    private String phoneNumber;
    @SampleGenRandomString
    private String department;
    @SampleGenLocalDate
    private LocalDate hireDate;
    @SampleGenNumber(type = SampleGenNumber.NumberType.INT, start = 0, end = 10)
    private List<Integer> scores;
    @SampleGenNumber(type = SampleGenNumber.NumberType.DOUBLE, start = 1.0, end = 34000.4)
    private List<Double> prices;
    @SampleGenLocalDate(numberOfElements = 3)
    private List<LocalDate> importantDates;
    @SampleGenId
    private List<String> orderIds;
    @SampleGenEmail
    private List<String> orderEmails;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
          .append("id", id)
          .append("name", name)
          .append("nameId", nameId)
          .append("age", age)
          .append("isActive", isActive)
          .append("birthDate", birthDate)
          .append("salary", salary)
          .append("address", address)
          .append("skills", skills)
          .append("email", email)
          .append("phoneNumber", phoneNumber)
          .append("department", department)
          .append("hireDate", hireDate)
          .append("scores", scores)
          .append("prices", prices)
          .append("importantDates", importantDates)
          .append("orderIds", orderIds)
          .append("orderEmails", orderEmails)
          .append("employeeNames", employeeNames)
          .append("isbns", isbns)
          .toString();
    }
}
