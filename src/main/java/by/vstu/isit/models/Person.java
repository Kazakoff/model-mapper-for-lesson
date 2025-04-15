package by.vstu.isit.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@Builder
class Person {
    String name;
    int age;
    Address address;
    String email;
    String phone;
    LocalDate dateOfBirth;
}
