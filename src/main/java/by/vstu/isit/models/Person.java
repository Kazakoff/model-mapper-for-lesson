package by.vstu.isit.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Person {
    private String name;
    int age;
    Address address;
    String email;
    String phone;
    LocalDate dateOfBirth;
}
