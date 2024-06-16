package io.terabyte.labs.utils;

import io.terabyte.labs.utils.annotation.SampleGenAddress;
import io.terabyte.labs.utils.annotation.SampleGenEmail;
import io.terabyte.labs.utils.annotation.SampleGenId;
import io.terabyte.labs.utils.annotation.SampleGenLocalDate;
import io.terabyte.labs.utils.annotation.SampleGenNumber;
import io.terabyte.labs.utils.annotation.SampleGenPhoneNumber;
import io.terabyte.labs.utils.annotation.SampleGenRandomString;
import io.terabyte.labs.utils.model.StringTypeFaker;
import io.terabyte.labs.utils.model.TelephoneType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

class TestTheGenerator {

    @Test
    void testSampleGenerator() {
        TheGenerator generator = new TheGenerator.Builder().buildWithDefaults();
        List<MyClass> myClasses = generator.supplyInformation(MyClass.class, 5);
        Assertions.assertNotNull(myClasses);
        Assertions.assertEquals(5, myClasses.size());
        Assertions.assertInstanceOf(MyClass.class, myClasses.get(0));
        Assertions.assertInstanceOf(Integer.class, myClasses.get(0).getId());
        Assertions.assertTrue(myClasses.get(0).getId() >= 1000);
        Assertions.assertTrue(myClasses.get(0).getId() <= 9999);
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameId() {
        return nameId;
    }

    public void setNameId(String nameId) {
        this.nameId = nameId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getEmployeeNames() {
        return employeeNames;
    }

    public void setEmployeeNames(List<String> employeeNames) {
        this.employeeNames = employeeNames;
    }

    public List<String> getIsbns() {
        return isbns;
    }

    public void setIsbns(List<String> isbns) {
        this.isbns = isbns;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public List<Integer> getScores() {
        return scores;
    }

    public void setScores(List<Integer> scores) {
        this.scores = scores;
    }

    public List<Double> getPrices() {
        return prices;
    }

    public void setPrices(List<Double> prices) {
        this.prices = prices;
    }

    public List<LocalDate> getImportantDates() {
        return importantDates;
    }

    public void setImportantDates(List<LocalDate> importantDates) {
        this.importantDates = importantDates;
    }

    public List<String> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(List<String> orderIds) {
        this.orderIds = orderIds;
    }

    public List<String> getOrderEmails() {
        return orderEmails;
    }

    public void setOrderEmails(List<String> orderEmails) {
        this.orderEmails = orderEmails;
    }

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