package ru.netology.delivery.test;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserInfo {
    private final String city;
    private final String name;
    private final String phone;
}