package by.vstu.isit.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    private String name;
    int age;
    Address address;
    String email;
    String phone;
    LocalDate dateOfBirth;
}
