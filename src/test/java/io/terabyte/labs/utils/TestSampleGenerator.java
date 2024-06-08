package io.terabyte.labs.utils;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

class TestSampleGenerator {

    @Test
    void testSampleGenerator() {
        SampleGenerator.supplyInformation(MyClass.class, 5)
          .forEach(System.out::println);
    }
}

class MyClass {
    private String name;
    private String nameId;
    private int age;
    private boolean isActive;
    private LocalDate birthDate;
    private double salary;
    private String address;
    private List<String> skills;
    private String email;
    private String phoneNumber;
    private String department;
    private LocalDate hireDate;
    private List<Integer> scores;
    private List<Double> prices;
    private List<LocalDate> importantDates;
    private List<String> orderIds;
    private List<String> orderEmails;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
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
          .toString();
    }
}
