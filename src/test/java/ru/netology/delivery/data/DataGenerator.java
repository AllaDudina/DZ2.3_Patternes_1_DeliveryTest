package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;

import javax.lang.model.element.Name;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private static final Faker faker = new Faker(new Locale("ru"));
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        LocalDate currentDate = LocalDate.now();
        LocalDate generateDate = currentDate.plusDays(shift);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return generateDate.format(formatter);

    }

    public static String generateCity(String locale) {
        val city = faker.address().city();
        return city;
    }

    public static String generateName(String locale) {
        val name = faker.name().fullName();
        return name;
    }

    public static String generatePhone(String locale) {
        val phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            val city = generateCity(locale);
            val name = generateName(locale);
            val phone = generatePhone(locale);
            UserInfo user = new UserInfo(city, name, phone);
            return user;
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}